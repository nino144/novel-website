import { Component } from '@angular/core';
import { MatSliderModule } from '@angular/material/slider';
import { FormsModule } from '@angular/forms';
import { RouterLink } from '@angular/router';
import { Novel } from '../../../models/novel';
import { NovelService } from '../../../services/novel.service';

@Component({
  selector: 'app-new-novels',
  standalone: true,
  imports: [MatSliderModule,
            FormsModule,
            RouterLink],
  templateUrl: './new-novels.component.html',
  styleUrl: './new-novels.component.css'
})
export class NewNovelsComponent {
  slides!: Novel[];
  currentIndex = 0;
  previousIndex = 0;
  nextIndex = 0;

  constructor(private novelService: NovelService) {}

  ngOnInit() {
    this.getNewNovels();
    this.previousIndex = this.slides.length - 1;
    this.nextIndex = (this.currentIndex + 1) % this.slides.length;
  }

  getNewNovels() {
   this.slides = this.novelService.getNewNovels();
  }

  changeContent(direction: string) {
    if (direction === 'prev') {
      this.currentIndex = (this.currentIndex - 1 + this.slides.length) % this.slides.length;
      this.previousIndex = (this.currentIndex - 1 + this.slides.length) % this.slides.length;
      this.nextIndex = (this.currentIndex + 1) % this.slides.length;
    } else if (direction === 'next') {
      this.previousIndex = this.currentIndex;
      this.currentIndex = (this.previousIndex + 1) % this.slides.length;
      this.nextIndex = (this.currentIndex + 1) % this.slides.length;
    }
  }
  
  get currentSlide() {
    return this.slides[this.currentIndex];
  }
}
