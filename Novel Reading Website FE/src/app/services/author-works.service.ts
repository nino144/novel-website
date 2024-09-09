import { Injectable } from '@angular/core';
import { AuthorWorks } from '../models/author-works';

@Injectable({
  providedIn: 'root'
})
export class AuthorWorksService {

  constructor() { }

  getAuthorWorks(): AuthorWorks[] {
    return [
      {
        category: 'Historical',
        name: 'Gone With The Wind',
        status: 'On going',
        chapter: 1422
      },
      {
        category: 'Romantic',
        name: 'Lolita',
        status: 'On going',
        chapter: 226
      },
      {
        category: 'Historical',
        name: 'Lord of Mysteries',
        status: 'Paused',
        chapter: 100
      },
      {
        category: 'Historical',
        name: 'Dune',
        status: 'On going',
        chapter: 1426
      }
    ];
  }
}
