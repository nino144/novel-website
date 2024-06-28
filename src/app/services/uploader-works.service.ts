import { Injectable } from '@angular/core';
import { UploaderWorks } from '../models/uploader-works';

@Injectable({
  providedIn: 'root'
})
export class UploaderWorksService {

  constructor() { }

  getUploaderWorks(): UploaderWorks[] {
    return [
      {
        imageURL: 'https://static.cdnno.com/poster/long-vu-kiem-than/300.jpg?1585206011',
        name: 'Togetherness'
      },
      {
        imageURL: 'https://static.cdnno.com/poster/long-vu-kiem-than/300.jpg?1585206011',
        name: 'Togetherness'
      },
      {
        imageURL: 'https://static.cdnno.com/poster/long-vu-kiem-than/300.jpg?1585206011',
        name: 'Togetherness'
      },
      {
        imageURL: 'https://static.cdnno.com/poster/long-vu-kiem-than/300.jpg?1585206011',
        name: 'Togetherness'
      },
      {
        imageURL: 'https://static.cdnno.com/poster/long-vu-kiem-than/300.jpg?1585206011',
        name: 'Togetherness'
      }
    ];
  }
}
