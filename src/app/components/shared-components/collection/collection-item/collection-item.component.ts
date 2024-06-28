import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ReadProgress } from '../../../../models/read-progress';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-collection-item',
  standalone: true,
  imports: [CommonModule,
            RouterLink,
            MatCardModule,
            MatIconModule],
  templateUrl: './collection-item.component.html',
  styleUrl: './collection-item.component.css'
})
export class CollectionItemComponent {
  @Input() novel!: ReadProgress;
  @Input() isMarkedNovels!: boolean;
  @Output() onClose = new EventEmitter<void>(); // Output event to notify parent

}
