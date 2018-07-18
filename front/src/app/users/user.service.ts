import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from './user.model';

@Injectable()
export class UserService {

  APIRegistration = 'http://localhost:8080/registration';
  APIUsers = 'http://localhost:8080/users';

  constructor(private httpClient: HttpClient) { }

  getUsers(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.APIUsers);
  }

  saveUser(user: User): Observable<any> {
    return this.httpClient.post(this.APIRegistration, user);
  }
}
