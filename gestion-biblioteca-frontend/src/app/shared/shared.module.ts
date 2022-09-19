import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PaginationComponent } from './pagination/pagination.component';
import { SearchInputComponent } from './search-input/search-input.component';

@NgModule({
  declarations: [
    PaginationComponent,
    SearchInputComponent
  ],
  imports: [
    CommonModule, RouterModule
  ],
  exports: [PaginationComponent, SearchInputComponent]
})
export class SharedModule { }
