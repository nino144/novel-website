import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { ChapterDetails } from '../../../models/chapter-details';
import { NovelChaptersService } from '../../../services/novel-chapters.service';

@Component({
  selector: 'app-chapter-list',
  standalone: true,
  imports: [CommonModule,
            RouterLink],
  templateUrl: './chapter-list.component.html',
  styleUrl: './chapter-list.component.css'
})
export class ChapterListComponent {
  chapters!: ChapterDetails[];

  constructor(private novelChaptersService: NovelChaptersService) {}

  ngOnInit() {
    this.getNovelAllChapters();
  }

  getNovelAllChapters() {
    this.chapters = this.novelChaptersService.getNovelAllChapters(); // Call getComments and assign to comments
  }
}
