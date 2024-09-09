import { Injectable } from '@angular/core';
import { ReadProgress } from '../models/read-progress';

@Injectable({
  providedIn: 'root'
})
export class CollectionService {

  constructor() { }

  getReadProgess(): ReadProgress[] {
    return [
      {
        novelName: 'The Bygone Day',
        chapterTitle: 'Windy Hill',
        imageURL: 'https://static.cdnno.com/poster/ta-tai-pham-nhan-khoa-hoc-tu-tien/150.jpg?1607240603',
        chapter: 206,
        time: '2024-04-24 21:20:07',
        isNotify: true,
        totalChapter: 500
      },
      {
        novelName: 'The Bygone Day',
        chapterTitle: 'Windy Hill',
        imageURL: 'https://static.cdnno.com/poster/ta-tai-pham-nhan-khoa-hoc-tu-tien/150.jpg?1607240603',
        chapter: 206,
        time: '2024-04-24 21:20:07',
        isNotify: true,
        totalChapter: 500
      },
      {
        novelName: 'The Bygone Day',
        chapterTitle: 'Windy Hill',
        imageURL: 'https://static.cdnno.com/poster/ta-tai-pham-nhan-khoa-hoc-tu-tien/150.jpg?1607240603',
        chapter: 206,
        time: '2024-04-24 21:20:07',
        isNotify: true,
        totalChapter: 500
      },
      {
        novelName: 'The Bygone Day',
        chapterTitle: 'Windy Hill',
        imageURL: 'https://static.cdnno.com/poster/ta-tai-pham-nhan-khoa-hoc-tu-tien/150.jpg?1607240603',
        chapter: 206,
        time: '2024-04-24 21:20:07',
        isNotify: true,
        totalChapter: 500
      },
      {
        novelName: 'The Bygone Day',
        chapterTitle: 'Windy Hill',
        imageURL: 'https://static.cdnno.com/poster/ta-tai-pham-nhan-khoa-hoc-tu-tien/150.jpg?1607240603',
        chapter: 206,
        time: '2024-04-24 21:20:07',
        totalChapter: 500
      }
    ]
  }

  getMarkedNovels(): ReadProgress[] {
    return [
      {
        novelName: 'The Bygone Day',
        chapterTitle: 'Windy Hill',
        imageURL: 'https://static.cdnno.com/poster/ta-tai-pham-nhan-khoa-hoc-tu-tien/150.jpg?1607240603',
        chapter: 206,
        time: '2024-04-24 21:20:07',
        totalChapter: 500
      },
      {
        novelName: 'The Bygone Day',
        chapterTitle: 'Windy Hill',
        imageURL: 'https://static.cdnno.com/poster/ta-tai-pham-nhan-khoa-hoc-tu-tien/150.jpg?1607240603',
        chapter: 206,
        time: '2024-04-24 21:20:07',
        totalChapter: 500
      },
      {
        novelName: 'The Bygone Day',
        chapterTitle: 'Windy Hill',
        imageURL: 'https://static.cdnno.com/poster/ta-tai-pham-nhan-khoa-hoc-tu-tien/150.jpg?1607240603',
        chapter: 206,
        time: '2024-04-24 21:20:07',
        totalChapter: 500
      },
      {
        novelName: 'The Bygone Day',
        chapterTitle: 'Windy Hill',
        imageURL: 'https://static.cdnno.com/poster/ta-tai-pham-nhan-khoa-hoc-tu-tien/150.jpg?1607240603',
        chapter: 206,
        time: '2024-04-24 21:20:07',
        totalChapter: 500
      },
      {
        novelName: 'The Bygone Day',
        chapterTitle: 'Windy Hill',
        imageURL: 'https://static.cdnno.com/poster/ta-tai-pham-nhan-khoa-hoc-tu-tien/150.jpg?1607240603',
        chapter: 206,
        time: '2024-04-24 21:20:07',
        totalChapter: 500
      }
    ]
  }
}
