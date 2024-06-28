import { Component } from '@angular/core';
import { ReadProgress } from '../../../models/read-progress';
import { CollectionService } from '../../../services/collection.service';
import { CollectionComponent } from '../../shared-components/collection/collection.component';

@Component({
  selector: 'app-marked-novels',
  standalone: true,
  imports: [CollectionComponent],
  templateUrl: './marked-novels.component.html',
  styleUrl: './marked-novels.component.css'
})
export class MarkedNovelsComponent {
  novels!: ReadProgress[];
  isMarkedNovels: boolean = true;  
  constructor(private collectionService: CollectionService) {}

  ngOnInit() {
    this.getMarkedNovels();
  }

  getMarkedNovels() {
    this.novels = this.collectionService.getMarkedNovels(); // Call getComments and assign to comments
  }
}
