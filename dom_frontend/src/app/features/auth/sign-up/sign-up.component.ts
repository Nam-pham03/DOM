import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { AuthLayoutComponent } from '../../../layouts/auth-layout/auth-layout.component';
import { AuthService, RegisterRequest } from '../auth.service';

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [CommonModule, FormsModule, RouterLink, AuthLayoutComponent],
  templateUrl: './sign-up.component.html'
})
export class SignUpComponent {
  firstName: string = '';
  lastName: string = '';
  email: string = '';
  feId: string = '';
  phone: string = '';
  password: string = '';
  password1: string = '';
  agreeTerms: boolean = false;
  showPassword: boolean = false;
  showPassword1: boolean = false;
  gender: number | null = null;
  dob: string = '';
  address: string = '';
  errorMessage: string = '';
  successMessage: string = '';

  constructor(private authService: AuthService) {}

  onSubmit() {

    if (this.password !== this.password1) {
      this.errorMessage = 'Passwords do not match!';
      return;
    }


    if (!this.firstName || !this.lastName || !this.email || !this.feId || !this.phone || !this.address || this.gender === null || !this.dob || !this.password || !this.agreeTerms) {
      this.errorMessage = 'Please fill in all required fields!';
      return;
    }

    const user: RegisterRequest = {
      firstName: this.firstName,
      lastName: this.lastName,
      email: this.email,
      feId: this.feId,
      phone: this.phone,
      address: this.address,
      gender: this.gender,
      dob: this.dob,
      password: this.password,
      agreeTerms: this.agreeTerms
    };

    this.authService.register(user).subscribe({
      next: (response) => {
        this.successMessage = 'Registration successful!';
        this.errorMessage = '';
        // Optionally redirect to sign-in page or clear form
        this.resetForm();
      },
      error: (err) => {
        this.errorMessage = err.message || 'Registration failed!';
        this.successMessage = '';
      }
    });
  }

  private resetForm() {
    this.firstName = '';
    this.lastName = '';
    this.email = '';
    this.feId = '';
    this.phone = '';
    this.address = '';
    this.gender = null;
    this.dob = '';
    this.password = '';
    this.password1 = '';
    this.agreeTerms = false;
  }
}
