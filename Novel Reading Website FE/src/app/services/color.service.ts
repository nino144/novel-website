import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ColorService {

  constructor() { }

  getColors() {
    return ['#FF5733', '#3498DB', '#27AE60', '#F1C40F', '#9B59B6'];
  }
}
