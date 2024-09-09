import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatToolbarModule } from '@angular/material/toolbar';
import { RouterLink } from '@angular/router';
import { NovelGenresService } from '../../../services/novel-genres.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [
    CommonModule,
    MatMenuModule,
    MatIconModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatToolbarModule,
    RouterLink
  ],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  categories!: String[];

  constructor(private novelGenresService: NovelGenresService) {}

  ngOnInit() {
    this.getCategories();
  }

  getCategories() {
    this.categories = this.novelGenresService.getCategories(); // Call getComments and assign to comments
  }

  notifications = [
    { text: 'Notification 1', active: false },
    { text: 'Notification 2', active: false },
    { text: 'Notification 2', active: false },
    { text: 'Notification 2', active: false },
    { text: 'Notification 2', active: false },
    { text: 'Notification 2', active: false },
    { text: 'Notification 2', active: false },
    { text: 'Notification 3', active: false },
    // Add more notifications as needed
  ];

  selectNotification(notification: any) {
    this.notifications.forEach(n => n.active = false); // Reset all
    notification.active = true; // Set clicked notification as active
  }
}
