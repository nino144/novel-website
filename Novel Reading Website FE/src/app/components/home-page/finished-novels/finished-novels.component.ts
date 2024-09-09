import { Component } from '@angular/core';
import { NovelListComponent } from '../../shared-components/novel-list/novel-list.component';
import { Novel } from '../../../models/novel';
import { NovelService } from '../../../services/novel.service';

@Component({
  selector: 'app-finished-novels',
  standalone: true,
  imports: [NovelListComponent],
  templateUrl: './finished-novels.component.html',
  styleUrl: './finished-novels.component.css'
})
export class FinishedNovelsComponent {
  cols: number = 2; // you can change this value as needed
  data!: Novel[];

  constructor(private novelService: NovelService) {}

  ngOnInit() {
    this.getFinishedNovels();
  }

  getFinishedNovels() {
    this.data = this.novelService.getFinishedNovels(); // Call getComments and assign to comments
  }

}
