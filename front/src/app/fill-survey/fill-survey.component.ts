import { Survey } from "../survey/survey.model";
import { SurveyService } from "../survey/survey.service";
import { OnInit, Component } from "../../../node_modules/@angular/core";
import { Choice } from "../Choice/choice.model";
import { NgForm } from "@angular/forms";
import { Observable } from 'rxjs/Observable';
import { AuthService } from "../login/auth.service";


@Component({
  selector: 'app-fill-survey',
  templateUrl: './fill-survey.component.html',
  styleUrls: ['./fill-survey.component.css']
})
export class FillSurveyComponent implements OnInit {

  choices$: Observable<Choice[]>
  survey: Survey;
  selectedAnswer: Choice = { text: null };

  constructor(private surveyService: SurveyService, public authService: AuthService) { }

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

/*  onAnswerSubmit(form: NgForm) {
      let answer = new Choice(form.value.text);
      console.log(answer)
      this.surveyService.saveAnswer(answer)
        .subscribe()
        )
              
    }

  submitFilledSurvey(survey : Survey){
    this.surveyService.saveAnswer(survey).subscribe((data) =>{
      survey = data;
     
    },
       (error) => {
         console.log(error),
      () =>{
      
      } 
    })
  }*/
}