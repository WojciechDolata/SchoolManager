import { FormBuilder, FormGroup } from '@angular/forms';
import { SortableHeaders } from '../sortable-headers';
import { delay } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Page } from '../../models/models';

export abstract class BasicList<T> {
  private pageNumber;
  private isLastPage;
  loading = false;
  searchForm: FormGroup;
  items: T[];
  query: string;

  protected constructor(
    public formBuilder: FormBuilder,
    private service: BasicListService<T>,
    public sortableHeaders: SortableHeaders
  ) {}

  init(): void {
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
    this.items = [];
  }

  sortChange(name: string): void {
    this.sortableHeaders.changeOrder(name);
    this.resetPaging();
    this.loadNextPage();
  }

  loadNextPage(): void {
    this.loading = true;
    this.service
      .getAllBy(
        this.pageNumber,
        this.query,
        this.sortableHeaders.getCurrentSort()
      )
      .pipe(delay(500))
      .subscribe((itemsPage) => {
        this.items = this.items.concat(itemsPage.content);
        this.isLastPage = itemsPage.last;
        this.pageNumber++;
        this.loading = false;
      });
  }

  search(): void {
    this.resetPaging();
    this.query = this.searchForm.value.query;
    this.loadNextPage();
  }

  loadNextIfPossible(): void {
    if (
      !this.isLastPage &&
      window.innerHeight + window.scrollY >= document.body.offsetHeight
    ) {
      this.loadNextPage();
    }
  }
}

export interface BasicListService<T> {
  getAllBy(
    pageNumber: number,
    query: string,
    sort: string
  ): Observable<Page<T>>;
}
