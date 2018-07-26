import { Component, Input, Output, EventEmitter } from "@angular/core";
import * as SurveyKo from "survey-knockout";
import * as SurveyEditor from "surveyjs-editor";
import * as widgets from "surveyjs-widgets";

import "inputmask/dist/inputmask/phone-codes/phone.js";
import { SurveyService } from "../survey/survey.service";
import { Survey } from "../survey/survey.model";

widgets.icheck(SurveyKo);
widgets.select2(SurveyKo);
widgets.inputmask(SurveyKo);
widgets.jquerybarrating(SurveyKo);
widgets.jqueryuidatepicker(SurveyKo);
widgets.nouislider(SurveyKo);
widgets.select2tagbox(SurveyKo);
widgets.signaturepad(SurveyKo);
widgets.sortablejs(SurveyKo);
widgets.ckeditor(SurveyKo);
widgets.autocomplete(SurveyKo);
widgets.bootstrapslider(SurveyKo);

var CkEditor_ModalEditor = {
  afterRender: function (modalEditor, htmlElement) {
    var editor = window["CKEDITOR"].replace(htmlElement);
    editor.on("change", function () {
      modalEditor.editingValue = editor.getData();
    });
    editor.setData(modalEditor.editingValue);
  },
  destroy: function (modalEditor, htmlElement) {
    var instance = window["CKEDITOR"].instances[htmlElement.id];
    if (instance) {
      instance.removeAllListeners();
      window["CKEDITOR"].remove(instance);
    }
  }
};
SurveyEditor.SurveyPropertyModalEditor.registerCustomWidget(
  "html",
  CkEditor_ModalEditor
);

@Component({
  selector: "survey-editor",
  template: `<div id="surveyEditorContainer" class="container"></div>`
})
export class CreateSurveyComponent {
  editor: SurveyEditor.SurveyEditor;
  @Input() json: any;
  @Output() surveySaved: EventEmitter<Object> = new EventEmitter();

  constructor(public surveyService: SurveyService) { }

  ngOnInit() {
    SurveyKo.JsonObject.metaData.addProperty(
      "questionbase",
      "popupdescription:text"
    );
    SurveyKo.JsonObject.metaData.addProperty("page", "popupdescription:text");
    SurveyKo.JsonObject.metaData.removeProperty("selectbase", "choicesByUrl");
    SurveyKo.JsonObject.metaData.removeProperty("questionbase", "visibleIf");
    SurveyKo.JsonObject.metaData.removeProperty("questionbase", "enableIf");
    SurveyKo.JsonObject.metaData.removeProperty("questionbase", "startWithNewLine");
    SurveyKo.JsonObject.metaData.removeProperty("selectbase", "choicesOrder");
    SurveyKo.JsonObject.metaData.removeProperty("selectbase", "colCount");
    SurveyKo.JsonObject.metaData.removeProperty("dropdown", "inputType");
    SurveyKo.JsonObject.metaData.removeProperty("text", "inputType");
    SurveyKo.JsonObject.metaData.removeProperty("selectbase", "hasOther");
    SurveyKo.JsonObject.metaData.removeProperty("selectbase", "otherText");
    SurveyKo.JsonObject.metaData.removeProperty("survey", "navigation");
    SurveyKo.JsonObject.metaData.removeProperty("survey", "question");
    SurveyKo.JsonObject.metaData.removeProperty("survey", "completedHtml");
    SurveyKo.JsonObject.metaData.removeProperty("survey", "timer");
    SurveyKo.JsonObject.metaData.removeProperty("survey", "loadingHtml");
    SurveyKo.JsonObject.metaData.removeProperty("survey", "triggers");


    let editorOptions = { showEmbededSurveyTab: false, showPagesToolbox: false, generateValidJSON: true, questionTypes: ["text", "checkbox", "radiogroup"] };
    this.editor = new SurveyEditor.SurveyEditor(
      "surveyEditorContainer",
      editorOptions
    );

    this.editor.showPropertyGrid = false;
    this.editor.toolbox.removeItem("editor");
    this.editor.toolbox.removeItem("nouislider");
    this.editor.toolbox.removeItem("signaturepad");
    this.editor.toolbox.removeItem("sortablelist");
    this.editor.toolbox.removeItem("bootstrapslider");
    this.editor.text = JSON.stringify(this.json);
    this.editor.saveSurveyFunc = this.saveMySurvey;

  }

  saveMySurvey = () => {    
    let title = (JSON.parse(this.editor.text)).title;
    console.log(title);
    const survey = new Survey(title);
    debugger;
    console.log(survey);
    this.surveyService.saveSurvey(survey).subscribe();
    // this.surveySaved.emit(JSON.parse(this.editor.text));
  };

  
}
