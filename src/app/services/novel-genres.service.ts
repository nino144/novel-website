import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NovelGenresService {

  constructor() { }

  getCategories(): String[] {
    return ['Immortal Heroes', 'Mysterious Fantasy', 'Science Fantasy', 'Online Travel', 'Urban', 'Wild History', 'Edge Skills', 'Mysterious', 'Sword Heroes', 'Fantastic', 'Light Novel'];
  }

  getChapters(): String[] {
    return ['50', '100', '200', '500', '1000'];
  }

  getCharacterTraits(): String[] {
    return ['Calm', 'Enthusiastic', 'Shameless', 'Wholehearted', 'Gentle', 'Cunning', 'Cold-blooded', 'Arrogant', 'Foolish', 'Crafty'];
  }

  getStatus(): String[] {
    return ['On going', 'Drop', 'Completed'];
  }

  getVisions(): String[] {
    return ['Male Perspective', 'Female Perspective', 'First Person'];
  }

  getWorldContexts(): String[] {
    return ['World Context', 'Eastern Fantasy', 'Different World Continent', 'Reign of Controversy', 'World High Martial Arts', 'Western Fantasy', 'Modern Magic', 'Illusory Darkness', 'History of Mythology', 'Illusory Martial Arts', 'Ancient Martial Future', 'Cultivation Civilization', 'Illusory Cultivation Immortal', 'Modern Cultivation', 'Mythical Cultivation', 'Classical Immortal Hero'];
  }
}
