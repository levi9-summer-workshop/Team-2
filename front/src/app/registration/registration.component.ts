import { Component, OnInit, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Observable } from '../../../node_modules/rxjs/Observable';
import { User } from './user.model';
import { UserService } from './user.service';
import { HttpErrorResponse } from '../../../node_modules/@angular/common/http';


@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {
  
  users$: Observable<User[]>;
  @ViewChild('f') addUserForm: NgForm;
  error: {username: string, email: string, password: string};

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.users$ = this.userService.getUsers();
  }

  onUserSubmit(form: NgForm) {

    this.userService.saveUser({username: form.value.username, 
      email: form.value.email, password: form.value.pass})
      .subscribe(
        () => {
          this.users$ = this.userService.getUsers();
        },
        (httpErrorResponse: HttpErrorResponse) => {
          this.error = {username: null, email: null, password: null};
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
