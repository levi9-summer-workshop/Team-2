import { Component, OnInit } from '@angular/core';
import { SurveyService } from '../survey/survey.service';
import { Observable } from 'rxjs/Observable';
import { AuthService } from '../login/auth.service';
import { Survey } from '../survey/survey.model';

@Component({
  selector: 'app-my-serveys',
  templateUrl: './my-serveys.component.html',
  styleUrls: ['./my-serveys.component.css']
})
export class MyServeysComponent implements OnInit {

  mySurveys$: Observable<Survey[]>;
  selectedSurvey: Survey = new Survey(null, null, null, null, null, null, null, null);
  surveyId: number;
  survey:Survey;

  constructor(public surveyService: SurveyService, public authService: AuthService) { }

  ngOnInit() {
  
    this.mySurveys$ = this.surveyService.getUsersSurveys();
    console.log(this.mySurveys$);
  }

  ifEmptyArraySurveys() {
    if (this.mySurveys$.isEmpty() ) {
      return true;
    }
    else {
      return false;
    }
  }

  onSurveyDelete(survey:Survey){
    this.selectedSurvey = survey;
    this.surveyService.deleteSurvey(this.selectedSurvey.id)
    .subscribe(
      () => {
        this.mySurveys$ = this.mySurveys$ = this.surveyService.getUsersSurveys();
        this.selectedSurvey = new Survey(null, null, null, null, null, null, null, null);
      }
    )
  }


}
