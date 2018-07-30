import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from './login/auth.service';
import { User } from './users/user.model';
@Injectable()
export class EmailService {
  APIRegistration = 'http://localhost:8080/email/registration';
  APISurveyAnswered = 'http://localhost:8080/email/survey_answered'

  constructor(private httpClient: HttpClient, private authService: AuthService) { }

  sendRegistrationEmail(user:User){
    return this.httpClient.post(this.APIRegistration, user, {headers: this.authService.getAuthHeaders()});
  }
}