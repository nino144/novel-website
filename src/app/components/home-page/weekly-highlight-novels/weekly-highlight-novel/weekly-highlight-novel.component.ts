import { Component,Input } from '@angular/core';
import { MatListModule } from '@angular/material/list';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';
import { NovelSummary } from '../../../../models/novel-summary';

@Component({
  selector: 'app-weekly-highlight-novel',
  standalone: true,
  imports: [MatListModule,
            CommonModule,
            MatIconModule,
            RouterLink],
  templateUrl: './weekly-highlight-novel.component.html',
  styleUrl: './weekly-highlight-novel.component.css'
})
export class WeeklyHighlightNovelComponent {
  @Input() novelSummary!: NovelSummary;
  @Input() index!: number;
}
