import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-search-input',
  templateUrl: './search-input.component.html',
  styleUrls: ['./search-input.component.scss'],
})

export class SearchInputComponent implements OnInit {
  @Input() placeholder: string = '';
  @Output() textSearchEvent = new EventEmitter<string>();

  textField: string = "";

  sendSearchField(value: string) {
    this.textSearchEvent.emit(value);
  }

  constructor() { }

  ngOnInit(): void {
  }
}
