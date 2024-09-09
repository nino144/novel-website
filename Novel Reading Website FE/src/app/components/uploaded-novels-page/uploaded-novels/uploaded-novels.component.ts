import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSort, MatSortModule} from '@angular/material/sort';
import {MatTableDataSource, MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { UploadedNovelsInfo } from '../../../models/uploaded-novels-info';
import { UploadedNovelsService } from '../../../services/uploaded-novels.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-uploaded-novels',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatSortModule,
    MatPaginatorModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    RouterLink
  ],
  templateUrl: './uploaded-novels.component.html',
  styleUrls: ['./uploaded-novels.component.css'],
})

export class UploadedNovelsComponent implements AfterViewInit {
  @ViewChild(MatSort) sort!: MatSort;
  displayedColumns: string[] = ['novelName', 'type', 'chapters', 'actions'];
  statusIcon = 'expand_more'; // Initial icon for status menu
  filterIcon = 'expand_more'; // Initial icon for filter menu
  uploadedNovelsInfo!: UploadedNovelsInfo[];
  dataSource!: MatTableDataSource<UploadedNovelsInfo>;

  constructor(private uploadedNovelsService: UploadedNovelsService) {}

  ngOnInit() {
    this.getUploadedNovelsInfo();
    this.dataSource = new MatTableDataSource(this.uploadedNovelsInfo);
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  getUploadedNovelsInfo() {
    this.uploadedNovelsInfo = this.uploadedNovelsService.getUploadedNovelsInfo(); // Call getComments and assign to comments
  }

  toggleStatusIcon() {
    this.statusIcon = this.statusIcon === 'expand_more' ? 'expand_less' : 'expand_more';
  }

  toggleFilterIcon() {
    this.filterIcon = this.filterIcon === 'expand_more' ? 'expand_less' : 'expand_more';
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }
}