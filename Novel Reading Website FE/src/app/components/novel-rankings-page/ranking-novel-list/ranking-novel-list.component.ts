import { Component } from '@angular/core';
import { RankTimeComponent } from '../rank-time/rank-time.component';
import { Novel } from '../../../models/novel';
import { NovelListComponent } from '../../shared-components/novel-list/novel-list.component';
import { RankingNovelService } from '../../../services/ranking-novel.service';

@Component({
  selector: 'app-ranking-novel-list',
  standalone: true,
  imports: [RankTimeComponent,
            NovelListComponent
          ],
  templateUrl: './ranking-novel-list.component.html',
  styleUrl: './ranking-novel-list.component.css'
})
export class RankingNovelListComponent {
  constructor(private novelService: RankingNovelService) {
    this.novelService.data.subscribe(newData => {
      this.data = newData;
    });
  }
  
  cols: number = 1; // you can change this value as needed

  data!: Novel[];
  
}
