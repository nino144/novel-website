import { Component, ViewChild, ViewContainerRef, OnInit } from '@angular/core';
import { DiscussionComponent } from './discussion/discussion.component';
import { ReviewComponent } from './review/review.component';
import { MatTabsModule } from '@angular/material/tabs';

@Component({
  selector: 'app-community',
  standalone: true,
  imports: [ReviewComponent,
            DiscussionComponent,
            MatTabsModule],
  templateUrl: './community.component.html',
  styleUrl: './community.component.css'
})
export class CommunityComponent{
  @ViewChild('dynamicComponentContainer', { read: ViewContainerRef }) container!: ViewContainerRef;
  selectedTab = 0;
  selectedTabClass = ['selected', ''];

  ngAfterViewInit() {
    this.container.createComponent(ReviewComponent);
  }

  onTabChange() {
    this.container.clear();
    this.selectedTabClass = ['', '']; // reset all to normal
    this.selectedTabClass[this.selectedTab] = 'selected'; // set selected class to current tab

    switch (this.selectedTab) {
      case 0:
        this.container.createComponent(ReviewComponent);
        break;
      case 1:
        this.container.createComponent(DiscussionComponent);
        break;
    }
  }
}
