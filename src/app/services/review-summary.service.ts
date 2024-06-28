import { Injectable } from '@angular/core';
import { Review } from '../models/review';

@Injectable({
  providedIn: 'root'
})
export class ReviewSummaryService {

  constructor() { }

  getReviews(): Review[] {
    return [
      {
        imageURL: 'https://static.cdnno.com/poster/kim-dan-la-hang-tinh-nguoi-quan-cai-nay-goi-tu-tien/150.jpg?1694148320',
        userName: 'Nino144',
        name: 'The Bygone day',
        point: 5,
        description: 'It was love at first sight,at last sight,at ever and ever sight'
      },
      {
        imageURL: 'https://static.cdnno.com/poster/kim-dan-la-hang-tinh-nguoi-quan-cai-nay-goi-tu-tien/150.jpg?1694148320',
        userName: 'Nino144',
        name: 'The Bygone day',
        point: 5,
        description: 'It was love at first sight,at last sight,at ever and ever sight'
      }
      ,
      {
        imageURL: 'https://static.cdnno.com/poster/kim-dan-la-hang-tinh-nguoi-quan-cai-nay-goi-tu-tien/150.jpg?1694148320',
        userName: 'Nino144',
        name: 'The Bygone day',
        point: 5,
        description: 'It was love at first sight,at last sight,at ever and ever sight'
      }
    ];
  }
}
