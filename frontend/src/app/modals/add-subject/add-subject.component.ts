import {
  Component,
  ElementRef,
  EventEmitter,
  OnInit,
  Output,
  ViewChild,
} from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CommonService } from '../../common/common.service';
import { Subject } from '../../models/models';

@Component({
  selector: 'app-add-subject',
  templateUrl: './add-subject.component.html',
  styleUrls: ['./add-subject.component.css'],
})
export class AddSubjectComponent implements OnInit {
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
      name: '',
    });
  }

  onSubmit(formValue): void {
    if (formValue.name !== '') {
      this.commonService
        .addSubject({
          name: formValue.name,
        } as Subject)
        .subscribe(() => {
          this.closeButton.nativeElement.click();
          this.successfulAddition.emit(null);
        });
    } else {
      this.displayValidation = true;
    }
  }
}
