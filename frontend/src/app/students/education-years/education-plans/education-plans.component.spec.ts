import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EducationPlansComponent } from './education-plans.component';

describe('EducationPlansComponent', () => {
  let component: EducationPlansComponent;
  let fixture: ComponentFixture<EducationPlansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [EducationPlansComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EducationPlansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
