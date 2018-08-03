import { Choice } from "../Choice/choice.model";

export class Question {
    public id: number;
    public questionTitle: string;
    public isRequired: boolean;
    public questionType: string;
    public choices: Choice[] = [];

    constructor(id: number, questionTitle: string, isRequired:boolean, questionType: string, choices: Choice[]) {
        this.id = id;
        this.questionTitle = questionTitle;
        this.isRequired = isRequired;
        this.questionType = questionType;
        this.choices = choices;
    }
}