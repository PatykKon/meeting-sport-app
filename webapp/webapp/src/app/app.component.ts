import {Component} from '@angular/core';
import {RouterOutlet} from '@angular/router';
import {NavbarComponent} from "../../pages/navbar/navbar.component";
import {FooterComponent} from "../../pages/footer/footer.component";
import {HomePageComponent} from "../../pages/home-page/home-page.component";
import {TableRowComponent} from "../../pages/table-row/table-row.component";
import {LoginComponent} from "./login/login.component";
import {SignupComponent} from "./signup/signup.component";
import {MatLabel} from "@angular/material/form-field";
import {HttpClientModule} from "@angular/common/http";
import {AuthService} from "../../pages/services/auth/auth.service";
import {CommonModule} from "@angular/common";
import {AddEventComponent} from "../../pages/add-event/add-event.component";


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    LoginComponent,
    SignupComponent,
    RouterOutlet,
    NavbarComponent,
    FooterComponent,
    HomePageComponent,
    TableRowComponent,
    MatLabel,
    HttpClientModule,
    CommonModule,
    AddEventComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'webapp';

  user:any = null;

  constructor(private authService: AuthService) {
  }

  ngOnInit(){
    this.authService.getUserProfile().subscribe({
      next:data=>console.log("req user", data),
      error:error=>console.log("error",error)
    })
    this.authService.authSubject.subscribe(
      (auth)=> this.user = auth.user
    )
  }
}
