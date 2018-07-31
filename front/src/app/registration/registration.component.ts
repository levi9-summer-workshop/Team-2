import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from 'rxjs/Observable';
import { User } from '../users/user.model';
import { UserService } from '../users/user.service';
import { HttpErrorResponse } from '@angular/common/http';
import { AuthService } from '../login/auth.service';
import { Router } from '../../../node_modules/@angular/router';
import { EmailService } from '../email.service';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  
  users$: Observable<User[]>;
  @ViewChild('f') addUserForm: NgForm;
  error: {username: string, email: string, password: string, blocked: boolean};
  selectedUser: User = { id: null, username: null, email: null, password: null, blocked: false };
  operation: string;

  notification: string;

  constructor(private userService: UserService, private authService: AuthService, private router: Router, private emailServce: EmailService) { }

  

  ngOnInit() {
    this.users$ = this.userService.getUsers();
  }

  // showLoginPage(){
  //   window.open("http://localhost:4200/#/login");
  //   window.close();
  // }
  onUserSubmit(form: NgForm) {
    let userToSave = new User(this.operation === 'Add' ? null : this.selectedUser.id, form.value.username, form.value.email, form.value.pass, false);
    this.userService.saveUser(userToSave)
      .subscribe(
        () => {
          this.authService.login(form.value.username, form.value.pass)
          .subscribe(
            (authenticatedUser) => {
              if (authenticatedUser) {
                this.emailServce.sendRegistrationEmail(userToSave).subscribe(),
                (error) => this.error = error;
                this.router.navigate(['/home']);
              } else {
                this.router.navigate(['/registration']);
              }
            },
            (error) => {
              this.error = error;
              form.reset();
              // console.error(error);
            }
          ); //Ended subscribe
        },
        (httpErrorResponse: HttpErrorResponse) => {
          this.error = {username: null, email: null, password: null, blocked: null};
          httpErrorResponse.error.exceptions.forEach(element => {
            this.errorHandler(element);
          });
        }
      );
  }

  errorHandler(error) {
    switch(error.field) {
      case 'username':
      this.error.username = this.capitalize(error.message);
      break;
      case 'email':
      this.error.email = this.capitalize(error.message);
      break;
      case 'password':
      this.error.password = this.capitalize(error.message);
      break;
    }
  }

  capitalize(text) {
    return text[0].toUpperCase() + text.slice(1) + '!';
  }
}