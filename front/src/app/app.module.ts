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
<<<<<<< HEAD
import { UserService } from './users/user.service';
import { SharedComponent } from './shared/shared.component';
import { ConfirmEqualValidatorDirective } from './shared/confirm-equal-validator.directive';
import { UserListComponent } from './user-list/user-list.component';
=======
import { UserService } from './registration/user.service';
import { SharedComponent } from './shared/shared.component';
import { ConfirmEqualValidatorDirective } from './shared/confirm-equal-validator.directive';


>>>>>>> home-page-front

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
<<<<<<< HEAD
    ConfirmEqualValidatorDirective,
    UserListComponent
=======
    ConfirmEqualValidatorDirective
>>>>>>> home-page-front
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
