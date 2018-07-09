import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';

import { NgSelectModule } from '@ng-select/ng-select';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { GatewaySharedModule } from '../../shared';
import { Components } from '../../shared/camel/component-type';

import {
    ToEndpointService,
    ToEndpointPopupService,
    ToEndpointComponent,
    ToEndpointDetailComponent,
    ToEndpointDialogComponent,
    ToEndpointPopupComponent,
    ToEndpointDeletePopupComponent,
    ToEndpointDeleteDialogComponent,
    toEndpointRoute,
    toEndpointPopupRoute,
} from './';

const ENTITY_STATES = [
    ...toEndpointRoute,
    ...toEndpointPopupRoute,
];

@NgModule({
    imports: [
        GatewaySharedModule,
        RouterModule.forChild(ENTITY_STATES),
        NgSelectModule,
        FormsModule,
        ReactiveFormsModule,
    ],
    exports: [
        ToEndpointComponent
    ],
    declarations: [
        ToEndpointComponent,
        ToEndpointDetailComponent,
        ToEndpointDialogComponent,
        ToEndpointDeleteDialogComponent,
        ToEndpointPopupComponent,
        ToEndpointDeletePopupComponent,
    ],
    entryComponents: [
        ToEndpointComponent,
        ToEndpointDialogComponent,
        ToEndpointPopupComponent,
        ToEndpointDeleteDialogComponent,
        ToEndpointDeletePopupComponent,
    ],
    providers: [
        Components,
        ToEndpointService,
        ToEndpointPopupService,
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayToEndpointModule {}
