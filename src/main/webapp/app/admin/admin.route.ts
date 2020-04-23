import { Routes } from '@angular/router';

import {
    auditsRoute,
    configurationRoute,
    docsRoute,
    healthRoute,
    logsRoute,
    logViewerRoute,
    metricsRoute,
    userMgmtRoute,
    gatewayRoute,
    trackerRoute
} from './';

import { UserRouteAccessService } from '../../app/core';

const ADMIN_ROUTES = [
    auditsRoute,
    configurationRoute,
    docsRoute,
    healthRoute,
    logsRoute,
    logViewerRoute,
    ...userMgmtRoute,
    metricsRoute,
    gatewayRoute,
    trackerRoute
];

export const adminState: Routes = [
    {
        path: '',
        data: {
            authorities: ['ROLE_ADMIN']
        },
        canActivate: [UserRouteAccessService],
        children: ADMIN_ROUTES
    }
];
