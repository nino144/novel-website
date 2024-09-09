import { Component } from '@angular/core';
import { GenreListComponent } from '../../../shared-components/genre-list/genre-list.component';
import { NovelGenresService } from '../../../../services/novel-genres.service';

@Component({
  selector: 'app-chapter',
  standalone: true,
  imports: [GenreListComponent],
  templateUrl: './chapter.component.html',
  styleUrl: './chapter.component.css'
})
export class ChapterComponent {
  data!: String[];

  constructor(private novelGenresService: NovelGenresService) {}

  ngOnInit() {
    this.getChapters();
  }

  getChapters() {
    this.data = this.novelGenresService.getChapters(); // Call getComments and assign to comments
  }

}
