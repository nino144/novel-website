import { Component,Input } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { Review } from '../../../../models/review';

@Component({
  selector: 'app-review-novel',
  standalone: true,
  imports: [MatCardModule],
  templateUrl: './review-novel.component.html',
  styleUrl: './review-novel.component.css'
})
export class ReviewNovelComponent {
  @Input() review!: Review;

}
