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
<<<<<<< HEAD
import { HttpClientModule } from '@angular/common/http';
import { UserService } from './registration/user.service';
=======
import { SharedComponent } from './shared/shared.component';
import { ConfirmEqualValidatorDirective } from './shared/confirm-equal-validator.directive';


>>>>>>> 8d28e13f4846eb117991ad803d2a965e01b8c41e

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
<<<<<<< HEAD
    MyServeysComponent,
=======
    UsersComponent,
    MyServeysComponent,
    SharedComponent,
    ConfirmEqualValidatorDirective
>>>>>>> 8d28e13f4846eb117991ad803d2a965e01b8c41e
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
