import { Component } from '@angular/core';
import { NovelOverviewComponent } from './novel-overview/novel-overview.component';
import { UploaderWorksComponent } from './uploader-works/uploader-works.component';
import { CommunityComponent } from './community/community.component';
import { OverviewChaptersComponent } from './overview-chapters/overview-chapters.component';
import { NovelDescriptionComponent } from './novel-description/novel-description.component';
import { NovelService } from '../../services/novel.service';
import { Novel } from '../../models/novel';
import { AuthorWorksComponent } from './author-works/author-works.component';

@Component({
  selector: 'app-novel-detail-page',
  standalone: true,
  imports: [NovelOverviewComponent,
            OverviewChaptersComponent,
            UploaderWorksComponent,
            AuthorWorksComponent,
            NovelDescriptionComponent,
            CommunityComponent
            ],
  templateUrl: './novel-detail-page.component.html',
  styleUrl: './novel-detail-page.component.css'
})

export class NovelDetailPageComponent {
  novelDetail!: Novel;

  constructor(private novelService: NovelService) {}

  ngOnInit() {
    this.getNovelDetail();
  }

  getNovelDetail() {
    this.novelDetail = this.novelService. getNovelDetail(); 
  }
}




