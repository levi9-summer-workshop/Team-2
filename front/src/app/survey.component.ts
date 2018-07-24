import { Component, Input } from "@angular/core";
import * as Survey from "survey-angular";
import * as widgets from "surveyjs-widgets";

import "inputmask/dist/inputmask/phone-codes/phone.js";

widgets.icheck(Survey);
widgets.select2(Survey);
widgets.inputmask(Survey);
widgets.jquerybarrating(Survey);
widgets.jqueryuidatepicker(Survey);
widgets.nouislider(Survey);
widgets.select2tagbox(Survey);
widgets.signaturepad(Survey);
widgets.sortablejs(Survey);
widgets.ckeditor(Survey);
widgets.autocomplete(Survey);
widgets.bootstrapslider(Survey);
widgets.prettycheckbox(Survey);

Survey.JsonObject.metaData.addProperty("questionbase", "popupdescription:text");
Survey.JsonObject.metaData.addProperty("page", "popupdescription:text");
Survey.JsonObject.metaData.removeProperty("selectbase", "choicesByUrl");
Survey.JsonObject.metaData.removeProperty("questionbase", "visibleIf");
Survey.JsonObject.metaData.removeProperty("questionbase", "enableIf");
Survey.JsonObject.metaData.removeProperty("questionbase", "startWithNewLine");
Survey.JsonObject.metaData.removeProperty("selectbase", "choicesOrder");
Survey.JsonObject.metaData.removeProperty("selectbase", "colCount");
Survey.JsonObject.metaData.removeProperty("dropdown", "inputType");
Survey.JsonObject.metaData.removeProperty("text", "inputType");
Survey.JsonObject.metaData.removeProperty("selectbase", "hasOther");
Survey.JsonObject.metaData.removeProperty("selectbase", "otherText");
Survey.JsonObject.metaData.removeProperty("survey", "navigation");
Survey.JsonObject.metaData.removeProperty("survey", "question");
Survey.JsonObject.metaData.removeProperty("survey", "completedHtml");
Survey.JsonObject.metaData.removeProperty("survey", "timer");
Survey.JsonObject.metaData.removeProperty("survey", "loadingHtml");
Survey.JsonObject.metaData.removeProperty("survey", "triggers");



@Component({
  selector: "survey",
  template: `<div class="survey-container contentcontainer codecontainer"><div id="surveyElement"></div></div>`
})
export class SurveyComponent {
  @Input()
  set json(value: object) {
    const surveyModel = new Survey.Model(value);
    surveyModel.onAfterRenderQuestion.add((survey, options) => {
      if (!options.question.popupdescription) return;

      //Add a button;
      var btn = document.createElement("button");
      btn.className = "btn btn-info btn-xs";
      btn.innerHTML = "More Info";
      var question = options.question;
      
      btn.onclick = function() {
        //showDescription(question);
        alert(options.question.popupdescription);
      };
      var header = options.htmlElement.querySelector("h5");
      var span = document.createElement("span");
      span.innerHTML = "  ";
      header.appendChild(span);
      header.appendChild(btn);

    });
    Survey.SurveyNG.render("surveyElement", { model: surveyModel });
  }
  


  ngOnInit() {}
  
}