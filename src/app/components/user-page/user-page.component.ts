import { Component, ViewChild, ViewContainerRef } from '@angular/core';
import { MatTabsModule } from '@angular/material/tabs';
import { AccountSettingComponent } from './account-setting/account-setting.component';
import { AccountSecurityComponent } from './account-security/account-security.component';

@Component({
  selector: 'app-user-page',
  standalone: true,
  imports: [AccountSecurityComponent,
            AccountSettingComponent,
            MatTabsModule
  ],
  templateUrl: './user-page.component.html',
  styleUrl: './user-page.component.css'
})
export class UserPageComponent {
  @ViewChild('dynamicComponentContainer', { read: ViewContainerRef }) container!: ViewContainerRef;
  selectedTab = 0;
  selectedTabClass = ['selected', ''];

  ngAfterViewInit() {
    this.container.createComponent(AccountSettingComponent);
  }

  onTabChange() {
    this.container.clear();
    this.selectedTabClass = ['', '']; // reset all to normal
    this.selectedTabClass[this.selectedTab] = 'selected'; // set selected class to current tab

    switch (this.selectedTab) {
      case 0:
        this.container.createComponent(AccountSettingComponent);
        break;
      case 1:
        this.container.createComponent(AccountSecurityComponent);
        break;
    }
  }
}
