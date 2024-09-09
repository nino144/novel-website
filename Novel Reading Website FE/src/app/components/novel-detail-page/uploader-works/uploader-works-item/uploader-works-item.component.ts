import { Component, Input } from '@angular/core';
import { UploaderWorks } from '../../../../models/uploader-works';
import { MatCardModule } from '@angular/material/card';

@Component({
  selector: 'app-works-item',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './uploader-works-item.component.html',
  styleUrl: './uploader-works-item.component.css'
})
export class UploaderWorksItemComponent {
  @Input() item!: UploaderWorks;
}
