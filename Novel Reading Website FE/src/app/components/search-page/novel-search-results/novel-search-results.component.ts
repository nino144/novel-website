import { Component } from '@angular/core';
import { NovelListComponent } from '../../shared-components/novel-list/novel-list.component';
import { Novel } from '../../../models/novel';
import { NovelService } from '../../../services/novel.service';

@Component({
  selector: 'app-novel-search-results',
  standalone: true,
  imports: [NovelListComponent],
  templateUrl: './novel-search-results.component.html',
  styleUrl: './novel-search-results.component.css'
})
export class NovelSearchResultsComponent {
  cols: number = 2; // you can change this value as needed
  data!: Novel[];

  constructor(private novelService: NovelService) {}

  ngOnInit() {
    this.getNovelSearchResults();
  }

  getNovelSearchResults() {
    this.data = this.novelService.getNovelSearchResults(); 
  }
}
