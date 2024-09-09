import { Component, Input } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { Novel } from '../../../../models/novel';

@Component({
  selector: 'app-novel-item',
  standalone: true,
  imports: [MatCardModule,
            CommonModule,
            RouterLink],
  templateUrl: './novel-item.component.html',
  styleUrl: './novel-item.component.css'
})
export class NovelItemComponent {
  @Input() item!: Novel;
  @Input() customWidth!: string; // add this line
  @Input() customFlex!: any; // add this line
  @Input() customJustifyContent!: string; // add this line

}
