import {Component} from '@angular/core';
import {MatFormField, MatLabel} from "@angular/material/form-field";
import {MatCard, MatCardContent, MatCardTitle} from "@angular/material/card";
import {FormBuilder, FormGroup, ReactiveFormsModule} from "@angular/forms";
import {AuthService} from "../../../pages/services/auth/auth.service";
import {MatInput} from "@angular/material/input";
import {MatButton} from "@angular/material/button";
import {HttpClientModule} from "@angular/common/http";


@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [
    MatFormField,
    MatCardContent,
    MatCard,
    MatCardTitle,
    ReactiveFormsModule,
    MatInput,
    MatButton,
    MatLabel,
    HttpClientModule
  ],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {


  signupForm!: FormGroup;
  signup: any;


  constructor(
    private fb: FormBuilder,
    private authService: AuthService,
  ) {
  }

  ngOnInit(): void {
    this.signupForm = this.fb.group({
      firstName: [null,],
      lastName: [null,],
      age: [null,],
      role: [null,],
      email: [null,],
      password: [null,],
    })
  }

  onSubmit(): void {

    this.authService.register(this.signupForm.value)
      .subscribe({
        next: (response) => {
          localStorage.setItem("jwt", response.jwt);
          this.authService.getUserProfile().subscribe();
        }
      });
  }
}
