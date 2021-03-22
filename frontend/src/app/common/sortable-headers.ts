export class SortableHeaders {
  private columns: Column[] = [];

  public getColumns(): Column[] {
    return this.columns;
  }

  public getCurrentSort(): string {
    const sortedColumn = this.columns.filter(
      (col) => col.order !== SortingOrder.NONE
    )[0];
    return sortedColumn
      ? sortedColumn.property +
          ',' +
          (sortedColumn.order === SortingOrder.DOWN ? 'desc' : 'asc')
      : null;
  }

  constructor(names: string[], properties: string[], widths: number[]) {
    for (let i = 0; i < names.length; i++) {
      this.columns.push(
        new Column(names[i], properties[i], widths[i], SortingOrder.NONE)
      );
    }
  }

  changeOrder(name: string): void {
    this.columns = this.columns.map((col) => {
      if (col.name === name) {
        switch (col.order) {
          case SortingOrder.NONE:
          case SortingOrder.DOWN:
            col.order = SortingOrder.UP;
            break;
          case SortingOrder.UP:
            col.order = SortingOrder.DOWN;
        }
      } else {
        col.order = SortingOrder.NONE;
      }
      return col;
    });
  }
}

export class Column {
  name: string;
  property: string;
  width: number;
  order: SortingOrder;

  constructor(
    name: string,
    property: string,
    width: number,
    order: SortingOrder
  ) {
    this.name = name;
    this.property = property;
    this.width = width;
    this.order = order;
  }

  showIcon(): boolean {
    return this.order !== SortingOrder.NONE;
  }

  getIconClass(): string {
    switch (this.order) {
      case SortingOrder.DOWN:
        return 'bi-caret-down-fill';
      case SortingOrder.UP:
        return 'bi-caret-up-fill';
      case SortingOrder.NONE:
        return '';
    }
  }
}

export enum SortingOrder {
  UP,
  DOWN,
  NONE,
}
