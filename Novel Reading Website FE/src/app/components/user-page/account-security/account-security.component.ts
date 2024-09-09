import { Component } from '@angular/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { ReactiveFormsModule, FormsModule} from '@angular/forms';
import { User } from '../../../models/user';
import { UserService } from '../../../services/user.service';

@Component({
  selector: 'app-account-security',
  standalone: true,
  imports: [MatFormFieldModule, 
            MatInputModule, 
            MatButtonModule,
            FormsModule,
            ReactiveFormsModule],
  templateUrl: './account-security.component.html',
  styleUrl: './account-security.component.css'
})
export class AccountSecurityComponent {
  userInfo!: User;
  newPassword!: String;
  confirmNewPassword!: String;
  newEmail!: String;

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.getUserInfo();
  }

  getUserInfo() {
    this.userInfo = this.userService.getUserInfo(); 
  }

  submitForm1() {
  }

  submitForm2() {
  }
}
