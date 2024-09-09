import { Component, Input } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatCardModule } from '@angular/material/card';
import { Ranking } from '../../../../models/ranking';

@Component({
  selector: 'app-ranking-title-item',
  standalone: true,
  imports: [MatCardModule,
            MatIconModule],
  templateUrl: './ranking-title-item.component.html',
  styleUrl: './ranking-title-item.component.css'
})
export class RankingTitleItemComponent {
  @Input() item!: Ranking;
  @Input() active!: boolean;
}
