import { Component } from '@angular/core';
import { GenreListComponent } from '../../../shared-components/genre-list/genre-list.component';
import { NovelGenresService } from '../../../../services/novel-genres.service';

@Component({
  selector: 'app-status',
  standalone: true,
  imports: [GenreListComponent],
  templateUrl: './status.component.html',
  styleUrl: './status.component.css'
})
export class StatusComponent {
  data!: String[];

  constructor(private novelGenresService: NovelGenresService) {}

  ngOnInit() {
    this.getStatus();
  }

  getStatus() {
    this.data = this.novelGenresService.getStatus(); // Call getComments and assign to comments
  }
}
