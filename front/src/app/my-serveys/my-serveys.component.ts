import { Component, OnInit } from '@angular/core';
import { SurveyService } from '../survey/survey.service';
import { Observable } from 'rxjs/Observable';
import { AuthService } from '../login/auth.service';
import { Survey } from '../survey/survey.model';
import { Button } from '../../../node_modules/protractor';

@Component({
  selector: 'app-my-serveys',
  templateUrl: './my-serveys.component.html',
  styleUrls: ['./my-serveys.component.css']
})
export class MyServeysComponent implements OnInit {

  mySurveys$: Observable<Survey[]>;
  selectedSurvey: Survey;
  surveyId: number;
  survey:Survey;

  checkPrivacy(survey:Survey) {
    if(survey.surveyPrivacy.privacyType == 'PRIVATE'){
     return true;
    }else {
      return false;
    }
  }


  constructor(public surveyService: SurveyService, public authService: AuthService) { }
 

  ngOnInit() {
    this.mySurveys$ = this.surveyService.getUsersSurveys();
    this.selectedSurvey= new Survey(null, null, null, null, null, null, null, null);
  }

  onSurveyChoose(value: number) {
    this.surveyService.id = value;
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
        this.mySurveys$ = this.surveyService.getUsersSurveys();
        this.selectedSurvey = new Survey(null, null, null, null, null, null, null, null);
      }
    )
  }

  onSurveyBtnPublic(survey:Survey) {
    this.surveyService.setSurveyPublic(survey)
    .subscribe (
      () => {
        this.mySurveys$ = this.surveyService.getUsersSurveys();
        this.selectedSurvey = new Survey(null, null, null, null, null, null, null, null);
      }
    );
  }

  onSurveyBtnPrivate(survey:Survey) {
    this.surveyService.setSurveyPrivate(survey)
    .subscribe(
       () => {
        this.mySurveys$ = this.surveyService.getUsersSurveys();
        this.selectedSurvey = new Survey(null, null, null, null, null, null, null, null);
      }
    );
  }



}
