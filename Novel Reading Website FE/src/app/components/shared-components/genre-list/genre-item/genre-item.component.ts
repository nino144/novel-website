import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-genre-item',
  standalone: true,
  imports: [],
  templateUrl: './genre-item.component.html',
  styleUrl: './genre-item.component.css'
})
export class GenreItemComponent {
  @Input() item!: String;

}

