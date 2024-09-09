import { Component } from '@angular/core';
import { MatListModule } from '@angular/material/list';
import { CommonModule } from '@angular/common';
import { NovelSummary } from '../../../models/novel-summary';
import { WeeklyHighlightNovelComponent } from './weekly-highlight-novel/weekly-highlight-novel.component';
import { WeeklyHighlightNovelsService } from '../../../services/weekly-highlight-novels.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-weekly-highlight-novels',
  standalone: true,
  imports: [MatListModule,
            WeeklyHighlightNovelComponent,
            CommonModule,
            RouterLink],
  templateUrl: './weekly-highlight-novels.component.html',
  styleUrl: './weekly-highlight-novels.component.css'
})
export class WeeklyHighlightNovelsComponent {
  discussedNovels!: NovelSummary[];
  readNovels!: NovelSummary[];
  nominatedNovels!: NovelSummary[];

  constructor(private weeklyHighlightNovelsService: WeeklyHighlightNovelsService) {}

  ngOnInit() {
    this.getWeeklyTopReadNovels();
    this.getWeeklyTopDiscussedNovels();
    this.getWeeklyNominatedNovels();
  }

  getWeeklyTopReadNovels() {
    this.readNovels = this.weeklyHighlightNovelsService.getWeeklyTopReadNovels(); 
  }

  getWeeklyTopDiscussedNovels() {
    this.discussedNovels = this.weeklyHighlightNovelsService.getWeeklyTopDiscussedNovels(); 
  }

  getWeeklyNominatedNovels() {
    this.nominatedNovels = this.weeklyHighlightNovelsService.getWeeklyNominatedNovels();
  }

}
