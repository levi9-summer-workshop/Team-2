import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  error: Error;

  constructor(private router: Router) { }

  ngOnInit() {
  }

  onLogin(form: NgForm) {
    const username = form.value.username;
    const password = form.value.password;
        }

}