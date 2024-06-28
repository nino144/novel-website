import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReplyingUserService {
  private replyingUserSource = new BehaviorSubject<string>('');
  currentReplyingUser = this.replyingUserSource.asObservable();

  constructor() { }

  changeReplyingUser(user: string) {
    this.replyingUserSource.next(user);
  }
}
