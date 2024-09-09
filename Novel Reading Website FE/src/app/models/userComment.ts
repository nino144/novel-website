export interface userComment {
  imageURL: string;
  name: string;
  time: number;
  comment: string;
  likeCount: number;
  dislikeCount: number;
  answerCount: number;
  chapterNumber: number;
  chapterTitle: string;
  rating?: number;
  depth: number;
  replies?: userComment[]; // This property represents the replies to this comment.
}
