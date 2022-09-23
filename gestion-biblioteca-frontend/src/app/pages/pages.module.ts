import { FormsModule } from '@angular/forms';
import { SharedModule } from './../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotFoundComponent } from './not-found/not-found.component';
import { LibrosComponent } from './libros/libros.component';
import { SearchWidgetComponent } from './libros/search-widget/search-widget.component';
import { InicioComponent } from './inicio/inicio.component';
import { LoginComponent } from './usuarios/login/login.component';

@NgModule({
  declarations: [NotFoundComponent, LibrosComponent, SearchWidgetComponent, InicioComponent, LoginComponent],
  imports: [CommonModule, SharedModule, FormsModule],
  exports: [NotFoundComponent, LibrosComponent, InicioComponent, LoginComponent]
})

export class PagesModule { }
