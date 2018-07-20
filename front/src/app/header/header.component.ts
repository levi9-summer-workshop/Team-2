import { Component, OnInit } from '@angular/core';
import { AuthService } from '../login/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public options = [{name: 'Profile'}, {name: 'Logout'}];

  constructor(public authService: AuthService) {
    this.getOptions();
   }

  ngOnInit() {
  }

  getOptions() {
    return this.options;
  }

}
