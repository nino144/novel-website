import { Component, HostBinding, Input, ViewEncapsulation } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { CommonModule } from '@angular/common';
import { MatCardModule } from '@angular/material/card';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { userComment } from '../../../models/userComment';
import { ReplyingUserService } from '../../../services/replying-user.service';

@Component({
  selector: 'app-comment',
  standalone: true,
  imports: [MatIconModule,
            CommonModule,
            MatCardModule,
            FormsModule,
            ReactiveFormsModule],
  encapsulation: ViewEncapsulation.None,
  templateUrl: './comment.component.html',
  styleUrl: './comment.component.css'
})
export class CommentComponent {
  @HostBinding('style.--form-width') formWidth: string = '100%'; // initial width
  @Input() comment!: userComment;
  @Input() rating?: number;
  showReplies = false; // This property tracks whether the replies should be shown
  isLiked = false;
  isDisliked = false;
  replyingUser!: string;
  replyInput!: string;

  constructor(private replyingUserService: ReplyingUserService) { }

  ngOnInit() {
    this.replyingUserService.currentReplyingUser.subscribe(user => this.replyingUser = user);
  }

  createNewReply(): userComment {
    return {
      imageURL: 'https://static.cdnno.com/poster/theo-tram-yeu-tru-ma-bat-dau-truong-sinh-bat-tu/300.jpg?1702546489',
      name: 'name-sub',
      time: 2,
      comment: '',
      likeCount: 20,
      dislikeCount: 4,
      answerCount: 10,
      chapterNumber: 2,
      chapterTitle: 'chapterTitle2',
      rating: 4,
      depth: 2,
      replies: [],
    };
  }

  toggleReplies(comment: userComment) {
    this.showReplies = !this.showReplies;
    this.replyingUserService.changeReplyingUser(comment.name);
    this.formWidth = this.calculateFormWidth(comment);
  }

  calculateFormWidth(comment: userComment): string {
    if (comment.depth === 0) {
      return comment!.replies!.length > 0 ? '90%' : '100%';
    } else {
      return '90%';
    }
  }

  addReply() {
    if (this.replyInput.trim()) {
      const reply = this.createReply(this.createNewReply(), this.replyInput.trim());
      this.comment?.replies?.push(reply);
      this.replyInput = ''; // Clear the input field
    }
  }

  createReply(comment: userComment, input: string): userComment {
    return {
      ...comment,
      comment: `@${this.replyingUser} ${input}`,
    };
  }

  likeComment() {
    if (!this.isLiked) {
      this.comment.likeCount++;
      this.isLiked = true;
      if (this.isDisliked) {
        this.comment.dislikeCount--;
        this.isDisliked = false;
      }
    } else {
      this.comment.likeCount--;
      this.isLiked = false;
    }
  }
  
  dislikeComment() {
    if (!this.isDisliked) {
      this.comment.dislikeCount++;
      this.isDisliked = true;
      if (this.isLiked) {
        this.comment.likeCount--;
        this.isLiked = false;
      }
    } else {
      this.comment.dislikeCount--;
      this.isDisliked = false;
    }
  }
  
}
