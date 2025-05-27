import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class GeneratorService {
  private apiUrl = 'http://localhost:8080/api/generator'; // <-- adapter le port

  constructor(private http: HttpClient) {}

  generate(data: any): Observable<any> {
    return this.http.post(`${this.apiUrl}`, data,{ responseType: 'text' });
  }
}
