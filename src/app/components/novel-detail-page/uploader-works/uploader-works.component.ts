import { Component } from '@angular/core';
import { UploaderWorks } from '../../../models/uploader-works';
import { CommonModule } from '@angular/common';
import { UploaderWorksItemComponent } from './uploader-works-item/uploader-works-item.component';
import { UploaderWorksService } from '../../../services/uploader-works.service';

@Component({
  selector: 'app-uploader-works',
  standalone: true,
  imports: [UploaderWorksItemComponent,
            CommonModule],
  templateUrl: './uploader-works.component.html',
  styleUrl: './uploader-works.component.css'
})
export class UploaderWorksComponent {
  items!: UploaderWorks[];

  constructor(private uploaderWorksService: UploaderWorksService) {}

  ngOnInit() {
    this.getUploaderWorks();
  }

  getUploaderWorks() {
    this.items = this.uploaderWorksService.getUploaderWorks(); // Call getComments and assign to comments
  }
}
