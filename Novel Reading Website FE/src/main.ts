import { Component } from '@angular/core';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { bootstrapApplication } from '@angular/platform-browser';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { RouterLink, RouterOutlet, provideRouter } from '@angular/router';
import { routes } from './app/app.routes';
import { NavbarComponent } from './app/components/shared-components/navbar/navbar.component';
import 'hammerjs';
import 'zone.js';
import { CommonModule } from '@angular/common';
import { provideHttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,
            RouterLink,
            NavbarComponent,
            CommonModule
            ],
  templateUrl: `./main.html`,
})
export class App {
  constructor(private router: Router, private activatedRoute: ActivatedRoute) {}
  
  ngAfterViewInit() { // Call after view initialization
    this.shouldShowNavbar();
  }

  shouldShowNavbar(): boolean {
    // Get the current route
    const currentRoute = this.router.routerState.snapshot.url;

    // Define the routes where the navbar should be hidden
    const hiddenRoutes = ['/uploaded-novel', '/uploaded-novel-detail/add-chapter', '/uploaded-novel/upload-new-novel'];

    return !hiddenRoutes.includes(currentRoute);
  }
}

bootstrapApplication(App, {
  providers: [provideAnimationsAsync(),
              provideRouter(routes),
              provideHttpClient()]
});

