import { Component } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { ReactiveFormsModule, FormsModule} from '@angular/forms';
import { MatRadioModule } from '@angular/material/radio';
import { MatDividerModule } from '@angular/material/divider';
import { UserService } from '../../../services/user.service';
import { UserReadStatistics } from '../../../models/userReadStatistics';
import { User } from '../../../models/user';

@Component({
  selector: 'app-account-setting',
  standalone: true,
  imports: [MatCardModule,
            MatFormFieldModule, 
            MatInputModule, 
            MatButtonModule,
            FormsModule,
            ReactiveFormsModule,
            MatRadioModule,
            MatDividerModule],
  templateUrl: './account-setting.component.html',
  styleUrl: './account-setting.component.css'
})

export class AccountSettingComponent {
  userInfo!: User;
  userReadStatistics!: UserReadStatistics;

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.getUserInfo();
    this.getUserReadStatistics();
  }

  getUserInfo() {
    this.userInfo = this.userService.getUserInfo(); // Call getComments and assign to comments
  }

  getUserReadStatistics() {
    this.userReadStatistics = this.userService.getUserReadStatistics(); // Call getComments and assign to comments
  }

  onImageClick() {
    const fileInput = document.createElement('input');
    fileInput.type = 'file';
    fileInput.accept = 'image/*';
    fileInput.onchange = (event: any) => {
      const files = event.target.files;
  
      // Check if any file is selected
      if (files && files.length > 0) {
        const reader = new FileReader();
        reader.onload = (e: any) => {
          this.userInfo.imageURL = e.target.result;
        };
        reader.readAsDataURL(files[0]);
      } else {
        console.warn('No file selected');
      }
    };
    fileInput.click();
  }

  onSubmit() {
  }
}
