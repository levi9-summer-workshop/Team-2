export class Question {
    public id: number;
    public title: string;
    public type: string;

    constructor(id: number, title: string, type: string) {
        this.id = id;
        this.title = title;
        this.type = type;
    }
}