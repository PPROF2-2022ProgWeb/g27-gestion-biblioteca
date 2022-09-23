import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root',
})

export class LoansService {
  constructor(private http: HttpClient) {}

  public getloans(): Observable<any> {
    return this.http.get<any>('http://localhost:8082/loans');
  }

  public getLoanById(id: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8082/loans/id/${id}`);
  }

  public getloansBydateOut(dateOut: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8082/loans/dateOut/${dateOut}`);
  }

  public getloansBydateReturn(dateReturn: string): Observable<any> {
    return this.http.get<any>(`http://localhost:8082/loans/dateReturn/${dateReturn}`);
  }

  public getloansByBook(book: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8082/loans/book/${book}`);
  }

  public getloansByuser(user: number): Observable<any> {
    return this.http.get<any>(`http://localhost:8082/loans/user/${user}`);
  }
  
}
