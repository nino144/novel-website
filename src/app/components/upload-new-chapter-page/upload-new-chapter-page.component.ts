import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-upload-new-chapter-page',
  standalone: true,
  imports: [MatFormFieldModule, 
            MatInputModule, 
            MatButtonModule,
            FormsModule],
  templateUrl: './upload-new-chapter-page.component.html',
  styleUrl: './upload-new-chapter-page.component.css'
})

export class UploadNewChapterPageComponent {
  chapterNumber!: number;
  chapterTitle!: String;
  chapterContent!: String;

  submitForm() {
    const formData = {
      chapterNumber: this.chapterNumber,
      chapterTitle: this.chapterTitle,
      chapterContent: this.chapterContent
    };
    console.log('Form Data:', formData);
    // Add your form submission logic here
  }
}
