import { Component, OnInit } from '@angular/core';
import { Observable } from '../../../node_modules/rxjs';
import { Survey } from '../survey/survey.model';


import { SurveyService } from '../survey/survey.service';


@Component({
  selector: 'app-my-serveys',
  templateUrl: './my-serveys.component.html',
  styleUrls: ['./my-serveys.component.css']
})
export class MyServeysComponent implements OnInit {

  surveys$: Observable<Survey[]>
  selectedSurvey: Survey = new Survey(null, null, null, null, null);


  constructor(private surveyService: SurveyService) { }

  ngOnInit() {
    this.surveys$ = this.surveyService.getSurveys();

  }
}