import { Component } from '@angular/core';
import { Ranking } from '../../../models/ranking';
import { CommonModule } from '@angular/common';
import { RankingNovelService } from '../../../services/ranking-novel.service';
import { RankingTitleItemComponent } from './ranking-title-item/ranking-title-item.component';

@Component({
  selector: 'app-ranking-title-list',
  standalone: true,
  imports: [RankingTitleItemComponent,
            CommonModule],
  templateUrl: './ranking-title-list.component.html',
  styleUrl: './ranking-title-list.component.css'
})
export class RankingTitleListComponent {
  constructor(private novelService: RankingNovelService) {}

  ngOnInit() {
    this.setActive(this.activeItem);
  }
  
  items: Ranking[] = [
    {name: 'Trending', URL: 'url', iconText: 'trending_up'},
    {name: 'Read a lot', URL: 'url', iconText: 'menu_book'},
    {name: 'Reward', URL: 'url', iconText: 'card_giftcard'},
    {name: 'Nominate', URL: 'url', iconText: 'how_to_vote'},
    {name: 'Favorite', URL: 'url', iconText: 'favorite'},
    {name: 'Discussion', URL: 'url', iconText: 'forum'}
  ];
  
  activeItem = this.items[0]; // initially, the first item is active

  setActive(item: Ranking) {
    this.activeItem = item;
    this.novelService.fetchDataByRanking(item.URL).subscribe();
  }
}
