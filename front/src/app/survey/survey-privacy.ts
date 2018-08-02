export class SurveyPrivacy {
    public id: number;
    public privacyType: string;

    constructor(surveyPrivacyType?:string, id?:number) {
        this.id = id;
        this.privacyType = surveyPrivacyType;
    }
}