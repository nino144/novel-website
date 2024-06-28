import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { ChapterDetails } from '../../../models/chapter-details';
import { NovelChaptersService } from '../../../services/novel-chapters.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-overview-chapters',
  standalone: true,
  imports: [CommonModule,
            RouterLink],
  templateUrl: './overview-chapters.component.html',
  styleUrl: './overview-chapters.component.css'
})
export class OverviewChaptersComponent {
  chapters!: ChapterDetails[];

  constructor(private novelChaptersService: NovelChaptersService) {}

  ngOnInit() {
    this.getOverviewChapters();
  }

  getOverviewChapters() {
    this.chapters = this.novelChaptersService.getOverviewChapters(); // Call getComments and assign to comments
  }
}
