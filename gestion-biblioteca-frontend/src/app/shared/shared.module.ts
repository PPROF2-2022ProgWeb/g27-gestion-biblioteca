import { RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PaginationComponent } from './pagination/pagination.component';
import { SearchInputComponent } from './search-input/search-input.component';
import { FormsModule } from '@angular/forms';
import { ErrorFeedbackComponent } from './error-feedback/error-feedback.component';

@NgModule({
  declarations: [
    PaginationComponent,
    SearchInputComponent,
    ErrorFeedbackComponent
  ],
  imports: [
    CommonModule, RouterModule, FormsModule
  ],
  exports: [PaginationComponent, SearchInputComponent, ErrorFeedbackComponent]
})
export class SharedModule { }