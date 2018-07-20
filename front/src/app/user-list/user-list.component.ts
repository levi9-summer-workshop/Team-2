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
  selectedUser: User = new User(null, null, null, null, false);

  constructor(private userService: UserService) { }

  ngOnInit() {
    this.users$ = this.userService.getUsers();
  }


  onUserDelete(user: User) {
    this.selectedUser = user;
  }

  onUserDeleteSubmit() {
    this.userService.deleteUser(this.selectedUser.id)
      .subscribe(
        () => {
          this.users$ = this.userService.getUsers();
          this.selectedUser = new User(null, null, null, null, false);
        }
      );
  }

  onUserBlock(user: User) {
    this.userService.blockUser({
      id: user.id,
      username: user.username,
      email: user.email,
      password: user.password,
      blocked: true
    })
      .subscribe(
        () => {
          this.users$ = this.userService.getUsers();
        }
      )
  }

  onUserUnblock(user: User) {
    this.userService.blockUser({
      id: user.id,
      username: user.username,
      email: user.email,
      password: user.password,
      blocked: false
    })
      .subscribe(
        () => {
          this.users$ = this.userService.getUsers();
        }
      )
  }
}
