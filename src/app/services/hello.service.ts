import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ApiResponse } from '../models/api-response';

@Injectable({
  providedIn: 'root'
})

export class HelloService {
  private api = 'https://997f-103-156-2-109.ngrok-free.app/'; // Replace with your Spring Boot backend URL

  constructor(private http: HttpClient) {}

  // getGreetings(): Observable<string> {
  //   return this.http.get<string>(this.api, { responseType: 'text' })
  //     .map(response => response as string); // Type casting to string
  // }

  getData(): Observable<ApiResponse> {
    return this.http.get<ApiResponse>(this.api, { responseType: 'json' });
  }

  postData(data: any): Observable<any> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.http.post<any>(this.api + 'post', data, { headers });
  }
}
