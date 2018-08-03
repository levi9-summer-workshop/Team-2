import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { SurveyService } from '../survey/survey.service';
import { Question } from '../question/question.model';
import { CommonModule } from '@angular/common';
import { Choice } from '../Choice/choice.model';
import { Survey } from '../survey/survey.model';
import { NgForm } from '../../../node_modules/@angular/forms';
import { HttpErrorResponse } from '../../../node_modules/@angular/common/http';

@Component({
  selector: 'app-create-survey',
  templateUrl: './create-survey.component.html',
  styleUrls: ['./create-survey.component.css']
})
export class CreateSurveyComponent implements OnInit {

  survey: Survey;
  survey$: Observable<Survey[]>;
  questions$: Observable<Question[]>;
  question: Question[] = [];
  choice: Choice[] = [];
  public multipleAnswers = [];
  public multipleAlowed : boolean;
  public singleAllowed: boolean;
  public textAllowed: boolean;
  public addChoice: boolean;
  public i = 0;
  public questionCounter = 0;
  public choiceCounter = 0;
  error: { title: string };

  constructor(private surveyService: SurveyService) { }

  ngOnInit() {

    this.multipleAnswers= [];
    while(this.i < 1) {
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

  checkTypeOfQuestion() {
    var e = document.getElementById("inputGroupSelect01") as HTMLSelectElement;
    var choice = e.options[e.selectedIndex].value;
    if(choice == "single") {
      this.addSingleAllowed();
      var singleButton = document.getElementById("addSingle") as HTMLButtonElement;
    }
    else if(choice == "multiple"){
      this.addMultipleAlowed();
      var button = document.getElementById("addMultiple") as HTMLButtonElement;
    }
    else {
      this.addTextAllowed();
    }
  }

  addSingleAllowed() {
    this.multipleAlowed = false;
    return this.singleAllowed = true;
    
  }

  addMultipleAlowed(): boolean {
    this.singleAllowed = false;
    return this.multipleAlowed = true; 
  }

  addTextAllowed() {
    this.singleAllowed = false;
    this.multipleAlowed = false;
    return this.textAllowed = true;
  }

  resetData() {
    this.singleAllowed = false;
    this.multipleAlowed = false;
    this.textAllowed = false;
    var buttonMultiple = document.getElementById("addMultiple") as HTMLButtonElement;
    var buttonSingle = document.getElementById("addSingle") as HTMLButtonElement;
  }

  addQuestion(value: any, questionType: any) {
    this.question.push(new Question(null, value, null, questionType, []));
  }

  addChoices(value: any) {
    this.question.length
    this.question[this.question.length - 1].choices.push(new Choice(value));
  }

  onSurveySubmit(title: any) {
    const survey: Survey = new Survey(
      title,
      null,
      this.question,
      null,
      null,
      null,
      null,
      null
    );
    this.surveyService.saveSurvey(survey)
    .subscribe(
      () => {
        this.survey$ = this.surveyService.getAllSurveys();
      },
    );
  }

  errorHandler(error) {
    switch (error.field) {
      case 'title':
        this.error.title = this.capitalize(error.message);
        break;
    }
  }

  capitalize(text) {
    return text[0].toUpperCase() + text.slice(1) + '!';
  }

  getCurrentDate() {
    return (new Date()).toISOString().slice(0, 10);
  }

}

