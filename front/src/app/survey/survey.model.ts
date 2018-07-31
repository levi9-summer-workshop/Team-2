
import { Question } from "../survey/question.model";


export class Survey {
    public id: number;
    public title: string;
    public showTitle: string;
    public creator: string;
    public creationDate: number;
    public expirationDate: number;
    public questions: Question[] = [];
 
    constructor(id: number, title: string, showTitle: string, creator: string, creationDate: number, expirationDate: number, questions: Question[]) {
        this.id = id;
        this.title = title;
        this.showTitle = showTitle;
        this.creator = creator;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.questions = questions;
    }
}
