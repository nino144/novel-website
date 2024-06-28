import { Injectable } from '@angular/core';
import { NovelSummary } from '../models/novel-summary';

@Injectable({
  providedIn: 'root'
})
export class WeeklyHighlightNovelsService {

  constructor() { }

  getWeeklyNominatedNovels(): NovelSummary[] {
    return [
      { 
        name: 'You are my exception', 
        author: 'Dolores', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png' 
      },
      { 
        name: 'You are my exception', 
        author: 'Dolores', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'You are my exception', 
        author: 'Dolores', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'You are my exception', 
        author: 'Dolores', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'You are my exception', 
        author: 'Dolores', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'You are my exception', 
        author: 'Dolores', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'You are my exception', 
        author: 'Dolores', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'You are my exception', 
        author: 'Dolores', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'You are my exception', 
        author: 'Dolores', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'You are my exception', 
        author: 'Dolores', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      }
    ];
  }

  getWeeklyTopReadNovels(): NovelSummary[] {
    return [
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png' 
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      }
    ];
  }

  getWeeklyTopDiscussedNovels(): NovelSummary[] {
    return [
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png' 
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png' 
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png' 
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      },
      { 
        name: 'Crazy Stupid Love', 
        author: 'Vladimir Naokov', 
        category: 'Love Story', 
        views: 26601, 
        imageURL: 'https://i.pinimg.com/originals/7c/14/fc/7c14fc2b3872604368bc202508fd7845.png'
      }
    ];
  }
}
