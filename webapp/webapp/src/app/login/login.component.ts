import {Component, OnInit} from '@angular/core';
import {MatCard, MatCardContent, MatCardTitle} from "@angular/material/card";
import {FormBuilder, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";
import {AuthService} from "../../../pages/services/auth/auth.service";
import {Router, RouterLink, RouterLinkActive} from "@angular/router";

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [
    MatCard,
    MatCardTitle,
    MatCardContent,
    ReactiveFormsModule,
    MatFormField,
    MatInput,
    MatButton,
    MatLabel,
    RouterLink,
    RouterLinkActive
  ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent implements OnInit{
  loginForm!: FormGroup;

  constructor(
    private authService: AuthService,
    private fb: FormBuilder,
    private route: Router) {
  }

  ngOnInit(): void {
    this.loginForm = this.fb.group({
      email: [null,],
      password: [null,],
    })
  }

  onSubmit(): void {
    this.handleLogin();
  }

  handleLogin() {
    this.authService.login(this.loginForm.value).subscribe({
      next: (response) => {
        localStorage.setItem("accessToken", response.accessToken);
        this.authService.getUserProfile().subscribe()
        this.route.navigateByUrl("/")
      }
    });
  }
}
