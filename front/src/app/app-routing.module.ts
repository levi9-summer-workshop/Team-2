import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { MyServeysComponent } from './my-serveys/my-serveys.component';
import { UserListComponent } from './user-list/user-list.component';
import { SurveyEditorComponent } from './survey.editor.component';
import { CreateComponent } from './create/create.component';
import { AuthGuard } from './auth-guard.service';


const appRoutes: Routes = [
  { path: '', redirectTo:'/home', pathMatch: 'full' },
  { path: 'login', component: LoginComponent},
  { path: 'registration', component: RegistrationComponent },
  { path: 'home', component: HomeComponent },
  { path: 'myserveys', component: MyServeysComponent},
  { path: 'create', component: CreateComponent},
  { path: 'users', component: UserListComponent, canActivate: [AuthGuard], data: { expectedRole: 'admin'} }
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
