import { Question } from "../survey/question.model";

export class Survey {
    public title: string;
    public showTitle: string;
    public creator: string;
    public creationDate: number;
    public expirationDate: number;
    public questions: Question[] = [];
 
    constructor(title: string, showTitle: string, creator: string,
    creationDate: number, expirationDate: number, questions: Question[]) {
        this.title = title;
        this.showTitle = showTitle;
        this.creator = creator;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.questions = questions;
    }
}
