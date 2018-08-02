import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import { HomeComponent } from './home/home.component';
import { MyServeysComponent } from './my-serveys/my-serveys.component';
import { UserListComponent } from './user-list/user-list.component';
import { AuthGuard } from './auth-guard.service';
import { CreateSurveyComponent } from './create-survey/create-survey.component';

import { FillSurveyComponent } from './fill-survey/fill-survey.component';
import { ChooseSurveyComponent } from './choose-survey/choose-survey.component';

import { AllSurveysComponent } from './all-surveys/all-surveys.component';


const appRoutes: Routes = [
  { path: '', redirectTo:'/home', pathMatch: 'full' },
  { path: 'login', component: LoginComponent},
  { path: 'registration', component: RegistrationComponent },
  { path: 'home', component: HomeComponent },
  { path: 'myserveys', component: MyServeysComponent, canActivate:[AuthGuard], data: {expectedRole: 'user'}},
  { path: 'create-survey', component: CreateSurveyComponent},
  { path: 'choose-survey', component: ChooseSurveyComponent, canActivate:[AuthGuard], data: {expectedRole: 'user'}},
  { path: 'fill-survey', component: FillSurveyComponent },
  { path: 'users', component: UserListComponent, canActivate: [AuthGuard], data: { expectedRole: 'admin'} },
  { path: 'users', component: UserListComponent, canActivate: [AuthGuard], data: { expectedRole: 'admin'} },
  { path: 'public', component: AllSurveysComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(appRoutes, { useHash: true })],
  exports: [RouterModule]
})
export class AppRoutingModule { }
