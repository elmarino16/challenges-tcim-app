import { Route } from '@angular/router';

import { AuthenticationComponent } from './authentication.component';

export const authenticationRoute: Route = {
  path: 'authentication',
  component: AuthenticationComponent,
  data: {
    authorities: [],
    pageTitle: 'home.title'
  }
};
