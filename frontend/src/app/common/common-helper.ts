import { formatDate } from '@angular/common';

export function convertDate(date: Date, canBeNull = false): string {
  if (canBeNull && !date) {
    return '';
  }
  return formatDate(date, 'yyyy-MM-dd', 'en');
}

export function isNumberKey(evt): boolean {
  const charCode = evt.which ? evt.which : evt.keyCode;
  return (charCode > 47 && charCode < 58) || charCode === 43;
}
