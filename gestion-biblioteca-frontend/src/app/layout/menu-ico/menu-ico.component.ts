import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-menu-ico',
  templateUrl: './menu-ico.component.html',
  styleUrls: ['./menu-ico.component.scss'],
})
export class MenuIcoComponent implements OnInit {
  @Input() isOpen: boolean = false;

  constructor() {}

  ngOnInit(): void {}
}
