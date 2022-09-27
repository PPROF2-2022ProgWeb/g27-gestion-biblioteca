import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';
import { IPublicUserInfo } from 'src/app/models/IUser';
import { AuthService } from '@auth0/auth0-angular';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.scss'],
})
export class SidebarComponent implements OnInit {
  @Input() user: IPublicUserInfo = {
    avatar: '../../../assets/icons/avatar.svg',
    name: 'Usuario',
    id: 999,
  };



  isMenuOpen = false;

  toggleMenu(): void {
    this.isMenuOpen = !this.isMenuOpen;
    console.log(this.router.url);
  }

  constructor(protected router: Router) {}


 

  ngOnInit(): void {}
}
