import { IUser } from './../../models/IUser';
import { LoansService } from './../../services/loans.service';
import { IBook } from './../../models/IBook';
import { BooksService } from './../../services/books.service';
import { Component, OnInit } from '@angular/core';
import { catchError, tap, throwError } from 'rxjs';

@Component({
  selector: 'app-libros',
  templateUrl: './libros.component.html',
  styleUrls: ['./libros.component.scss'],
})

export class LibrosComponent implements OnInit {
  protected books: IBook[] | undefined;
  protected isLoading: boolean = true;
  protected error: boolean = false;
  protected requestLoanError: { error: boolean, message: string } = { error: false, message: "Error" };

  constructor(private booksService: BooksService, private loansService: LoansService) { }

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
          return throwError(() => new Error("El servidor no respondió. Asegúrese de que se esté ejecutando la API y la base de datos"))
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
            return throwError(() => new Error("El servidor no respondió. Asegúrese de que se esté ejecutando la API y la base de datos"))
          })
        )
        .subscribe();
    }
    else {
      location.reload();
    }
  }

  requestBook(book: IBook) {

    //TODO Obtener el usuario logueado de user.service
      const loggedUser : IUser | undefined = {
        "id": 1,
        "name": "juan",
        "lastName": "perez",
        "address": "Calle falsa 1",
        "phone": "1234567689",
        "email": "email@email.com",
        "password": "123456",
        "sanctions": 0,
        "sanctionsAmount": 0
      }
      
    /* if (usuario efectivamente logueado) { */
      this.loansService.postLoan(book, loggedUser)
        .pipe(
          tap(res => {
            return res;
          }),
          catchError(err => {
            this.requestLoanError.error = true;
            this.requestLoanError.message = "Error al solicitar el préstamo.";
            return throwError(() => new Error("Error al solicitar el préstamo."))
          })
        )
        .subscribe();
    /* } else {
      this.requestLoanError.error = true;
      this.requestLoanError.message = "Inicie sesión para solicitar el préstamo";
      return throwError(() => new Error("Inicie sesión para solicitar el préstamo"))
    } */
  }

}