export class User {
    public id: number;
    public username: string;
    public email: string;
    public password: string;
    public blocked: Boolean

    constructor(id: number, username: string, email: string, password: string, blocked: Boolean) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.blocked = blocked;
    }
}
