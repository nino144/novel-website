import { Injectable } from '@angular/core';
import { User } from '../models/user';
import { UserReadStatistics } from '../models/userReadStatistics';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  getUserInfo(): User {
    return {
      imageURL: 'https://static.cdnno.com/user/3e8929ef181cdc1d601c6867eff3b572/200.jpg',
      name: 'Dolores',
      email: 'abc@gmail.com',
      dateOfBirth: '14/01/2001',
      gender: 'female'
    }
  }

  getUsers(): any {
    return [
      {
        userId: "111111111111",
        userName: "nino",
        active: "true"
      },
      {
        userId: "111111",
        userName: "lala",
        active: "true"
      },
      {
        userId: "1111",
        userName: "nino",
        active: "true"
      },
      {
        userId: "11111",
        userName: "nino",
        active: "true"
      }
    ]
  }

  getUserReadStatistics(): UserReadStatistics {
    return {
      joinDate: '15/8/2022',
      chaptersRead: 104004,
      storiesRead: 11111,
      bookMarked: 100,
      nominated: 40,
      comments: 10000,
      reviews: 5
    }
  }
}
