import { Injectable } from '@angular/core';
import { userComment } from '../models/userComment';

@Injectable({
  providedIn: 'root'
})
export class ReviewService {

  constructor() { }

  getReviews(): userComment[] {
      return [
        {
          imageURL: 'https://static.cdnno.com/poster/theo-tram-yeu-tru-ma-bat-dau-truong-sinh-bat-tu/300.jpg?1702546489',
          name: 'name1',
          time: 1,
          comment: 'comment1 comment1 ',
          likeCount: 10,
          dislikeCount: 4,
          answerCount: 5,
          chapterNumber: 1,
          chapterTitle: 'chapterTitle1',
          rating: 4,
          depth: 0,
          replies: [
            {
              imageURL: 'https://static.cdnno.com/poster/theo-tram-yeu-tru-ma-bat-dau-truong-sinh-bat-tu/300.jpg?1702546489',
              name: 'name-sub 1',
              time: 2,
              comment: 'comment sub',
              likeCount: 20,
              dislikeCount: 4,
              answerCount: 10,
              chapterNumber: 2,
              chapterTitle: 'chapterTitle2',
              rating: 4,
              depth: 1,
              replies: [
                {
                  imageURL: 'https://static.cdnno.com/poster/theo-tram-yeu-tru-ma-bat-dau-truong-sinh-bat-tu/300.jpg?1702546489',
                  name: 'name-sub 2',
                  time: 2,
                  comment: 'comment sub',
                  likeCount: 20,
                  dislikeCount: 4,
                  answerCount: 10,
                  chapterNumber: 2,
                  chapterTitle: 'chapterTitle2',
                  rating: 4,
                  depth: 2,
                  replies: []
                }
              ]
            }
          ]
        },
        {
          imageURL: 'https://static.cdnno.com/poster/theo-tram-yeu-tru-ma-bat-dau-truong-sinh-bat-tu/300.jpg?1702546489',
          name: 'name2',
          time: 2,
          comment: 'comment2',
          likeCount: 20,
          dislikeCount: 4,
          answerCount: 10,
          chapterNumber: 2,
          chapterTitle: 'chapterTitle2',
          rating: 4,
          depth: 0,
          replies: []
        },
        {
          imageURL: 'https://static.cdnno.com/poster/theo-tram-yeu-tru-ma-bat-dau-truong-sinh-bat-tu/300.jpg?1702546489',
          name: 'name3',
          time: 3,
          comment: 'comment3',
          likeCount: 30,
          dislikeCount: 4,
          answerCount: 15,
          chapterNumber: 3,
          chapterTitle: 'chapterTitle3',
          rating: 4,
          depth: 0,
          replies: []
        },
        {
          imageURL: 'https://static.cdnno.com/poster/theo-tram-yeu-tru-ma-bat-dau-truong-sinh-bat-tu/300.jpg?1702546489',
          name: 'name4',
          time: 4,
          comment: 'comment4',
          likeCount: 40,
          dislikeCount: 4,
          answerCount: 20,
          chapterNumber: 4,
          chapterTitle: 'chapterTitle4',
          rating: 4,
          depth: 0,
          replies: []
        },
        {
          imageURL: 'https://static.cdnno.com/poster/theo-tram-yeu-tru-ma-bat-dau-truong-sinh-bat-tu/300.jpg?1702546489',
          name: 'name5',
          time: 5,
          comment: 'comment5',
          likeCount: 50,
          dislikeCount: 4,
          answerCount: 25,
          chapterNumber: 5,
          chapterTitle: 'chapterTitle5',
          rating: 4,
          depth: 0,
          replies: []
        }
      ];
  }
}
