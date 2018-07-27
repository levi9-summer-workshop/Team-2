import { User, AuthService } from "../login/auth.service";

export class Survey {
    public title: string;
    public showTitle: string;
    public creator: string;
    public creationDate: number;
    public expirationDate: number;
 
    constructor(title: string, showTitle: string, creator: string, creationDate: number, expirationDate: number) {
        this.title = title;
        this.showTitle = showTitle;
        this.creator = creator;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
    }
}
