import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-login-register-page',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './login-register-page.component.html',
  styleUrls: ['./login-register-page.component.css']
})
export class LoginRegisterPageComponent {
  isLoginMode = true;
  loginForm!: FormGroup;

  constructor(private fb: FormBuilder) {}

  ngOnInit() {
    this.loginForm = this.fb.group({
      name: ['', this.isLoginMode ? null : Validators.required],
      email: ['', [Validators.required, Validators.email]],
      password: ['', Validators.required]
    });
  }

  onSubmit() {
    if (this.loginForm.valid) {
      console.log(this.loginForm.value);
    } else {
      console.error('Form is invalid:', this.loginForm.errors);
      this.loginForm.markAllAsTouched();
    }
  }

  toggleMode(isLoginMode: boolean) {
    this.isLoginMode = isLoginMode;
    this.updateFormControls();
  }

  updateFormControls() {
    const nameControl = this.loginForm.get('name');
    if (this.isLoginMode) {
      nameControl?.clearValidators();
    } else {
      nameControl?.setValidators(Validators.required);
    }
    nameControl?.updateValueAndValidity();
  }

  getErrorMessage(control: string): string {
    const errors = this.loginForm.get(control)?.errors;
    if (errors) {
      if (errors['required']) {
        return 'This field is required.';
      } else if (errors['email']) {
        return 'Please enter a valid email address.';
      }
    }
    return '';
  }
}