import { Component, OnInit } from '@angular/core';
import { SurveyService } from '../survey/survey.service';
import { Observable } from 'rxjs';
import { AuthService } from '../login/auth.service';
import { Survey } from '../survey/survey.model';

@Component({
  selector: 'app-my-serveys',
  templateUrl: './my-serveys.component.html',
  styleUrls: ['./my-serveys.component.css']
})
export class MyServeysComponent implements OnInit {

  mySurveys$: Observable<Survey[]>;
  currentUser: string;
  selectedSurvey: Survey;
  surveyId: number;

  constructor(public surveyService: SurveyService, public authService: AuthService) { }

  ngOnInit() {
  
    this.mySurveys$ = this.surveyService.getUsersSurveys(this.surveyId);
    console.log(this.mySurveys$);
    this.currentUser = this.authService.getUsername();
    console.log(this.currentUser);

  }

  ifEmptyArraySurveys() {
    if (this.mySurveys$.isEmpty() ) {
      return true;
    }
    else {
      return false;
    }
  }


}
