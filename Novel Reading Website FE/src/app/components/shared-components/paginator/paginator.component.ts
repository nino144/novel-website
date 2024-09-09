import { Component, Input, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-paginator',
  standalone: true,
  imports: [CommonModule,
            MatIconModule],
  templateUrl: './paginator.component.html',
  styleUrl: './paginator.component.css'
})
export class PaginatorComponent {
  @Input() Pages!: number;
  @Input() currentPage!: number;
  @Input() size!: number; // Set size to 2 for showing 2 pages before and after
  start!: number;
  end!: number;

  ngOnChanges(changes: SimpleChanges) {
    if (changes['currentPage'] || changes['Pages']) {
      this.updatePagination();
    }
  }


  updatePagination() {
    this.start = Math.max(Math.floor(this.currentPage - this.size / 2), 1);
    this.end = Math.min(this.start + this.size - 1, this.Pages);
  
    if (this.end - this.start < this.size - 1) {
      this.start = Math.max(this.end - this.size + 1, 1);
    }
  }

  get pages(): number[] {
    let pages = [];
    for (let no = this.start; no <= this.end; no++) {
      pages.push(no);
    }
    return pages;
  }
}
