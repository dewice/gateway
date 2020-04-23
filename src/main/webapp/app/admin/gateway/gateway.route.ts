import { Route } from '@angular/router';

import { GatewayComponent } from './gateway.component';

export const gatewayRoute: Route = {
    path: 'gateway',
    component: GatewayComponent,
    data: {
        pageTitle: 'Gateway'
    }
};
