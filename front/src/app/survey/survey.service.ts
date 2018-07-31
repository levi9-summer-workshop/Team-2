import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { AuthService } from '../login/auth.service';
import { Survey } from './survey.model';
import { Question } from './question.model';
import { Choices } from './choice.model';
import { surveyCss } from '../../../node_modules/survey-knockout';

@Injectable()
export class SurveyService {

  APISurvey = "http://localhost:8080/survey"
  APIQuestion = "http://localhost:8080/question"
  APIChoices = "http://localhost:8080/choices"

  constructor(private httpClient: HttpClient, private authService: AuthService) { }


  saveSurvey(survey: Survey): Observable<any> {

    return this.httpClient.post(this.APISurvey, survey,  { headers: this.authService.getAuthHeaders() } );
  }

  saveQuestion(question: Question): Observable<any> {
    return this.httpClient.post(this.APIQuestion, question, { headers: this.authService.getAuthHeaders() });
  }


  saveChoices(choices: Choices): Observable<any> {

    return this.httpClient.post(this.APIChoices, choices, { headers: this.authService.getAuthHeaders() } );
  }

  getSurveys(): Observable<Survey[]> {
    return this.httpClient.get<Survey[]>(this.APISurvey, { headers: this.authService.getAuthHeaders() });
  }

  deleteSurvey(id: number){
    return this.httpClient.delete(this.APISurvey + '/' + (id), { headers: this.authService.getAuthHeaders() });
  }

}
