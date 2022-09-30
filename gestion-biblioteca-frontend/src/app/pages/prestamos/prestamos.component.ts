import { Component, OnInit } from '@angular/core';
import { ILoan } from 'src/app/models/ILoan';
import { LoansService } from './../../services/loans.service';
import { tap, catchError, throwError } from 'rxjs';

@Component({
  selector: 'app-prestamos',
  templateUrl: './prestamos.component.html',
  styleUrls: ['./prestamos.component.scss']
})
export class PrestamosComponent implements OnInit {
  protected loans: ILoan[] | undefined;
  protected isLoading: boolean = true;
  protected error: boolean = false;

  constructor(private loansService: LoansService) {
    this.loansService
      .getloans()
      .pipe(
        tap((response) => {
          if (response) {
            this.loans = response;
          } else {
            this.loans = []
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
  
  getDaysLeftToReturn(dateOfReturn: string) {
    const currentDate = new Date().getTime();
    const returnDate = new Date(dateOfReturn).getTime();
    return Math.ceil(((returnDate - currentDate)/(1000*60*60*24)));
  }

  ngOnInit(): void {}
}
