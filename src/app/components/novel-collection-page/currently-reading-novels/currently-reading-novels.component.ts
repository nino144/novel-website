import { Component } from '@angular/core';
import { ReadProgress } from '../../../models/read-progress';
import { CollectionService } from '../../../services/collection.service';
import { CollectionComponent } from '../../shared-components/collection/collection.component';

@Component({
  selector: 'app-currently-reading-novels',
  standalone: true,
  imports: [CollectionComponent],
  templateUrl: './currently-reading-novels.component.html',
  styleUrl: './currently-reading-novels.component.css'
})
export class CurrentlyReadingNovelsComponent {
  novels!: ReadProgress[];
  constructor(private collectionService: CollectionService) {}

  ngOnInit() {
    this.getReadProgess();
  }

  getReadProgess() {
    this.novels = this.collectionService.getReadProgess(); // Call getComments and assign to comments
  }
}
