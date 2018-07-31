import { Component, OnInit } from '@angular/core';
import { Observable } from '../../../node_modules/rxjs';

import { SurveyService } from '../survey/survey.service';
import { Question } from '../survey/question.model';

@Component({
  selector: 'app-create-survey',
  templateUrl: './create-survey.component.html',
  styleUrls: ['./create-survey.component.css']
})
export class CreateSurveyComponent implements OnInit {

  questions$: Observable<Question[]>
  public multipleAnswers = [];
  public multipleAlowed : boolean;
  public singleAllowed: boolean;
  public addChoice: boolean;
  public i = 0;

  constructor(private surveyService: SurveyService) { }

  ngOnInit() {
  
    this.questions$ = this.surveyService.getQuestions();

    this.multipleAnswers= [];
    while(this.i < 2) {
      this.multipleAnswers[this.i] = "item " + this.i;

      this.i++;
    }
  }

  addMoreChoices() {

    this.multipleAnswers[this.i];
    this.multipleAnswers[this.i] = "item " + this.i;
    this.i++;
  }

  deleteChoice() {
  
    this.multipleAnswers.pop();
    this.i--;
  }

  addSingleAllowed() {
    this.multipleAlowed = false;
    return this.singleAllowed = true;
    
  }

  addMultipleAlowed(): boolean {
    this.singleAllowed = false;
    return this.multipleAlowed = true; 
  }

  resetData() {
    this.singleAllowed = false;
    this.multipleAlowed = false;
  }

  onAddQuestionSubmit(){

  }
  onAddQuestion(question : any){

  }
}
