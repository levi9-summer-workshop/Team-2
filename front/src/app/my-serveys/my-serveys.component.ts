import { Component, OnInit } from '@angular/core';
import { SurveyService } from '../survey/survey.service';
import { Observable } from 'rxjs';
import { Survey } from '../survey/survey.model';
import { User, AuthService } from '../login/auth.service';

@Component({
  selector: 'app-my-serveys',
  templateUrl: './my-serveys.component.html',
  styleUrls: ['./my-serveys.component.css']
})
export class MyServeysComponent implements OnInit {

  userSurveys$: Observable<Survey[]>;
  currentUser: User;
  selectedSurvey: Survey;
  


  constructor(public surveyService: SurveyService, public authService: AuthService) { }

  ngOnInit() {
  }

}
