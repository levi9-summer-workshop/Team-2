import { Component, OnInit, Input } from '@angular/core';
import { Survey } from '../survey/survey.model';
import { Observable } from '../../../node_modules/rxjs';
import { SurveyService } from '../survey/survey.service';
import { ActivatedRoute } from '../../../node_modules/@angular/router';

@Component({
  selector: 'app-results',
  templateUrl: './results.component.html',
  styleUrls: ['./results.component.css']
})
export class ResultsComponent implements OnInit {
  survey: Survey;
  survey$: Observable<Survey>;
  constructor(public surveyService: SurveyService) {

  }
  ngOnInit() {
    this.survey = new Survey(null, null, null, null, null, null, null, null);
    this.getSurvey(this.surveyService.surveysId);
  }

  getSurvey(id : number){
    return this.surveyService.getSurvey(id).subscribe(
      (data) => { this.survey = data}
      );
      }
}
