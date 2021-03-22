import { Component, HostListener, OnInit } from '@angular/core';
import { StudentService } from '../student.service';
import { Student } from '../../models/models';
import { FormBuilder, FormGroup } from '@angular/forms';
import { SortableHeaders } from '../../common/sortable-headers';
import { delay } from 'rxjs/operators';

@Component({
  selector: 'app-students-list',
  templateUrl: './students-list.component.html',
  styleUrls: ['./students-list.component.css'],
})
export class StudentsListComponent implements OnInit {
  private pageNumber;
  private isLastPage;
  loading = false;
  searchForm: FormGroup;
  students: Student[];
  query: string;
  sortableHeaders: SortableHeaders;

  constructor(
    private formBuilder: FormBuilder,
    private studentService: StudentService
  ) {}

  ngOnInit(): void {
    this.sortableHeaders = new SortableHeaders(
      ['Imię', 'Nazwisko', 'Pseudonim', 'Miasto', 'Email', 'Numer telefonu'],
      ['firstName', 'lastName', 'nick', 'city', 'email', 'phoneNumber'],
      [10, 15, 20, 10, 30, 15]
    );
    this.loadNextPage();
    this.resetPaging();
    this.searchForm = this.formBuilder.group({
      query: '',
      active: false,
    });
  }

  resetPaging(): void {
    this.query = null;
    this.pageNumber = 0;
    this.isLastPage = false;
    this.students = [];
  }

  sortChange(name: string): void {
    this.sortableHeaders.changeOrder(name);
    this.resetPaging();
    this.loadNextPage();
  }

  loadNextPage(): void {
    this.loading = true;
    this.studentService
      .getAllStudentsBy(
        this.pageNumber,
        this.query,
        this.sortableHeaders.getCurrentSort()
      )
      .pipe(delay(500))
      .subscribe((students) => {
        this.students = this.students.concat(students.content);
        this.isLastPage = students.last;
        this.pageNumber++;
        this.loading = false;
      });
  }

  search(): void {
    this.resetPaging();
    this.query = this.searchForm.value.query;
    this.loadNextPage();
  }

  @HostListener('window:scroll', ['$event'])
  onScroll(event): void {
    if (
      !this.isLastPage &&
      window.innerHeight + window.scrollY >= document.body.offsetHeight
    ) {
      this.loadNextPage();
    }
  }
}
