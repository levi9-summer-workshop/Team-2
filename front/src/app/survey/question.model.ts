export class Question {

    public name: string;
    public title: string;
    public isRequired: string;
    public placeHolder: string;
    public type: string;

    constructor(name: string, title: string, isRequired: string, 
    placeHolder: string, type: string) {
        this.name = name;
        this.title = title;
        this.isRequired = isRequired;
        this.placeHolder = placeHolder;
        this.type = type;
    }
}