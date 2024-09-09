import { Component } from '@angular/core';
import { Novel } from '../../../models/novel';
import { NovelListComponent } from '../../shared-components/novel-list/novel-list.component';
import { NovelService } from '../../../services/novel.service';

@Component({
  selector: 'app-highly-discussed-novels',
  standalone: true,
  imports: [NovelListComponent],
  templateUrl: './highly-discussed-novels.component.html',
  styleUrl: './highly-discussed-novels.component.css'
})
export class HighlyDiscussedNovelsComponent {
  cols: number = 2; // you can change this value as needed
  data!: Novel[];

  constructor(private novelService: NovelService) {}

  ngOnInit() {
    this.getHighlyDiscussedNovels();
  }

  getHighlyDiscussedNovels() {
    this.data = this.novelService.getHighlyDiscussedNovels(); // Call getComments and assign to comments
  }
}
