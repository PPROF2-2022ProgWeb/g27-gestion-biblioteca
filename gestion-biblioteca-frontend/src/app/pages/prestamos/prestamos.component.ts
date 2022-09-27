import { Component, OnInit } from '@angular/core';
import { ILoan } from 'src/app/models/ILoan';
import { LoansService } from './../../services/loans.service';
import { tap } from 'rxjs';

@Component({
  selector: 'app-prestamos',
  templateUrl: './prestamos.component.html',
  styleUrls: ['./prestamos.component.scss']
})
export class PrestamosComponent implements OnInit {
  protected loans: ILoan[] | undefined;
  protected isLoading: boolean = true;

  constructor(private loansService: LoansService) {
    this.loansService
      .getloans()
      .pipe(
        tap((response) => {
          this.loans = response;
          this.isLoading = false;
          return response;
        })
      )
      .subscribe();
  }

  ngOnInit(): void {}
}
