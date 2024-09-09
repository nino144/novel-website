import { Component } from '@angular/core';
import { GenreListComponent } from '../../../shared-components/genre-list/genre-list.component';
import { NovelGenresService } from '../../../../services/novel-genres.service';

@Component({
  selector: 'app-vision',
  standalone: true,
  imports: [GenreListComponent],
  templateUrl: './vision.component.html',
  styleUrl: './vision.component.css'
})
export class VisionComponent {
  data!: String[];

  constructor(private novelGenresService: NovelGenresService) {}

  ngOnInit() {
    this.getVisions();
  }

  getVisions() {
    this.data = this.novelGenresService.getVisions(); // Call getComments and assign to comments
  }
}
