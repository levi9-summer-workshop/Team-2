import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../login/auth.service';
import { Observable } from '../../../node_modules/rxjs';
import { Survey } from './survey.model';

@Injectable()
export class SurveyService {

  APISurvey = 'http://localhost:8080/survey';
  APIQuestion = 'http://localhost:8080/question';

  id: number;

  set surveysId(value: number) {
     this.id = value;
  }

  get surveysId(): number {
    return this.id;
  }

  constructor(private httpClient: HttpClient, private authService: AuthService) {

  }

  getSurveys(): Observable<Survey[]> {
    return this.httpClient.get<Survey[]>(this.APISurvey, { headers: this.authService.getAuthHeaders() })
  }

  getSurvey(surveyId: number): Observable<any> {
     return this.httpClient.get(this.APISurvey + '/' + (surveyId), { headers: this.authService.getAuthHeaders() });
  }
}
