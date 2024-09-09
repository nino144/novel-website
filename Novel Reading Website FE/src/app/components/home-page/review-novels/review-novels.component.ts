import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { Review } from '../../../models/review';
import { ReviewNovelComponent } from './review-novel/review-novel.component';
import { ReviewSummaryService } from '../../../services/review-summary.service';

@Component({
  selector: 'app-review-novels',
  standalone: true,
  imports: [ReviewNovelComponent,
            CommonModule,
            MatButtonModule],
  templateUrl: './review-novels.component.html',
  styleUrl: './review-novels.component.css'
})
export class ReviewNovelsComponent {
  reviews!: Review[];

  constructor(private reviewSummaryService: ReviewSummaryService) {}

  ngOnInit() {
    this.getReviews();
  }

  getReviews() {
    this.reviews = this.reviewSummaryService.getReviews(); // Call getComments and assign to comments
  }
}
