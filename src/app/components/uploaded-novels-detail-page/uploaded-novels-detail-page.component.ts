import {AfterViewInit, Component, ViewChild} from '@angular/core';
import {MatSort, MatSortModule} from '@angular/material/sort';
import { MatTableDataSource, MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatMenuModule } from '@angular/material/menu';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';
import { RouterLink } from '@angular/router';
import { UploadedNovelDetail } from '../../models/uploaded-novel-detail';
import { UploadedNovelsService } from '../../services/uploaded-novels.service';
import { PaginatorComponent } from '../shared-components/paginator/paginator.component';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { FlexLayoutModule } from '@angular/flex-layout';
import { SelectionModel } from '@angular/cdk/collections';

@Component({
  selector: 'app-uploaded-novels-detail-page',
  standalone: true,
  imports: [
    MatFormFieldModule,
    MatInputModule,
    MatTableModule,
    MatSortModule,
    MatMenuModule,
    MatIconModule,
    MatButtonModule,
    RouterLink,
    PaginatorComponent,
    MatCheckboxModule,
    FlexLayoutModule
  ],
  templateUrl: './uploaded-novels-detail-page.component.html',
  styleUrl: './uploaded-novels-detail-page.component.css'
})

export class UploadedNovelsDetailPageComponent {
  @ViewChild(MatSort) sort!: MatSort;
  displayedColumns: string[] = ['index', 'chapter', 'chapterName', 'open', 'views', 'chapterLength', 'publishedDate', 'actions'];
  statusIcon = 'expand_more'; // Initial icon for status menu
  filterIcon = 'expand_more'; // Initial icon for filter menu
  selected = new SelectionModel<any>(true, []);
  uploadedNovelDetail!: UploadedNovelDetail[];
  dataSource!: MatTableDataSource<UploadedNovelDetail>;

  constructor(private uploadedNovelsService: UploadedNovelsService) {}

  ngOnInit() {
    this.getUploadedNovelDetail();
    this.dataSource = new MatTableDataSource(this.uploadedNovelDetail);
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }


  getUploadedNovelDetail() {
    this.uploadedNovelDetail = this.uploadedNovelsService.getUploadedNovelDetail(); // Call getComments and assign to comments
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

  deleteChapter(row: UploadedNovelDetail) {
    const confirmation = confirm('Are you sure you want to delete this chapter?');
    if (confirmation) {
      //this.uploadedNovelsService.deleteChapter(row.chapter); // for now dont have this method yet
      this.uploadedNovelDetail = this.uploadedNovelDetail.filter(item => item.chapter !== row.chapter); 
      //filter out the row that have the speifig chapter
      this.dataSource.data = this.uploadedNovelDetail;
    }
  }

  // deleteSelectedRows() {
  //   if (this.selected.selected.length > 0) {
  //     const confirmation = confirm('Are you sure you want to delete the selected chapters?');
  //     if (confirmation) {
  //       console.log('Selected rows to be deleted:', this.selected.selected);  // Log selected rows
  
  //       // Loop through selected rows and filter them out
  //       this.dataSource.data = this.dataSource.data.filter(row => !this.selected.isSelected(row));
  //       this.selected.clear(); // Clear selection after deletion
  //     }
  //   }
  // }

  deleteSelectedRows() {
    if (this.selected.selected.length > 0) {
      const confirmation = confirm('Are you sure you want to delete the selected chapters?');
      if (confirmation) {
        console.log('Selected rows to be deleted:', this.selected.selected); // Log selected rows
  
        // Loop through selected rows and filter them out from both dataSource.data and uploadedNovelDetail
        this.uploadedNovelDetail = this.uploadedNovelDetail.filter(row => !this.selected.isSelected(row));
        this.dataSource.data = this.uploadedNovelDetail;
        this.selected.clear(); // Clear selection after deletion
      }
    }
  }
}
