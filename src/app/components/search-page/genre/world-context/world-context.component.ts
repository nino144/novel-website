import { Component } from '@angular/core';
import { GenreListComponent } from '../../../shared-components/genre-list/genre-list.component';
import { NovelGenresService } from '../../../../services/novel-genres.service';

@Component({
  selector: 'app-world-context',
  standalone: true,
  imports: [GenreListComponent],
  templateUrl: './world-context.component.html',
  styleUrl: './world-context.component.css'
})
export class WorldContextComponent {
  data!: String[];

  constructor(private novelGenresService: NovelGenresService) {}

  ngOnInit() {
    this.getWorldContexts();
  }

  getWorldContexts() {
    this.data = this.novelGenresService.getWorldContexts(); // Call getComments and assign to comments
  }

}
