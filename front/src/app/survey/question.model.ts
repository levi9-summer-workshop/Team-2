import { Choices } from "./choice.model";

export class Question {

    public name: string;
    public title: string;
    public isRequired: string;
    public placeHolder: string;
    public type: string;
    public choice: Choices[] = [];

    constructor(name: string, title: string, isRequired: string, 
    placeHolder: string, type: string, choice: Choices[]) {
        this.name = name;
        this.title = title;
        this.isRequired = isRequired;
        this.placeHolder = placeHolder;
        this.type = type;
        this.choice = choice;
    }
}