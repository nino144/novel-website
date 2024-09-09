import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { UpdatedNovels } from '../../models/updated-novels';
import { NewNovelsComponent } from './new-novels/new-novels.component';
import { NominatedNovelsComponent } from './nominated-novels/nominated-novels.component';
import { FinishedNovelsComponent } from './finished-novels/finished-novels.component';
import { HighlyDiscussedNovelsComponent } from './highly-discussed-novels/highly-discussed-novels.component';
import { UpdatedNovelsComponent } from './updated-novels/updated-novels.component';
import { WeeklyHighlightNovelsComponent } from './weekly-highlight-novels/weekly-highlight-novels.component';
import { ReadingNovelsComponent } from './reading-novels/reading-novels.component';
import { ReviewNovelsComponent } from './review-novels/review-novels.component';
import { NovelService } from '../../services/novel.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Component({
  selector: 'app-homepage',
  standalone: true,
  imports: [
            UpdatedNovelsComponent,
            CommonModule,
            WeeklyHighlightNovelsComponent,
            ReadingNovelsComponent,
            NewNovelsComponent,
            ReviewNovelsComponent,
            NominatedNovelsComponent,
            HighlyDiscussedNovelsComponent,
            FinishedNovelsComponent
          ],
  templateUrl: './home-page.component.html',
  styleUrl: './home-page.component.css'
})

export class HomePageComponent {
  changeColor = false;
  items!: UpdatedNovels[]; 
  postDataObj!: any; // Object to hold data for the POST request

  constructor(private novelService: NovelService) {}

  ngOnInit() {
    this.getUpdatedNovels();

    // this.helloService.getData().subscribe(
    //   (data) => {
    //     this.responseText = data;
    //     console.log(data);
    //   },
    //   (error) => {
    //     console.error(error);
    //   }
    // );

    // this.postDataObj = {
    //   name: 'John Doe',
    //   message: 'Hello from Angular!'
    // };

    // Call the service automatically on component initialization
    // this.sendDataAutomatically();
  }

  // sendDataAutomatically() {
  //   this.helloService.postData(this.postDataObj).subscribe(
  //     (response) => {
  //       console.log('POST request successful:', response);
  //     },
  //     (error) => {
  //       console.error('Error during POST request:', error);
  //     }
  //   );
  // }
  
  getUpdatedNovels() {
    this.items = this.novelService.getUpdatedNovels(); // Call getComments and assign to comments
  }
}
