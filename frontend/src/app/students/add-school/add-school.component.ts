import {Component, OnInit, Output, EventEmitter, ViewChild, ElementRef} from '@angular/core';
import {EducationLevel, School} from '../../models/models';
import {FormBuilder, FormGroup} from '@angular/forms';
import {CommonService} from '../../common/common.service';
import {cities} from '../../common/cities';

@Component({
  selector: 'app-add-school',
  templateUrl: './add-school.component.html',
  styleUrls: ['./add-school.component.css']
})
export class AddSchoolComponent implements OnInit {

  @Output() successfulAddition = new EventEmitter<any>();
  @ViewChild('closeButton') closeButton: ElementRef;

  newSchoolForm: FormGroup;
  displayValidation = false;

  constructor(
    private formBuilder: FormBuilder,
    private commonService: CommonService
  ) {}

  ngOnInit(): void {
    this.newSchoolForm = this.formBuilder.group({
      schoolName: '',
      street: '',
      city: null,
      level: null
    });
  }

  onSubmit(formValue): void {
    console.log(formValue);
    if (formValue.schoolName !== '') {
      this.commonService.addSchool({
        name: formValue.schoolName,
        street: formValue.street,
        city: formValue.city,
        level: formValue.level,
      } as School).subscribe(() => {
        this.closeButton.nativeElement.click();
        this.successfulAddition.emit(null);
      });
    } else {
      this.displayValidation = true;
    }
  }

  getSchoolLevels(): EducationLevel[] {
    return Object.values(EducationLevel);
  }

  getCities(): string[] {
    return cities;
  }

}
