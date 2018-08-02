import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../login/auth.service';
import { Question } from '../question/question.model';
import { Survey } from './survey.model';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class SurveyService {

  id: number;

  set surveysId(value: number) {
     this.id = value;
  }

  get surveysId(): number {
    return this.id;
  }

  APISurvey = 'http://localhost:8080/survey';
  APIQuestion = 'http://localhost:8080/question';
  APIPublicSurveys = this.APISurvey + '/public';
  

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

   getUsersSurveys(): Observable<Survey[]> {
    
     return this.httpClient.get<Survey[]>(this.APISurvey + '/user/id', { headers: this.authService.getAuthHeaders() } )
   }

  getSurveys(): Observable<Survey[]> {
    return this.httpClient.get<Survey[]>(this.APISurvey, { headers: this.authService.getAuthHeaders() })
  }

  getSurvey(surveyId: number): Observable<any> {
     return this.httpClient.get(this.APISurvey + '/' + (surveyId), { headers: this.authService.getAuthHeaders() });
  }
}
