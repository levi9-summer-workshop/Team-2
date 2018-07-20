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
    this.authService.login(username, password)
      .subscribe(
        () => this.router.navigate(['/home']),
        (error) => {
          this.error = error;
          // console.error(error);
        }
      ); //Ended subscribe
  } //Ended method onLogin()
} //Ended class LoginComponent()