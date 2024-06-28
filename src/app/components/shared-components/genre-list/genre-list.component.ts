import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { GenreItemComponent } from './genre-item/genre-item.component';

@Component({
  selector: 'app-genre-list',
  standalone: true,
  imports: [GenreItemComponent,
            CommonModule],
  templateUrl: './genre-list.component.html',
  styleUrl: './genre-list.component.css'
})
export class GenreListComponent {
  @Input() data!: String[];

}
