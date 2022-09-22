import { Component, OnInit, Output, EventEmitter } from '@angular/core';

interface ISearchBook {
  value: string;
  placeholder: string;
}

interface ISearch {
  type: string;
  textField: string;
}

@Component({
  selector: 'app-search-widget',
  templateUrl: './search-widget.component.html',
  styleUrls: ['./search-widget.component.scss'],
})

export class SearchWidgetComponent implements OnInit {

  @Output() searchEvent = new EventEmitter<ISearch>;

  searchOptions: ISearchBook[] = [
    { value: "title", placeholder: "Buscar por Título" },
    { value: "isbn", placeholder: "Buscar por ISBN" },
    { value: "author", placeholder: "Buscar por Autor" },
    { value: "category", placeholder: "Buscar por Género" },
  ]

  selectedSearchOption: ISearchBook = this.searchOptions[0];

  searchBy(event: string) {
    this.searchEvent.emit({ type: this.selectedSearchOption.value, textField: event })
  }

  /* For default selected option */
  compareByValue(x: ISearchBook, y: ISearchBook) {
    return x && y && x.value == y.value
  }
  
  constructor() { }

  ngOnInit(): void {
    this.selectedSearchOption = { value: "title", placeholder: "Buscar por Título" };
  }

}
