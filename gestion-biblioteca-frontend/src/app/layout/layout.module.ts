import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SidebarComponent } from './sidebar/sidebar.component';
import { MenuIcoComponent } from './menu-ico/menu-ico.component';

@NgModule({
  declarations: [SidebarComponent, MenuIcoComponent],
  imports: [CommonModule, RouterModule],
  exports: [SidebarComponent, MenuIcoComponent],
})

export class LayoutModule {}
