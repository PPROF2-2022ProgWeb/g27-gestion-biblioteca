import { API_URL } from './services.properties';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})
export class BooksService {
  constructor(private http: HttpClient) { }

  public getBooks(): Observable<any> {
    return this.http.get<any>(`${API_URL}books`);
  }

  public getBookById(id: number): Observable<any> {
    return this.http.get<any>(`${API_URL}books/id/${id}`);
  }

  public getBooksByTitle(title: string): Observable<any> {
    return this.http.get<any>(`${API_URL}books/title/${title}`);
  }

  public getBooksByAuthor(author: string): Observable<any> {
    return this.http.get<any>(`${API_URL}books/author/${author}`);
  }

  public getBooksByCategory(category: string): Observable<any> {
    return this.http.get<any>(
      `${API_URL}books/category/${category}`
    );
  }

  /* private createBook(book: IBook): Observable<any> {
    return this.http.post<any>('http://localhost:8082/books/save', {
      body: JSON.stringify(book),
    });
  } */
}
