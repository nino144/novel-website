import { Component, Input } from '@angular/core';
import { DiscussionComponent } from '../../novel-detail-page/community/discussion/discussion.component';
import { ChapterSettings } from '../../../models/chapter-settings';
import { ChapterSettingsService } from '../../../services/chapter-settings.service';

@Component({
  selector: 'app-chapter-content',
  standalone: true,
  imports: [DiscussionComponent],
  templateUrl: './chapter-content.component.html',
  styleUrl: './chapter-content.component.css'
})
export class ChapterContentComponent {
  @Input() chapterContent!: String;

  settings!: ChapterSettings;

  constructor(private chapterSettingsService: ChapterSettingsService) {}

  ngOnInit() {
    this.chapterSettingsService.settings.subscribe(settings => this.settings = settings);
  }

}
