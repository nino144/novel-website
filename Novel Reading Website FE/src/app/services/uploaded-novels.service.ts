import { Injectable } from '@angular/core';
import { UploadedNovelsInfo } from '../models/uploaded-novels-info';
import { UploadedNovelDetail } from '../models/uploaded-novel-detail';

@Injectable({
  providedIn: 'root'
})
export class UploadedNovelsService {

  constructor() { }

  getUploadedNovelsInfo(): UploadedNovelsInfo[] {
    return [
      { 
        novelName: 'dune 1', 
        type: 'convert', 
        chapters: 200
      }, // Modify user details as needed
      { 
        novelName: 'dune 2', 
        type: 'convert', 
        chapters: 400
      },
      { 
        novelName: 'dune 3', 
        type: 'convert', 
        chapters: 600
      },
      { 
        novelName: 'dune 4', 
        type: 'convert', 
        chapters: 800
      },
      { 
        novelName: 'dune 5', 
        type: 'convert', 
        chapters: 1000
      },
    ];
  }

  getUploadedNovelDetail(): UploadedNovelDetail[] {
    return [
      {
          "chapter": 1,
          "chapterName": 'something',
          "open": true,
          "views": 2040,
          "chapterLength": 2000,
          "publishedDate": '02/01/2001',
      },
      {
        "chapter": 2,
        "chapterName": 'something 2',
        "open": false,
        "views": 2000,
        "chapterLength": 2000,
        "publishedDate": '02/01/2001',
      },
      {
        "chapter": 4,
        "chapterName": 'something 4',
        "open": true,
        "views": 2000,
        "chapterLength": 2000,
        "publishedDate": '02/01/2001',
      },
      {
        "chapter": 5,
        "chapterName": 'something 5',
        "open": false,
        "views": 2000,
        "chapterLength": 2000,
        "publishedDate": '02/01/2001',
      },
      {
        "chapter": 6,
        "chapterName": 'something 6',
        "open": true,
        "views": 2000,
        "chapterLength": 2000,
        "publishedDate": '02/01/2001',
      }
    ];
  }
}
