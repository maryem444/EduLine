import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserJwtService {

  userUrl = 'http://localhost:8083/api/auth';
  constructor(private httpClient: HttpClient) { }

  register(signupRequest: any): Observable<any>{
    return this.httpClient.post(this.userUrl+ "/signup", signupRequest);
  }

  login(loginRequest:any): Observable<any>{
    return this.httpClient.post(this.userUrl+ "/login", loginRequest);
  }
}
