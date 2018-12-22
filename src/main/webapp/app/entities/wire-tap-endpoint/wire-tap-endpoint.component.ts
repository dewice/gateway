import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IWireTapEndpoint } from 'app/shared/model/wire-tap-endpoint.model';
import { AccountService } from 'app/core';
import { WireTapEndpointService } from './wire-tap-endpoint.service';

@Component({
    selector: 'jhi-wire-tap-endpoint',
    templateUrl: './wire-tap-endpoint.component.html'
})
export class WireTapEndpointComponent implements OnInit, OnDestroy {
    wireTapEndpoints: IWireTapEndpoint[];
    currentAccount: any;
    eventSubscriber: Subscription;

    constructor(
        protected wireTapEndpointService: WireTapEndpointService,
        protected jhiAlertService: JhiAlertService,
        protected eventManager: JhiEventManager,
        protected accountService: AccountService
    ) {}

    loadAll() {
        this.wireTapEndpointService.query().subscribe(
            (res: HttpResponse<IWireTapEndpoint[]>) => {
                this.wireTapEndpoints = res.body;
            },
            (res: HttpErrorResponse) => this.onError(res.message)
        );
    }

    ngOnInit() {
        this.loadAll();
        this.accountService.identity().then(account => {
            this.currentAccount = account;
        });
        this.registerChangeInWireTapEndpoints();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IWireTapEndpoint) {
        return item.id;
    }

    registerChangeInWireTapEndpoints() {
        this.eventSubscriber = this.eventManager.subscribe('wireTapEndpointListModification', response => this.loadAll());
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }
}
