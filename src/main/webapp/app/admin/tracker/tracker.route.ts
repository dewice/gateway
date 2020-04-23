import { Route } from '@angular/router';

import { TrackerComponent } from './tracker.component';

export const trackerRoute: Route = {
    path: 'tracker',
    component: TrackerComponent,
    data: {
        pageTitle: 'Real-time user activities'
    }
};
