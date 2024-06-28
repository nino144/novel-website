import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-novel-description',
  standalone: true,
  imports: [],
  templateUrl: './novel-description.component.html',
  styleUrl: './novel-description.component.css'
})
export class NovelDescriptionComponent {
  @Input() description!: string;

}
