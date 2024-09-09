import { Component } from '@angular/core';
import {MatSort, MatSortModule} from '@angular/material/sort';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import {MatPaginatorModule} from '@angular/material/paginator';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';
import { PaginatorComponent } from '../shared-components/paginator/paginator.component';
import { ManageUsersComponent } from './manage-users/manage-users.component';
import { ManageNovelsComponent } from './manage-novels/manage-novels.component';
import { ManageGenresComponent } from './manage-genres/manage-genres.component';

@Component({
  selector: 'app-admin-tools-page',
  standalone: true,
  imports: [MatFormFieldModule,
            MatInputModule,
            MatTableModule,
            MatSortModule,
            MatPaginatorModule,
            MatMenuModule,
            MatIconModule,
            MatButtonModule,
            CommonModule,
            RouterLink,
            PaginatorComponent,
            ManageUsersComponent,
            ManageNovelsComponent,
            ManageGenresComponent],
  templateUrl: './admin-tools-page.component.html',
  styleUrl: './admin-tools-page.component.css'
})
export class AdminToolsPageComponent {
  dataSource = [
    { name: 'Item 1', description: 'Description 1' },
    { name: 'Item 2', description: 'Description 2' },
    { name: 'Item 3', description: 'Description 3' },
  ];

  currentView: string = 'users'; // Default view

  onSelect(option: string) {
    this.currentView = option;
  }
}
