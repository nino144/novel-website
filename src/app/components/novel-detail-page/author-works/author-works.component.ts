import { Component, Input } from '@angular/core';
import { AuthorWorksItemComponent } from './author-works-item/author-works-item.component';
import { AuthorWorks } from '../../../models/author-works';
import { CommonModule } from '@angular/common';
import { AuthorWorksService } from '../../../services/author-works.service';

@Component({
  selector: 'app-author-works',
  standalone: true,
  imports: [AuthorWorksItemComponent,
            CommonModule],
  templateUrl: './author-works.component.html',
  styleUrl: './author-works.component.css'
})
export class AuthorWorksComponent {
  @Input() author!: string;
  items!: AuthorWorks[];

  constructor(private authorWorksService: AuthorWorksService) {}

  ngOnInit() {
    this.getAuthorWorks();
  }

  getAuthorWorks() {
    this.items = this.authorWorksService.getAuthorWorks(); // Call getComments and assign to comments
  }
}
