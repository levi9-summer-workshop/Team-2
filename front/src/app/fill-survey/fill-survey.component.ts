import { Component, OnInit } from '@angular/core';
import { SurveyService } from '../survey/survey.service';
import { Survey } from '../survey/survey.model';
import { Observable } from '../../../node_modules/rxjs';


@Component({
  selector: 'app-fill-survey',
  templateUrl: './fill-survey.component.html',
  styleUrls: ['./fill-survey.component.css']
})
export class FillSurveyComponent implements OnInit {

  survey: Survey;
  questionRadio = "radio";

  constructor(private surveyService: SurveyService) { }

  ngOnInit() {
    this.survey = new Survey();
    this.getSurvey(1);
  }

  getSurvey(id : number){
    return this.surveyService.getSurvey(id).subscribe(
      (data) => { this.survey = data;
      },
      (error) => { console.log(error);
      }
    );
  }
}
