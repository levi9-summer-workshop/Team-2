var editorOptions = {
    questionTypes: ["text", "checkbox", "radiogroup", "dropdown"]
};
var editor = new SurveyEditor.SurveyEditor("editorElement", editorOptions);
//Add all countries question into toolbox
editor
    .toolbox
    .addItem({
        name: "countries",
        isCopied: true,
        iconName: "icon-default",
        title: "All countries",
        json: {
            "type": "dropdown",
            optionsCaption: "Select a country...",
            choicesByUrl: {
                url: "https://restcountries.eu/rest/v1/all"
            }
        }
    });

SurveyEditor
    .StylesManager
    .applyTheme("bootstrap");