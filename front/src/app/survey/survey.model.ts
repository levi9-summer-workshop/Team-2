import { Question } from "./question.model";

export class Survey {
    public id: number;
    public title: string;
    public questions: Question[];
}