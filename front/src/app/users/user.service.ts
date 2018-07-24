import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from './user.model';
import { AuthService } from '../login/auth.service';

@Injectable()
export class UserService {

  blocked: Boolean;
  APIRegistration = 'http://localhost:8080/registration';
  APIUsers = 'http://localhost:8080/users';

  constructor(private httpClient: HttpClient, private authService: AuthService) { }

  getUsers(): Observable<User[]> {
    console.log("here")
    return this.httpClient.get<User[]>(this.APIUsers, { headers: this.authService.getAuthHeaders() });
  }



  deleteUser(userId: number){
    return this.httpClient.delete(this.APIUsers + '/' + (userId), { headers: this.authService.getAuthHeaders() });
  }

  saveUser(user: User): Observable<any> {
    return this.httpClient.post(this.APIRegistration, user);
  }

  blockUser(user: User): Observable<any> {
    return this.httpClient.put(this.APIUsers, user, { headers: this.authService.getAuthHeaders() });
  }

  

  
}
