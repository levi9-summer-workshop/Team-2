import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../login/auth.service';
import { Observable } from '../../../node_modules/rxjs';

@Injectable()
export class SurveyService {

  APISurvey = 'http://localhost:8080/survey';
  APIQuestion = 'http://localhost:8080/question';

  constructor(private httpClient: HttpClient, private authService: AuthService) {

  }

   getSurvey(surveyId: number): Observable<any> {
     return this.httpClient.get(this.APISurvey + '/' + (surveyId), { headers: this.authService.getAuthHeaders() });
  }
}
