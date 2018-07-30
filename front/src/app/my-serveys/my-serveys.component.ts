import { Component, OnInit } from '@angular/core';
import { Survey } from '../survey/survey.model';
import { Observable } from '../../../node_modules/rxjs';
import { SurveyService } from '../survey/survey.service';

@Component({
  selector: 'app-my-serveys',
  templateUrl: './my-serveys.component.html',
  styleUrls: ['./my-serveys.component.css']
})
export class MyServeysComponent implements OnInit {

  survey: Survey;
  surveys$: Observable<Survey[]>
  selectedSurvey: Survey = new Survey(null,null, null, null, null, null);

  constructor(private surveyService: SurveyService) { }

  ngOnInit() {
    this.surveys$ = this.surveyService.getSurveys();
  }

  getId() {
    return this.selectedSurvey.id;
  }

  onSurveyDelete(survey: Survey) {
    this.selectedSurvey = survey;
  }

  onSurveyDeleteSubmit() {
    this.surveyService.deleteSurvey(this.selectedSurvey.id)
      .subscribe(
        () => {
          this.surveys$ = this.surveyService.getSurveys();
          this.selectedSurvey = new Survey(null,null, null, null, null, null);
        }
      );
  }
}
