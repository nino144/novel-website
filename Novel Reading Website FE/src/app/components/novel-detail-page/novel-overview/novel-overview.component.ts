import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';
import { Novel } from '../../../models/novel';
import { ChapterListComponent } from '../../shared-components/chapter-list/chapter-list.component';

@Component({
  selector: 'app-novel-overview',
  standalone: true,
  imports: [MatCardModule,
            CommonModule,
            MatIconModule,
            ChapterListComponent
          ],
  templateUrl: './novel-overview.component.html',
  styleUrl: './novel-overview.component.css'
})
export class NovelOverviewComponent {
  @Input() overview!: Novel;
  showChaptersList: boolean = false;


}
