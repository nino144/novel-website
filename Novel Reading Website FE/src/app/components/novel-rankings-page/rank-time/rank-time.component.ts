import { Component } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { MatMenuModule } from '@angular/material/menu';

@Component({
  selector: 'app-rank-time',
  standalone: true,
  imports: [MatMenuModule,
            MatIconModule
          ],
  templateUrl: './rank-time.component.html',
  styleUrl: './rank-time.component.css'
})
export class RankTimeComponent {

}
