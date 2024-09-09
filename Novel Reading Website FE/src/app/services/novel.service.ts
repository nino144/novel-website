import { Injectable } from '@angular/core';
import { Novel } from '../models/novel';
import { Reading } from '../models/reading';
import { UpdatedNovels } from '../models/updated-novels';

@Injectable({
  providedIn: 'root'
})
export class NovelService {

  constructor() { }

  getFinishedNovels(): Novel[] {
    return [
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      }
    ];
  }

  getHighlyDiscussedNovels(): Novel[] {
    return [
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      }
    ];
  }

  getNewNovels(): Novel[] {
    return [
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png', 
        name: 'Chain Saw',
        description: 'Eternal Darkness',
        author: 'Myself',
        category: 'Love Story'
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png', 
        name: 'Chain Saw',
        description: 'Eternal Darkness',
        author: 'Myself',
        category: 'Love Story'
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png', 
        name: 'Chain Saw',
        description: 'Eternal Darkness',
        author: 'Myself',
        category: 'Love Story'
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png', 
        name: 'Chain Saw',
        description: 'Eternal Darkness',
        author: 'Myself',
        category: 'Love Story'
      }
    ];
  }

  getNominatedNovels(): Novel[] {
    return [
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      }
    ];
  }

  getReadingNovels(): Reading[] {
    return [
      {
        imageURL: 'https://static.cdnno.com/poster/kim-dan-la-hang-tinh-nguoi-quan-cai-nay-goi-tu-tien/150.jpg?1694148320',
        name: 'The Bygone Day',
        chapter: 200,
        time: '1/2/2022'
      },
      {
        imageURL: 'https://static.cdnno.com/poster/kim-dan-la-hang-tinh-nguoi-quan-cai-nay-goi-tu-tien/150.jpg?1694148320',
        name: 'The Bygone Day',
        chapter: 200,
        time: '1/2/2022'
      },
      {
        imageURL: 'https://static.cdnno.com/poster/kim-dan-la-hang-tinh-nguoi-quan-cai-nay-goi-tu-tien/150.jpg?1694148320',
        name: 'The Bygone Day',
        chapter: 200,
        time: '1/2/2022'
      },
      {
        imageURL: 'https://static.cdnno.com/poster/kim-dan-la-hang-tinh-nguoi-quan-cai-nay-goi-tu-tien/150.jpg?1694148320',
        name: 'The Bygone Day',
        chapter: 200,
        time: '1/2/2022'
      },
      {
        imageURL: 'https://static.cdnno.com/poster/kim-dan-la-hang-tinh-nguoi-quan-cai-nay-goi-tu-tien/150.jpg?1694148320',
        name: 'The Bygone Day',
        chapter: 200,
        time: '1/2/2022'
      }
    ];
  }

  getUpdatedNovels(): UpdatedNovels[] {
    return [
      { 
        category: 'Historical', 
        name: 'The Bygone Day', 
        chapter: 'New chapter', 
        author: 'Author1', 
        uploader: 'Uploader1', 
        time: 'Time1' 
      },
      { 
        category: 'Historical', 
        name: 'The Bygone Day', 
        chapter: 'New chapter', 
        author: 'Author1', 
        uploader: 'Uploader1', 
        time: 'Time1' 
      },
      { 
        category: 'Historical', 
        name: 'The Bygone Day', 
        chapter: 'New chapter', 
        author: 'Author1', 
        uploader: 'Uploader1', 
        time: 'Time1' 
      },
      { 
        category: 'Historical', 
        name: 'The Bygone Day', 
        chapter: 'New chapter', 
        author: 'Author1', 
        uploader: 'Uploader1', 
        time: 'Time1' 
      },
      { 
        category: 'Historical', 
        name: 'The Bygone Day', 
        chapter: 'New chapter', 
        author: 'Author1', 
        uploader: 'Uploader1', 
        time: 'Time1'
      },
      { 
        category: 'Historical', 
        name: 'The Bygone Day', 
        chapter: 'New chapter', 
        author: 'Author1', 
        uploader: 'Uploader1', 
        time: 'Time1'
      },
      { 
        category: 'Historical', 
        name: 'The Bygone Day', 
        chapter: 'New chapter', 
        author: 'Author1', 
        uploader: 'Uploader1', 
        time: 'Time1'
      },
      { 
        category: 'Historical', 
        name: 'The Bygone Day', 
        chapter: 'New chapter', 
        author: 'Author1', 
        uploader: 'Uploader1', 
        time: 'Time1'
      }
    ];
  }

  getNovelSearchResults(): Novel[] {
    return [
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      },
      {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'Dune 1',
        description:'good novel',
        author: 'joe',
        category: 'Historical',
        chapter: 11
      }
    ];
  }

  getNovelDetail() {
    return {
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png',
        name: 'The Bygone Day',
        description: 'Short Decription',
        author: 'Myself',
        category: 'Historical',
        chapter: 3,
        novelPopularity: {
          views: 20000,
          nominates: 50,
          stores: 209,
          rating: 4
        },
        novelTraits: {
          'wordContext': 'History of Mythology',
          'vision': 'first person',
          'status': 'On Going',
          'characterTrait': 'Coward'
        }
    }
  }

  getNovels(): any {
    return [
      {
        novelName: "Bygone",
        author: "nino",
        uploader: "nino 2",
        active: "true"
      },
      {
        novelName: "Bygone 2",
        author: "nino",
        uploader: "nino 2",
        active: "true"
      },
      {
        novelName: "Bygone 3",
        author: "nino",
        uploader: "nino 2",
        active: "true"
      },
      {
        novelName: "Bygone 4",
        author: "nino",
        uploader: "nino 2",
        active: "true"
      }
    ]
  }
}
