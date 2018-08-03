import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app-routing.module';
import { RegistrationComponent } from './registration/registration.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { HomeComponent } from './home/home.component';
import { MyServeysComponent } from './my-serveys/my-serveys.component';
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './users/user.service';
import { SharedComponent } from './shared/shared.component';
import { ConfirmEqualValidatorDirective } from './shared/confirm-equal-validator.directive';
import { UserListComponent } from './user-list/user-list.component';
import { AuthService } from './login/auth.service';
import { AuthGuard } from './auth-guard.service';
import { EmailService } from './email.service';
import { CreateSurveyComponent } from './create-survey/create-survey.component';
import { SurveyService } from './survey/survey.service';

import { FillSurveyComponent } from './fill-survey/fill-survey.component';

import { AllSurveysComponent } from './all-surveys/all-surveys.component';
import { ResultsComponent } from './results/results.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    MyServeysComponent,
    MyServeysComponent,
    SharedComponent,
    ConfirmEqualValidatorDirective,
    UserListComponent,
    CreateSurveyComponent,
    FillSurveyComponent,
    AllSurveysComponent,
    ResultsComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UserService, AuthService, AuthGuard, EmailService, SurveyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
