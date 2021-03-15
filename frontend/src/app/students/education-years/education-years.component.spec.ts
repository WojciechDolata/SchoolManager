import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EducationYearsComponent } from './education-years.component';

describe('EducationYearsComponent', () => {
  let component: EducationYearsComponent;
  let fixture: ComponentFixture<EducationYearsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EducationYearsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EducationYearsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
