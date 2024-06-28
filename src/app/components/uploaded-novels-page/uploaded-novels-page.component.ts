import { Component } from '@angular/core';
import { PaginatorComponent } from '../shared-components/paginator/paginator.component';
import { UploadedNovelsComponent } from './uploaded-novels/uploaded-novels.component';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-uploaded-novels-page',
  standalone: true,
  imports: [PaginatorComponent,
            UploadedNovelsComponent,
            RouterLink],
  templateUrl: './uploaded-novels-page.component.html',
  styleUrl: './uploaded-novels-page.component.css'
})
export class UploadedNovelsPageComponent {

}
