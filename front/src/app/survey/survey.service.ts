import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../login/auth.service';
import { Survey } from './survey.model';
import { Observable } from 'rxjs';
import { Question } from '../question/question.model';

@Injectable()
export class SurveyService {

  APIQuestion = 'http://localhost:8080/question';
  APISurvey = 'http://localhost:8080/survey'
  APIPublicSurveys = this.APISurvey + '/public'

  constructor(private httpClient: HttpClient, private authService: AuthService) {

   }

   getQuestions(): Observable<Question[]> {
     return this.httpClient.get<Question[]>(this.APIQuestion, { headers: this.authService.getAuthHeaders() });
   }

   getAllSurveys(): Observable<Survey[]> {
     return this.httpClient.get<Survey[]>(this.APISurvey,  { headers: this.authService.getAuthHeaders() } );
   }

   getPublicSurveys(): Observable<Survey[]> {
    return this.httpClient.get<Survey[]>(this.APIPublicSurveys,  { headers: this.authService.getAuthHeaders() } );
   }




}
