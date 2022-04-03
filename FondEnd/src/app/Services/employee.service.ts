import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../models/Employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class EmployeeService {
  private apiURL = 'https://83ad-2800-e2-5a80-c08-a861-c5ba-5b69-3e76.ngrok.io';
  

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };

  constructor(private httpClient: HttpClient) {}

  getEmployees(): Observable<any> {
    return this.httpClient.get(`${this.apiURL}/employe`, this.httpOptions);
  }

  getEmployee(id: string): Observable<any> {
    return this.httpClient.get(`${this.apiURL}/employe/${id}`, this.httpOptions);
  }

  createEmployee(employee: Employee): Observable<any> {
    return this.httpClient.post(
      `${this.apiURL}/employe`,
      employee,
      this.httpOptions
    );
  }

  updateEmployee(id: string, employee: Employee): Observable<any> {
    return this.httpClient.put(
      `${this.apiURL}/employe/${id}`,
      employee,
      this.httpOptions
    );
  }

  deleteEmployee(id: string): Observable<any> {
    return this.httpClient.delete(`${this.apiURL}/employe/${id}`, this.httpOptions);
  }
}
