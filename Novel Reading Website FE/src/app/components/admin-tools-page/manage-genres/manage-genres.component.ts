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
import { NovelGenresService } from '../../../services/novel-genres.service';

@Component({
  selector: 'app-manage-genres',
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
  templateUrl: './manage-genres.component.html',
  styleUrl: './manage-genres.component.css'
})
export class ManageGenresComponent {
  @ViewChild(MatSort) sort!: MatSort;
  displayedColumns: string[] = ['genreType', 'genreName', 'active', 'actions'];

  genres!: any[];
  dataSource!: MatTableDataSource<any>;

  constructor(private novelGenresService: NovelGenresService) {}

  ngOnInit() {
    this.getGenres();
    this.dataSource = new MatTableDataSource(this.genres);
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
  }

  getGenres() {
    this.genres = this.novelGenresService.getGenres(); // Call getComments and assign to comments
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

  setActive(genreType: String, genreName: String, isActive: boolean) {
    const genre = this.genres.find(n => n.genreType === genreType && n.genreName === genreName);
    if (genre) {
        genre.active = isActive;
        this.dataSource.data = [...this.genres];
    }
  }
}
