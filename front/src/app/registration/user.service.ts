import { Injectable } from '@angular/core';
import { HttpClient } from '../../../node_modules/@angular/common/http';
import { Observable } from '../../../node_modules/rxjs/Observable';
import { User } from './user.model';

@Injectable()
export class UserService {

  API = 'http://localhost:8080/registration';

  constructor(private httpClient: HttpClient) { }

  getUsers(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.API);
  }

  saveUser(user: User): Observable<any> {
    return this.httpClient.post(this.API, user);
  }
}
