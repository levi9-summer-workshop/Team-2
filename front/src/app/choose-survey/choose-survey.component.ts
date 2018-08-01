import { Component, OnInit, Input } from '@angular/core';
import { Observable } from '../../../node_modules/rxjs';
import { Survey } from '../survey/survey.model';
import { SurveyService } from '../survey/survey.service';

@Component({
  selector: 'app-choose-survey',
  templateUrl: './choose-survey.component.html',
  styleUrls: ['./choose-survey.component.css']
})
export class ChooseSurveyComponent implements OnInit {

  surveyId: number;
  surveys$: Observable<Survey[]>

  constructor(private surveyService: SurveyService) { }

  ngOnInit() {

    this.surveys$ = this.surveyService.getSurveys();
  }

  onSurveyChoose(id: number) {
    this.surveyId = id;
  }
}
