import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ProfileService {
  private readonly apiUrl2 = 'http://localhost:8084/api/profiles/byemail/';
  private readonly apiUrl1 = 'http://localhost:8084/api/profiles/';
  constructor(private http: HttpClient) {}

  getProfileByEmail(profileEmail: string): Observable<any> {
    const completeUrl = this.apiUrl2 + profileEmail;
    return this.http.get(completeUrl);
  }

  deleteProfileByEmail(profileEmail: string): Observable<any> {
    const completeUrl = this.apiUrl1 + 'delete/' + profileEmail;
    return this.http.delete(completeUrl);
  }

  getAllProfiles(): Observable<any[]> {
    const completeUrl = 'http://localhost:8084/api/profiles/all';
    return this.http.get<any[]>(completeUrl);
  }
}
