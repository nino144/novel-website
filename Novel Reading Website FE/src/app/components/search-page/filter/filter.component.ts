import { Component } from '@angular/core';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { GenreStateService } from '../../../services/genre-state.service';

@Component({
  selector: 'app-filter',
  standalone: true,
  imports: [MatMenuModule,
            MatIconModule],
  templateUrl: './filter.component.html',
  styleUrl: './filter.component.css'
})
export class FilterComponent {
  constructor(private genreStateService: GenreStateService) {}

  toggleGenreContainer() {
    this.genreStateService.showGenreContainer = !this.genreStateService.showGenreContainer;
    console.log('showGenreContainer:', this.genreStateService.showGenreContainer);

  }
}
