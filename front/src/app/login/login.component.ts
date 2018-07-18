import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from './auth.service';
import { markParentViewsForCheckProjectedViews } from '../../../node_modules/@angular/core/src/view/util';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error: Error;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  onLogin(form: NgForm) {
    // debugger
    const username = form.value.username;
    const password = form.value.password;
    console.log(username, password);
    this.authService.login(username,password)
    .subscribe( 
      () => this.router.navigate(['home']),
      (error) => {
        this.error = error;
      }
    );
  }
}