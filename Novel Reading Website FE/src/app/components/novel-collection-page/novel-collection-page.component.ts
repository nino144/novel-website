import { Component, ViewChild, ViewContainerRef } from '@angular/core';
import { CurrentlyReadingNovelsComponent } from './currently-reading-novels/currently-reading-novels.component';
import { MarkedNovelsComponent } from './marked-novels/marked-novels.component';
import { MatTabsModule } from '@angular/material/tabs';
import { PaginatorComponent } from '../shared-components/paginator/paginator.component';

@Component({
  selector: 'app-novel-collection-page',
  standalone: true,
  imports: [CurrentlyReadingNovelsComponent,
            MarkedNovelsComponent,
            MatTabsModule,
            PaginatorComponent],
  templateUrl: './novel-collection-page.component.html',
  styleUrl: './novel-collection-page.component.css'
})
export class NovelCollectionPageComponent {
  @ViewChild('dynamicComponentContainer', { read: ViewContainerRef }) container!: ViewContainerRef;
  selectedTab = 0;
  selectedTabClass = ['selected', ''];

  ngAfterViewInit() {
    this.container.createComponent(CurrentlyReadingNovelsComponent);
  }

  onTabChange() {
    this.container.clear();
    this.selectedTabClass = ['', '']; // reset all to normal
    this.selectedTabClass[this.selectedTab] = 'selected'; // set selected class to current tab

    switch (this.selectedTab) {
      case 0:
        this.container.createComponent(CurrentlyReadingNovelsComponent);
        break;
      case 1:
        this.container.createComponent(MarkedNovelsComponent);
        break;
    }
  }
}
