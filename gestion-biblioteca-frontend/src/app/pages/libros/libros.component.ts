import { IBook } from './../../models/IBook';
import { BooksService } from './../../services/books.service';
import { Component, OnInit } from '@angular/core';
import { tap } from 'rxjs';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.scss'],
})

export class LibrosComponent implements OnInit {
  protected books: IBook[] | undefined;
  protected isLoading: boolean = false;

  constructor(private booksService: BooksService) { }

  ngOnInit(): void {
    this.booksService.getBooksBy({})
      .pipe(
        tap((response) => {
          this.books = response;
          this.isLoading = false;
          return response;
        })
      )
      .subscribe();
  }

  search(params: any) {
    if (params.textField !== "") {
      this.booksService.getBooksBy({ type: params.type, arg: params.textField })
        .pipe(
          tap((response) => {
            if (params.textField !== "") {
              if (Array.isArray(response) && response) {
                this.books = response;
              } else if (!Array.isArray(response) && response) {
                this.books = [response]
              } else { this.books = [] }
            }
            this.isLoading = false;
            return response;
          })
        )
        .subscribe();
    }
    else {
      location.reload();
    }

  }

}