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
// import { SurveyComponent } from './survey.component';
// import { SurveyEditorComponent } from './survey.editor.component';
import { AuthGuard } from './auth-guard.service';
import { ViewSurveyComponent } from './view-survey/view-survey.component';
import { CreateSurveyComponent } from './create-survey/create-survey.component';
import { ExampleSurveyComponent } from './example-survey/example-survey.component';
import { SurveyService } from './survey/survey.service';



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
    ViewSurveyComponent,
    ExampleSurveyComponent

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UserService, AuthService, AuthGuard, SurveyService],
  bootstrap: [AppComponent]
})
export class AppModule { }
