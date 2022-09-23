import { API_URL } from './services.properties';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class BooksService {
  constructor(private http: HttpClient) { }

  public getBooksBy({ type, arg }: { type?: string, arg?: string }): Observable<any> {
    switch (type) {
      case "title":
        return this.http.get<any>(`${API_URL}books/title/${arg}`);
      case "isbn":
        return this.http.get<any>(`${API_URL}books/id/${arg}`);
      case "author":
        return this.http.get<any>(`${API_URL}books/author/${arg}`);
      case "category":
        return this.http.get<any>(`${API_URL}books/category/${arg}`);
      default:
        return this.http.get<any>(`${API_URL}books`);
    }
  }

  /* private createBook(book: IBook): Observable<any> {
    return this.http.post<any>('http://localhost:8082/books/save', {
      body: JSON.stringify(book),
    });
  } */
}
