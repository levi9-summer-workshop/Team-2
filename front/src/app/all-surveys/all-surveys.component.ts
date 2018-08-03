import { Component, OnInit } from '@angular/core';
import { Observable } from '../../../node_modules/rxjs';
import { Survey } from '../survey/survey.model';
import { SurveyService } from '../survey/survey.service';

@Component({
  selector: 'app-all-surveys',
  templateUrl: './all-surveys.component.html',
  styleUrls: ['./all-surveys.component.css']
})
export class AllSurveysComponent implements OnInit {

  surveyId: number;
  surveys$: Observable<Survey[]>

  constructor(private surveyService: SurveyService) { 
    
  }

  ngOnInit() {
    this.surveys$ = this.surveyService.getSurveys();
  }

  onSurveyChoose(value: number) {
    this.surveyService.id = value;
  }
}
