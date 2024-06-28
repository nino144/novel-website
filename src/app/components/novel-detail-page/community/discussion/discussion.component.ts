import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, NgForm, ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';
import { userComment } from '../../../../models/userComment';
import { CommentComponent } from '../../../shared-components/comment/comment.component';
import { DiscussionService } from '../../../../services/discussion.service';
import { ChapterSettings } from '../../../../models/chapter-settings';
import { ChapterSettingsService } from '../../../../services/chapter-settings.service';

@Component({
  selector: 'app-discussion',
  standalone: true,
  imports: [FormsModule,
            ReactiveFormsModule,
            CommonModule,
            MatMenuModule,
            MatIconModule,
            CommentComponent],
  templateUrl: './discussion.component.html',
  styleUrl: './discussion.component.css'
})
export class DiscussionComponent {
  comments!: userComment[];
  settings!: ChapterSettings;

  constructor(private discussionService: DiscussionService, private chapterSettingsService: ChapterSettingsService) {}

  ngOnInit() {
    this.getDiscussions();
    this.chapterSettingsService.settings.subscribe(settings => this.settings = settings);

  }

  getDiscussions() {
    this.comments = this.discussionService.getDiscussions(); // Call getComments and assign to comments
  }

  createComment(commentText: string): userComment {
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
      depth: 0,
      replies: [],
    };
  }
  
  addComment(comment: userComment, form: NgForm) {
    this.comments.unshift(comment);
    form.reset();
  }
  
  onSubmit(form: NgForm) {
    const newComment = this.createComment(
      form.value.discussion
    );
    console.log(form.value.discussion);

    this.addComment(newComment, form);
  }
}
