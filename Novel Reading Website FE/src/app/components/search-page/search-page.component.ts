import { Component } from '@angular/core';
import { FilterComponent } from './filter/filter.component';
import { GenreComponent } from './genre/genre.component';
import { GenreStateService } from '../../services/genre-state.service';
import { CommonModule } from '@angular/common';
import { PaginatorComponent } from '../shared-components/paginator/paginator.component';
import { NovelSearchResultsComponent } from './novel-search-results/novel-search-results.component';

@Component({
  selector: 'app-search-page',
  standalone: true,
  imports: [FilterComponent,
            NovelSearchResultsComponent,
            GenreComponent,
            CommonModule,
            PaginatorComponent
          ],
  templateUrl: './search-page.component.html',
  styleUrl: './search-page.component.css'
})
export class SearchPageComponent {
  constructor(private genreStateService: GenreStateService) {}
  
  getContentClass(): string {
    return this.genreStateService.showGenreContainer ? 'show' : 'hidden';
  }

}
