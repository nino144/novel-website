import { Routes} from '@angular/router';
import { HomePageComponent } from './components/home-page/home-page.component';
import { SearchPageComponent } from './components/search-page/search-page.component';
import { NovelRankingsPageComponent } from './components/novel-rankings-page/novel-rankings-page.component';
import { ChapterDisplayPageComponent } from './components/chapter-display-page/chapter-display-page.component';
import { NovelDetailPageComponent } from './components/novel-detail-page/novel-detail-page.component';
import { NovelCollectionPageComponent } from './components/novel-collection-page/novel-collection-page.component';
import { UploadedNovelsPageComponent } from './components/uploaded-novels-page/uploaded-novels-page.component';
import { UploadedNovelsDetailPageComponent } from './components/uploaded-novels-detail-page/uploaded-novels-detail-page.component';
import { UploadNewChapterPageComponent } from './components/upload-new-chapter-page/upload-new-chapter-page.component';
import { UploadNewNovelPageComponent } from './components/upload-new-novel-page/upload-new-novel-page.component';
import { UserPageComponent } from './components/user-page/user-page.component';
import { EditUploadedNovelPageComponent } from './components/edit-uploaded-novel-page/edit-uploaded-novel-page.component';

export const routes: Routes = [
  { path: '', component: HomePageComponent },
  { path: 'user', component: UserPageComponent },
  { path: 'search', component: SearchPageComponent },
  { path: 'rank', component: NovelRankingsPageComponent },
  { path: 'chapter', component: ChapterDisplayPageComponent },
  { path: 'novel-detail', component: NovelDetailPageComponent },  
  { path: 'uploaded-novel', component: UploadedNovelsPageComponent },
  { path: 'novel-collection', component: NovelCollectionPageComponent }, 
  { path: 'uploaded-novel-detail', component: UploadedNovelsDetailPageComponent },
  { path: 'uploaded-novel/upload-new-novel', component: UploadNewNovelPageComponent },
  { path: 'uploaded-novel/edit-uploaded-novel', component: EditUploadedNovelPageComponent },
  { path: 'uploaded-novel-detail/add-chapter', component: UploadNewChapterPageComponent } 
];


