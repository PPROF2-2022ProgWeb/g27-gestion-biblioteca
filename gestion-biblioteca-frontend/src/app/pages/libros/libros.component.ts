import { IBook } from './../../models/IBook';
import { BooksService } from './../../services/books.service';
import { Component, OnInit } from '@angular/core';
import { catchError, tap, throwError, VirtualTimeScheduler } from 'rxjs';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.scss'],
})

export class LibrosComponent implements OnInit {
  protected books: IBook[] | undefined;
  protected isLoading: boolean = true;
  protected error: boolean = false;

  constructor(private booksService: BooksService) { }

  ngOnInit(): void {
    this.booksService.getBooksBy({})
      .pipe(
        tap((response) => {
          if (response) {
            this.books = response;
          } else {
            this.books = []
          }
          this.isLoading = false;
          return response;
        }),
        catchError(err => {
          this.error = true;
          this.isLoading = false;
          return throwError(() => new Error('El servidor no respondió. Asegúrese de que se esté ejecutando la API y la base de datos'))
        })
      )
      .subscribe()
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
          }),
          catchError(err => {
            this.error = true;
            this.isLoading = false;
            return throwError(() => new Error('El servidor no respondió. Asegúrese de que se esté ejecutando la API y la base de datos'))
          })
        )
        .subscribe();
    }
    else {
      location.reload();
    }
  }

}