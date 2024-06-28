import { Component, Input } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { ChapterListComponent } from '../../shared-components/chapter-list/chapter-list.component';
import { CommonModule } from '@angular/common';
import { ChapterSettingComponent } from '../chapter-setting/chapter-setting.component';
import { ChapterSettings } from '../../../models/chapter-settings';
import { ChapterSettingsService } from '../../../services/chapter-settings.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-chapter-overview',
  standalone: true,
  imports: [MatIconModule,
            ChapterListComponent,
            CommonModule,
            ChapterSettingComponent,
            RouterLink],
  templateUrl: './chapter-overview.component.html',
  styleUrl: './chapter-overview.component.css'
})
export class ChapterOverviewComponent {
  @Input() chapterOverview!: any;
  showChaptersList: boolean = false;
  showSettingTable: boolean = false;

  settings!: ChapterSettings;

  constructor(private chapterSettingsService: ChapterSettingsService) {}

  ngOnInit() {
    this.chapterSettingsService.settings.subscribe(settings => this.settings = settings);
  }

}
