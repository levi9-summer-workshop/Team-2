import { SurveyStatus } from "./survey-status";
import { SurveyPrivacy } from "./survey-privacy";
import { Question } from "../question/question.model";
import { User } from "../users/user.model";

export class Survey {
    public id: number;
    public surveyUser: User;
    public surveyTitle: string;
    public surveyDescription: string;
    public surveyQuestions: Question[];
    public surveyPrivacy: SurveyPrivacy;
    public surveyStatus: SurveyStatus;
    public surveyExpireDate: Date;

    constructor (surveyTitle:string, surveyDescription: string, surveyQuestions: Question[], surveyExpireDate?: Date, surveyPrivacy?: SurveyPrivacy, surveyStatus?: SurveyStatus,  id?: number, surveyUser?: User) {
        this.id = id;
        this.surveyUser = surveyUser;
        this.surveyTitle = surveyTitle;
        this.surveyQuestions = surveyQuestions;
        this.surveyDescription = surveyDescription;
        this.surveyPrivacy = surveyPrivacy;
        this.surveyStatus = surveyStatus;
        this.surveyExpireDate = surveyExpireDate;
    }
}