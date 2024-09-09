import { Component } from '@angular/core';
import { CategoryComponent } from './category/category.component';
import { StatusComponent } from './status/status.component';
import { CharacterTraitComponent } from './character-trait/character-trait.component';
import { VisionComponent } from './vision/vision.component';
import { ChapterComponent } from './chapter/chapter.component';
import { WorldContextComponent } from './world-context/world-context.component';
import { GenreStateService } from '../../../services/genre-state.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-genre',
  standalone: true,
  imports: [CategoryComponent,
            StatusComponent,
            CharacterTraitComponent,
            VisionComponent,
            ChapterComponent,
            WorldContextComponent,
            CommonModule],
  templateUrl: './genre.component.html',
  styleUrl: './genre.component.css'
})
export class GenreComponent {
  constructor(private genreStateService: GenreStateService) {}

  toggleGenreContainer() {
    this.genreStateService.showGenreContainer = !this.genreStateService.showGenreContainer;
  }
}
