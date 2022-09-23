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
  protected isLoading: boolean = true;

  constructor(private booksService: BooksService) {
    this.booksService
      .getBooks()
      .pipe(
        tap((response) => {
          this.books = response;
          this.isLoading = false;
          return response;
        })
      )
      .subscribe();
  }

  ngOnInit(): void {}
}
