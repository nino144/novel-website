import { Component,Input} from '@angular/core';
import { CommonModule } from '@angular/common';
import { FlexLayoutModule } from '@angular/flex-layout';
import { UpdatedNovels } from '../../../models/updated-novels';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-updated-novels',
  standalone: true,
  imports: [FlexLayoutModule,
            CommonModule,
            RouterLink],
  templateUrl: './updated-novels.component.html',
  styleUrl: './updated-novels.component.css'
})
export class UpdatedNovelsComponent {
  @Input() updatedNovels!: UpdatedNovels;
  @Input() isOdd!: boolean;
  
}
