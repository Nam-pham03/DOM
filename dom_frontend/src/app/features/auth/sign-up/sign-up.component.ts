import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { AuthLayoutComponent } from '../../../layouts/auth-layout/auth-layout.component';

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
  agreeTerms: boolean = false;
  showPassword: boolean = false;
  gender: number | null = null;
  dob: string = '';
  address: string = '';
}
