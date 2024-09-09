import { Component, ViewChild } from '@angular/core';
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
import { PaginatorComponent } from '../../shared-components/paginator/paginator.component';
import { UserService } from '../../../services/user.service';
import { NovelService } from '../../../services/novel.service';

@Component({
  selector: 'app-manage-users',
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
            PaginatorComponent],
  templateUrl: './manage-users.component.html',
  styleUrl: './manage-users.component.css'
})
export class ManageUsersComponent {
  @ViewChild(MatSort) sort!: MatSort;
  displayedColumns: string[] = ['userId', 'userName', 'active', 'actions'];

  users!: any[];
  dataSource!: MatTableDataSource<any>;

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.getUsers();
    this.dataSource = new MatTableDataSource(this.users);
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  getUsers() {
    this.users = this.userService.getUsers(); // Call getComments and assign to comments
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  setActive(userId: number, isActive: boolean) {
    const user = this.users.find(u => u.userId === userId);
    if (user) {
        user.active = isActive; // Update the active status
        this.dataSource.data = [...this.users]; // Refresh the data source
    }
  }
  
}
