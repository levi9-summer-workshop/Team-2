import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../login/auth.service';
import { Survey } from './survey.model';
import { Observable } from '../../../node_modules/rxjs';
import { Question } from './question.model';

@Injectable()
export class SurveyService {

  APIQuestion = 'http://localhost:8080/question';

  constructor(private httpClient: HttpClient, private authService: AuthService) {

   }

   getQuestions(): Observable<Question[]> {
     return this.httpClient.get<Question[]>(this.APIQuestion, { headers: this.authService.getAuthHeaders() });
   }

   saveQuestion(question: Question): Observable<any> {
    return this.httpClient.post(this.APIQuestion, question, { headers: this.authService.getAuthHeaders() });
  }
}
