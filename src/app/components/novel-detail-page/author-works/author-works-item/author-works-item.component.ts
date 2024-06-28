import { Component, Input } from '@angular/core';
import { AuthorWorks } from '../../../../models/author-works';
import { CommonModule } from '@angular/common';
import { FlexLayoutModule } from '@angular/flex-layout';

@Component({
  selector: 'app-author-works-item',
  standalone: true,
  imports: [FlexLayoutModule,
            CommonModule],
  templateUrl: './author-works-item.component.html',
  styleUrl: './author-works-item.component.css'
})
export class AuthorWorksItemComponent {
  @Input() item!: AuthorWorks;
  @Input() isOdd!: boolean;
  @Input() author!: String;
}
