import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm, ReactiveFormsModule } from '@angular/forms';
import { MatSliderModule } from '@angular/material/slider';
import { CommentComponent } from '../../../shared-components/comment/comment.component';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { userComment } from '../../../../models/userComment';
import { ReviewService } from '../../../../services/review.service';

@Component({
  selector: 'app-review',
  standalone: true,
  imports: [FormsModule,
            MatSliderModule,
            ReactiveFormsModule,
            CommonModule,
            CommentComponent,
            MatMenuModule,
            MatIconModule],
  templateUrl: './review.component.html',
  styleUrl: './review.component.css'
})
export class ReviewComponent {
  score = 2; // Initialize score
  hideInputs = false; // Initialize hideInputs
  showReviews = true;
  comments!: userComment[];

  constructor(private reviewService: ReviewService) {}

  ngOnInit() {
    this.getReviews();
  }

  getReviews() {
    this.comments = this.reviewService.getReviews(); // Call getComments and assign to comments
  }

  createComment(commentText: string, ratingText: number): userComment {
    return {
      imageURL: 'https://static.cdnno.com/poster/theo-tram-yeu-tru-ma-bat-dau-truong-sinh-bat-tu/300.jpg?1702546489',
      name: 'newName',
      time: new Date().getTime(),
      comment: commentText,
      likeCount: 0,
      dislikeCount: 0,
      answerCount: 0,
      chapterNumber: 0, // Replace with actual chapter number
      chapterTitle: 'newChapterTitle', // Replace with actual chapter title
      rating: ratingText,
      depth: 0,
      replies: [],
    };
  }
  
  addComment(comment: userComment, form: NgForm) {
    this.comments.unshift(comment);
    form.reset();
  }

  extractReviewData(formData: any): { discussion: string } {
    return {
        discussion: `Nhân vật chính: ${formData.character}
                    Cốt truyện: ${formData.plot}
                    Bố cục thế giới: ${formData.world}
                    Nội dung bài đánh giá: ${formData.review}`,
    };
}
  onSubmit(form: NgForm) {
    const reviewData = this.extractReviewData(form.value);
    const newComment = this.createComment(form.value ? reviewData.discussion : '', form.value.score);
    this.addComment(newComment, form);
  }

}
