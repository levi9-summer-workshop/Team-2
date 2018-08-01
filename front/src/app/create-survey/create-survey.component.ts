import { Component, OnInit, Output, EventEmitter, Input, ViewChild } from '@angular/core';
import { Observable } from '../../../node_modules/rxjs';
import { SurveyService } from '../survey/survey.service';
import { Question } from '../survey/question.model';
import { CommonModule } from '@angular/common';
import { NgForm } from '../../../node_modules/@angular/forms';
import { HttpErrorResponse } from '../../../node_modules/@angular/common/http';

@Component({
  selector: 'app-create-survey',
  templateUrl: './create-survey.component.html',
  styleUrls: ['./create-survey.component.css']
})
export class CreateSurveyComponent implements OnInit {

  questions$: Observable<Question[]>
  @ViewChild('f') saveQuestionForm: NgForm;
  selectedQuestion: Question = new Question(null, null, null);
  public multipleAnswers = [];
  public multipleAlowed : boolean;
  public singleAllowed: boolean;
  public textAllowed: boolean;
  public addChoice: boolean;
  public addQuestion: boolean;
  public i = 0;
  public j = 0;

  constructor(private surveyService: SurveyService) { }

  ngOnInit() {
  
    this.questions$ = this.surveyService.getQuestions();
    this.addQuestion = false
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

  checkTypeOfQuestion() {
    var e = document.getElementById("inputGroupSelect01") as HTMLSelectElement;
    var choice = e.options[e.selectedIndex].value;
  
    if(choice == "single") {
      this.addSingleAllowed();
      var singleButton = document.getElementById("addSingle") as HTMLButtonElement;
      singleButton.hidden = false;
      this.selectedQuestion.type = "radio"
    }
    else if(choice == "multiple"){
      this.addMultipleAlowed();
      var button = document.getElementById("addMultiple") as HTMLButtonElement;
      button.hidden = false;
      this.selectedQuestion.type = "checkbox";
    }
    else {
      this.addTextAllowed();
      this.selectedQuestion.type = "text";
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
    buttonMultiple.hidden = true;
    var buttonSingle = document.getElementById("addSingle") as HTMLButtonElement;
    buttonSingle.hidden = true;
    var e = document.getElementById("inputGroupSelect01") as HTMLSelectElement;
    e.options[e.selectedIndex].value = "0";
    
  }

  onQuestionAdd() {
    this.addQuestion = true;
  }



  onAddQuestionSubmit(form: NgForm, closeButton: HTMLButtonElement){
    const question: Question = new Question(
      this.selectedQuestion.id,
      form.value.title,
      this.selectedQuestion.type
    );
  this.surveyService.saveQuestion(question)
  .subscribe(
    () => {
      this.questions$ = this.surveyService.getQuestions();
      closeButton.click();
      this.addQuestion = true;
      this.saveQuestionForm.reset();
    },
    (httpErrorResponse: HttpErrorResponse) => {
      console.log("error")
      // console.error(error);
    }
  );
}

}