import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { Observable } from 'rxjs';
import { SurveyService } from '../survey/survey.service';
import { Question } from '../question/question.model';
import { CommonModule } from '@angular/common';

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
  public textAllowed: boolean;
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

  checkTypeOfQuestion() {
    var e = document.getElementById("inputGroupSelect01") as HTMLSelectElement;
    var choice = e.options[e.selectedIndex].value;
    console.log(choice);
    if(choice == "single") {
      this.addSingleAllowed();
      var singleButton = document.getElementById("addSingle") as HTMLButtonElement;
      singleButton.hidden = false;
    }
    else if(choice == "multiple"){
      this.addMultipleAlowed();
      var button = document.getElementById("addMultiple") as HTMLButtonElement;
      button.hidden = false;
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
    buttonMultiple.hidden = true;
    var buttonSingle = document.getElementById("addSingle") as HTMLButtonElement;
    buttonSingle.hidden = true;
    
  }

  onAddQuestionSubmit(){

  }
  onAddQuestion(question : any){

  }
}
