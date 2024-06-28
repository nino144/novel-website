import { Component,EventEmitter,Input, Output } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { Reading } from '../../../../models/reading';

@Component({
  selector: 'app-reading-novel',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './reading-novel.component.html',
  styleUrl: './reading-novel.component.css'
})
export class ReadingNovelComponent {
  @Input() item!: Reading;
  @Output() onClose = new EventEmitter<void>(); // Output event to notify parent

}
