import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { NovelGenresService } from '../../services/novel-genres.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-edit-uploaded-novel-page',
  standalone: true,
  imports: [MatFormFieldModule, 
            MatInputModule, 
            MatButtonModule,
            FormsModule,
            MatSelectModule,
            MatRadioModule,
            CommonModule],
            templateUrl: './edit-uploaded-novel-page.component.html',
            styleUrl: './edit-uploaded-novel-page.component.css'
})
export class EditUploadedNovelPageComponent {
  novelName!: String;
  author!: String;
  novelDescription!: String;
  selectedOption!: String; // This will hold the value of the selected radio button
  selectedFile: File | null = null; // This will hold the selected file
  selectedFileName: String | null = null; // This will hold the name of the selected file
  categories!: String[];
  traits!: String[];
  visions!: String[];
  worldContexts!: String[];
  selectedCategory!: String; // This will hold the value of the selected dropdown option
  selectedTrait!: String; // This will hold the value of the selected dropdown option
  selectedVision!: String; // This will hold the value of the selected dropdown option
  selectedWorldContext!: String; // This will hold the value of the selected dropdown option

  constructor(private novelGenresService: NovelGenresService) {}

  ngOnInit() {
    this.getCategories();
    this.getCharacterTraits();
    this.getVisions();
    this.getWorldContexts();
  }

  getCategories() {
    this.categories = this.novelGenresService.getCategories(); // Call getComments and assign to comments
  }

  getCharacterTraits() {
    this.traits = this.novelGenresService.getCharacterTraits(); // Call getComments and assign to comments
  }

  getVisions() {
    this.visions = this.novelGenresService.getVisions(); // Call getComments and assign to comments
  }

  getWorldContexts() {
    this.worldContexts = this.novelGenresService.getWorldContexts(); // Call getComments and assign to comments
  }
  

  onFileSelected(event: Event) {
    const element = event.currentTarget as HTMLInputElement;
    let fileList: FileList | null = element.files;
    if (fileList) {
      this.selectedFile = fileList[0];
      this.selectedFileName = fileList[0].name; // Set the file name
      // You can now upload this file or do whatever you need with it
    }
  }

  submitForm(){

  }

  
}

