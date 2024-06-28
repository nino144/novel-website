import { Component, Input } from '@angular/core';
import { CollectionItemComponent } from './collection-item/collection-item.component';
import { CommonModule } from '@angular/common';
import { ReadProgress } from '../../../models/read-progress';

@Component({
  selector: 'app-collection',
  standalone: true,
  imports: [CollectionItemComponent,
            CommonModule],
  templateUrl: './collection.component.html',
  styleUrl: './collection.component.css'
})
export class CollectionComponent {
  @Input() novels!: ReadProgress[];
  @Input() isMarkedNovels!: boolean;
  removeNovel(novelToRemove: ReadProgress): void {
    this.novels = this.novels.filter(novel => novel !== novelToRemove);
  }
}
