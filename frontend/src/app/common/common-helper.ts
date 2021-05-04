import { formatDate } from '@angular/common';

export function convertDateToFormat(
  date: Date,
  format = 'yyyy-MM-dd',
  canBeNull = false
): string {
  if (canBeNull && !date) {
    return '';
  }
  return formatDate(date, format, 'en');
}

export function convertDate(date: Date, canBeNull = false): string {
  return convertDateToFormat(date, 'yyyy-MM-dd', canBeNull);
}

export function isNumberKey(evt): boolean {
  const charCode = evt.which ? evt.which : evt.keyCode;
  return (charCode > 47 && charCode < 58) || charCode === 43;
}
