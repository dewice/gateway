import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { GatewaySharedModule } from '../../app/shared';
import { TranslateLoader, TranslateModule } from '@ngx-translate/core';
import { TranslateHttpLoader } from '@ngx-translate/http-loader';
import { HttpClient, HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
/* jhipster-needle-add-admin-module-import - JHipster will add admin modules imports here */
import { NgbDatepickerConfig } from '@ng-bootstrap/ng-bootstrap';
import { NgxWebstorageModule } from 'ngx-webstorage';
import { PopoverModule } from 'ngx-bootstrap';
import { NgJhipsterModule } from 'ng-jhipster';
import { CookieModule } from 'ngx-cookie';

import { AuthExpiredInterceptor } from 'app/blocks/interceptor/auth-expired.interceptor';
import { ErrorHandlerInterceptor } from 'app/blocks/interceptor/errorhandler.interceptor';
import { NotificationInterceptor } from 'app/blocks/interceptor/notification.interceptor';
import { AuthInterceptor } from 'app/blocks/interceptor/auth.interceptor';
import * as moment from 'moment';

import {
    adminState,
    AuditsComponent,
    UserMgmtComponent,
    UserMgmtDetailComponent,
    UserMgmtUpdateComponent,
    UserMgmtDeleteDialogComponent,
    GatewayRoutesService,
    GatewayComponent,
    TrackerComponent,
    LogsComponent,
    LogViewerComponent,
    HealthModalComponent,
    HealthComponent,
    JhiConfigurationComponent,
    JhiDocsComponent,
    AuditsService,
    JhiConfigurationService,
    HealthService,
    MetricsService,
    LogsService,
    LogViewerService,
    UserResolve,
    LogViewerLineValidationDirective
} from './';

@NgModule({
    imports: [
        GatewaySharedModule,
        HttpClientModule,
        CookieModule.forRoot(),
        NgxWebstorageModule.forRoot({ prefix: 'jhi', separator: '-' }),
        NgJhipsterModule.forRoot({
            // set below to true to make alerts look like toast
            alertAsToast: false,
            alertTimeout: 5000
        }),
        RouterModule.forChild(adminState),
        TranslateModule.forRoot({
            loader: {
                provide: TranslateLoader,
                useFactory: HttpLoaderFactory,
                deps: [HttpClient]
            }
        })
        /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
    ],
    declarations: [
        AuditsComponent,
        UserMgmtComponent,
        UserMgmtDetailComponent,
        UserMgmtUpdateComponent,
        UserMgmtDeleteDialogComponent,
        LogsComponent,
        LogViewerComponent,
        JhiConfigurationComponent,
        HealthComponent,
        HealthModalComponent,
        TrackerComponent,
        GatewayComponent,
        JhiDocsComponent,
        LogViewerLineValidationDirective
    ],
    entryComponents: [UserMgmtDeleteDialogComponent, HealthModalComponent],
    providers: [
        AuditsService,
        JhiConfigurationService,
        GatewayRoutesService,
        HealthService,
        MetricsService,
        LogsService,
        LogViewerService,
        UserResolve,
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: AuthExpiredInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: ErrorHandlerInterceptor,
            multi: true
        },
        {
            provide: HTTP_INTERCEPTORS,
            useClass: NotificationInterceptor,
            multi: true
        }
    ],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class GatewayAdminModule {}
export function HttpLoaderFactory(http: HttpClient) {
    return new TranslateHttpLoader(http);
}
