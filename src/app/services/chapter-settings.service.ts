import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { ChapterSettings } from '../models/chapter-settings';
import { ColorService } from './color.service';

@Injectable({
  providedIn: 'root'
})
export class ChapterSettingsService {

  constructor(private colorService: ColorService) { } // Inject the Color Service

  settings = new BehaviorSubject<ChapterSettings>({
    selectedFont: 'Avenir Next',
    selectedFontSize: '14px',
    selectedLineHeight: '110%',
    selectedAlign: 'center',
    colors: this.colorService.getColors(), // Get colors on initialization
    selectedColor: '#FF5733',
    selectedBackgroundColor: '#FFffff'
  });

  updateSettings(partialSettings: Partial<ChapterSettings>) {
    this.settings.next({ ...this.settings.getValue(), ...partialSettings });
  }
}
