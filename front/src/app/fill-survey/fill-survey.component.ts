import { Survey } from "../survey/survey.model";
import { SurveyService } from "../survey/survey.service";
import { OnInit, Component } from "../../../node_modules/@angular/core";


@Component({
  selector: 'app-fill-survey',
  templateUrl: './fill-survey.component.html',
  styleUrls: ['./fill-survey.component.css']
})
export class FillSurveyComponent implements OnInit {

  survey: Survey;

  constructor(private surveyService: SurveyService) { }

  ngOnInit() {
    this.survey = new Survey(null, null, null, null, null, null, null, null);
    this.getSurvey(this.surveyService.surveysId);
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
