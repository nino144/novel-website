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
  selector: 'app-manage-novels',
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
  templateUrl: './manage-novels.component.html',
  styleUrl: './manage-novels.component.css'
})
export class ManageNovelsComponent {
  @ViewChild(MatSort) sort!: MatSort;
  displayedColumns: string[] = ['novelName', 'author', 'uploader', 'active', 'actions'];

  novels!: any[];
  dataSource!: MatTableDataSource<any>;

  constructor(private novelService: NovelService) {}

  ngOnInit() {
    this.getNovels();
    this.dataSource = new MatTableDataSource(this.novels);
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  getNovels() {
    this.novels = this.novelService.getNovels(); // Call getComments and assign to comments
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  setActive(novelName: String, isActive: boolean) {
    const novel = this.novels.find(u => u.novelName === novelName);
    if (novel) {
        novel.active = isActive; // Update the active status
        this.dataSource.data = [...this.novels]; // Refresh the data source
    }
  }
}
