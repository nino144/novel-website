import { Component } from '@angular/core';
import { GenreListComponent } from '../../../shared-components/genre-list/genre-list.component';
import { NovelGenresService } from '../../../../services/novel-genres.service';

@Component({
  selector: 'app-category',
  standalone: true,
  imports: [GenreListComponent],
  templateUrl: './category.component.html',
  styleUrl: './category.component.css'
})
export class CategoryComponent {
  data!: String[];

  constructor(private novelGenresService: NovelGenresService) {}

  ngOnInit() {
    this.getCategories();
  }

  getCategories() {
    this.data = this.novelGenresService.getCategories(); // Call getComments and assign to comments
  }
}
