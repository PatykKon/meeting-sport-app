import {Component} from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
import {MatButtonModule} from '@angular/material/button';
import {MatToolbarModule} from '@angular/material/toolbar';
import {Router, RouterLink, RouterLinkActive} from "@angular/router";
import {AuthService} from "../services/auth/auth.service";


@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    RouterLinkActive,
    RouterLink,
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {

  constructor(private authService: AuthService, private router: Router) {
  }

  isLoggedIn: boolean = false;
  user: any = null;

  ngOnInit() {
    this.authService.authSubject.subscribe(
      (auth) => {
        this.user = auth.user;
        this.isUserLogin(); // Wywołaj metodę sprawdzającą, czy użytkownik jest zalogowany
      }
    )
  }

  isUserLogin() {
    this.isLoggedIn = this.user === true; // Aktualizuj wartość isLoggedIn
  }

  handleLogOut() {
    this.authService.logout();
    this.isLoggedIn = false;
    this.user = null; // Zamiast {} przypisz null
    this.router.navigateByUrl("/login");
  }
}
