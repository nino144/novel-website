import { Component } from '@angular/core';
import { GenreListComponent } from '../../../shared-components/genre-list/genre-list.component';
import { NovelGenresService } from '../../../../services/novel-genres.service';

@Component({
  selector: 'app-character-trait',
  standalone: true,
  imports: [GenreListComponent],
  templateUrl: './character-trait.component.html',
  styleUrl: './character-trait.component.css'
})
export class CharacterTraitComponent {
  data!: String[];

  constructor(private novelGenresService: NovelGenresService) {}

  ngOnInit() {
    this.getCharacterTraits();
  }

  getCharacterTraits() {
    this.data = this.novelGenresService.getCharacterTraits(); // Call getComments and assign to comments
  }
}
