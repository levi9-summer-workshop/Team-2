export class Choices {
    public id: number;
    public choices: string;

    constructor(choices: string, id: number) {
        this.id = id;
        this.choices = choices;
    }
}