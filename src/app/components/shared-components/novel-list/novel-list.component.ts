import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatGridListModule } from '@angular/material/grid-list';
import { RouterLink } from '@angular/router';
import { NovelItemComponent } from './novel-item/novel-item.component';

@Component({
  selector: 'app-novel-list',
  standalone: true,
  imports: [NovelItemComponent,
            MatGridListModule,
            CommonModule],
  templateUrl: './novel-list.component.html',
  styleUrl: './novel-list.component.css'
})
export class NovelListComponent {
  @Input() data!: any;
  @Input() cols!: number; // number of grid cols

  get customWidth(): string {
    return this.cols === 2 ? '60%' : '80%'; // change '60%' to your default width
  }

  get customFlex(): any {
    if (this.cols === 1) {
      return {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'space-between',
        gap: '20px'
      };
    } else {
      return {}; // return an empty object when cols is not 2
    }
  }
  
}
