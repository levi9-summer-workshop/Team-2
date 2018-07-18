import { Component, OnInit, Input } from '@angular/core';
import { User } from '../users/user.model';
import { Observable } from 'rxjs/Observable';
import { UserService } from '../users/user.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users$: Observable<User[]>

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.users$ = this.userService.getUsers();
  }

}
