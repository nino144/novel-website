import { Component } from '@angular/core';
import { Novel } from '../../../models/novel';
import { NovelListComponent } from '../../shared-components/novel-list/novel-list.component';
import { NovelService } from '../../../services/novel.service';

@Component({
  selector: 'app-nominated-novels',
  standalone: true,
  imports: [NovelListComponent],
  templateUrl: './nominated-novels.component.html',
  styleUrl: './nominated-novels.component.css'
})
export class NominatedNovelsComponent {
  cols: number = 2; // you can change this value as needed
  data!: Novel[];

  constructor(private novelService: NovelService) {}

  ngOnInit() {
    this.getNominatedNovels();
  }

  getNominatedNovels() {
    this.data = this.novelService.getNominatedNovels(); // Call getComments and assign to comments
  }
}
