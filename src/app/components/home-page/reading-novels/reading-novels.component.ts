import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatButtonModule } from '@angular/material/button';
import { RouterLink } from '@angular/router';
import { Reading } from '../../../models/reading';
import { ReadingNovelComponent } from './reading-novel/reading-novel.component';
import { NovelService } from '../../../services/novel.service';

@Component({
  selector: 'app-reading-novels',
  standalone: true,
  imports: [ReadingNovelComponent,
            CommonModule,
            MatButtonModule,
            RouterLink],
  templateUrl: './reading-novels.component.html',
  styleUrl: './reading-novels.component.css'
})
export class ReadingNovelsComponent {
  items!: Reading[];

  constructor(private novelService: NovelService) {}

  ngOnInit() {
    this.getReadingNovels();
  }

  getReadingNovels() {
    this.items = this.novelService.getReadingNovels(); // Call getComments and assign to comments
  }

  removeReadingNovel(novelToRemove: Reading): void {
    this.items = this.items.filter(item => item !== novelToRemove);
  }
}
