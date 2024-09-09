import { Injectable } from '@angular/core';
import { Novel } from '../models/novel';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject } from 'rxjs';
import { tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class RankingNovelService {

  private _data = new BehaviorSubject<Novel[]>([]);

  //constructor(private http: HttpClient) {}

  get data() {
    return this._data.asObservable();
  }

  // fetchDataByRanking(url: string) {
  //   return this.http.get<Novel[]>('http://your-api-url/rankingnovel/' + url).pipe(
  //     tap(data => {
  //       this._data.next(data);
  //     })
  //   );
  // }

  fetchDataByRanking(url: string) {
    // This is your static data
    const data: Novel[] = [
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description:'A fascinating Novel',
        author: 'Joe',
        category: 'Historical',
        chapter: 1111
      }
    ];

    // Update _data with the static data
    this._data.next(data);

    // Return _data as an Observable
    return this._data.asObservable();
  }
}
