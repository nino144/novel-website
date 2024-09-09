import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ColorService } from '../../../services/color.service';
import { ChapterSettingsService } from '../../../services/chapter-settings.service';
import { ChapterSettings } from '../../../models/chapter-settings';
import { BehaviorSubject } from 'rxjs';

@Component({
  selector: 'app-chapter-setting',
  standalone: true,
  imports: [FormsModule,
            CommonModule],
  templateUrl: './chapter-setting.component.html',
  styleUrl: './chapter-setting.component.css'
})
export class ChapterSettingComponent {
  settings!: BehaviorSubject<ChapterSettings>;

  constructor(private chapterSettingsService: ChapterSettingsService) {}

  ngOnInit() {
    this.settings = this.chapterSettingsService.settings;
  }

  selectColor(color: String) {
    this.chapterSettingsService.updateSettings({ selectedColor: color });
  }

  selectBackgroundColor(color: String) {
    this.chapterSettingsService.updateSettings({ selectedBackgroundColor: color });
  }

  updateSetting(prop: keyof ChapterSettings, value: String) {
    this.chapterSettingsService.updateSettings({ [prop]: value });
  }

}
