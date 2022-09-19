import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-search-input',
  templateUrl: './search-input.component.html',
  styleUrls: ['./search-input.component.scss'],
})
/*TODO Hacerlo funcional y reutilizable */
export class SearchInputComponent implements OnInit {
  @Input() placeholder: string = '';

  constructor() {}

  ngOnInit(): void {}
}
