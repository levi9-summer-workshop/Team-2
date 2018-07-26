import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AuthService } from '../login/auth.service';
import { Survey } from './survey.model';
import { Question } from './question.model';

@Injectable()
export class SurveyService {

  APISurvey = "http://localhost:8080/survey"
  APIQuestion = "http://localhost:8080/question"

  constructor(private httpClient: HttpClient, private authService: AuthService) { }

  saveSurvey(survey: Survey): Observable<any> {
    return this.httpClient.post(this.APISurvey, survey,  { headers: this.authService.getAuthHeaders() } );
  }

  saveQuestion(question: Question): Observable<any> {
    return this.httpClient.post(this.APIQuestion, question, { headers: this.authService.getAuthHeaders() } );
  }
}
