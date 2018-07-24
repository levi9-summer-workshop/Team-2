import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

import { AuthService } from './auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'library-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  //Property error
  error: Error;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  onLogin(form: NgForm) {
    const username = form.value.username;
    const password = form.value.password;

    this.authService

    this.authService.login(username, password)
      .subscribe(
        (authenitacedUser) => {
          if (authenitacedUser) {
            this.router.navigate(['/home']);
          } else {
            this.router.navigate(['/registration']);
            console.log("User is blocked");
          }
        },
        (error) => {
          this.error = error;
          form.reset();
          // console.error(error);
        }
      ); //Ended subscribe
  } //Ended method onLogin()


} //Ended class LoginComponent()