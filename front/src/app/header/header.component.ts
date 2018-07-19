import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  public options = [{name: 'Profile'}, {name: 'Logout'}];

  constructor() {
    this.getOptions();
   }

  ngOnInit() {
  }

  getOptions() {
    return this.options;
  }

}
