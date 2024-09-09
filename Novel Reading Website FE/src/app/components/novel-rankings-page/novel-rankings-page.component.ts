import { Component } from '@angular/core';
import { RankingNovelListComponent } from './ranking-novel-list/ranking-novel-list.component';
import { RankingTitleListComponent } from './ranking-title-list/ranking-title-list.component';
import { PaginatorComponent } from '../shared-components/paginator/paginator.component';

@Component({
  selector: 'app-novel-rankings-page',
  standalone: true,
  imports: [RankingNovelListComponent,
            RankingTitleListComponent,
            PaginatorComponent],
  templateUrl: './novel-rankings-page.component.html',
  styleUrl: './novel-rankings-page.component.css'
})
export class NovelRankingsPageComponent {

}
