import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ConfigService {

  private baseUrl = 'http://localhost:8081/api/rules'; // URL du backend config-service

  constructor(private http: HttpClient) {}

  saveConfig(config: any): Observable<any> {
    return this.http.post(this.baseUrl, config);
  }

  getAllConfigs(): Observable<any[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  getConfigById(configId: string): Observable<any> {
    return this.http.get(`${this.baseUrl}/${configId}`);
  }
}
