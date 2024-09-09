import { Component } from '@angular/core';
import { ChapterContentComponent } from './chapter-content/chapter-content.component';
import { ChapterContentService } from '../../services/chapter-content.service';
import { ChapterOverviewComponent } from './chapter-overview/chapter-overview.component';

@Component({
  selector: 'app-chapter-display-page',
  standalone: true,
  imports: [ChapterContentComponent,
            ChapterOverviewComponent
           ],
  templateUrl: './chapter-display-page.component.html',
  styleUrl: './chapter-display-page.component.css'
})
export class ChapterDisplayPageComponent {
  chapterOverview!: any;
  chapterContent!: String;
  showChaptersList: boolean = false;

  constructor(private chapterContentService: ChapterContentService) {}

  ngOnInit() {
    this.getChapterOverview();
    this.getChapterContent();
  }

  getChapterOverview() {
    this.chapterOverview = this.chapterContentService.getChapterOverview(); 
  }

  getChapterContent() {
    this.chapterContent = this.chapterContentService.getChapterContent();
  }
}
