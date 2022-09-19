import { SharedModule } from './../shared/shared.module';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NotFoundComponent } from './not-found/not-found.component';
import { LibrosComponent } from './libros/libros.component';
import { SearchWidgetComponent } from './libros/search-widget/search-widget.component';

@NgModule({
  declarations: [NotFoundComponent, LibrosComponent, SearchWidgetComponent],
  imports: [CommonModule, SharedModule],
  exports: [NotFoundComponent, LibrosComponent]
})
export class PagesModule {}
