import { RouterModule } from '@angular/router';
import { PrestamosComponent } from './prestamos/prestamos.component';
import { FormsModule } from '@angular/forms';
import { SharedModule } from './../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotFoundComponent } from './not-found/not-found.component';
import { LibrosComponent } from './libros/libros.component';
import { SearchWidgetComponent } from './libros/search-widget/search-widget.component';
import { InicioComponent } from './inicio/inicio.component';
import { DashboardComponent } from './usuarios/dashboard/dashboard.component';

@NgModule({
  declarations: [NotFoundComponent, LibrosComponent, SearchWidgetComponent, InicioComponent, DashboardComponent, PrestamosComponent],
  imports: [CommonModule, SharedModule, FormsModule, RouterModule],
  exports: [NotFoundComponent, LibrosComponent, InicioComponent, DashboardComponent]
})

export class PagesModule { }