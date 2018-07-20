import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from './user.model';

@Injectable()
export class UserService {

  APIRegistration = 'http://localhost:8080/users/registration';
  APIUsers = 'http://localhost:8080/users';

  constructor(private httpClient: HttpClient) { }

  getUsers(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.APIUsers);
  }


  deleteUser(userId: number){
    return this.httpClient.delete(this.APIUsers + '/' + (userId));
  }

  saveUser(user: User): Observable<any> {
    return this.httpClient.post(this.APIRegistration, user);
  }

  blockUser(user: User): Observable<any> {
    return this.httpClient.put(this.APIUsers, user);
  }
}
