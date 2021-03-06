import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpErrorResponse, HttpResponse } from '@angular/common/http';
import { Subscription } from 'rxjs';
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';

import { IEnvironmentVariables } from 'app/shared/model/environment-variables.model';
import { AccountService } from 'app/core';
import { EnvironmentVariablesService } from './environment-variables.service';

@Component({
    selector: 'jhi-environment-variables',
    templateUrl: './environment-variables.component.html'
})
export class EnvironmentVariablesComponent implements OnInit, OnDestroy {
    environmentVariables: IEnvironmentVariables[];
    currentAccount: any;
    eventSubscriber: Subscription;

    //sorting
    predicate: any;
    reverse: any;
    page: any;

    constructor(
        protected environmentVariablesService: EnvironmentVariablesService,
        protected jhiAlertService: JhiAlertService,
        protected eventManager: JhiEventManager,
        protected accountService: AccountService
    ) {
        this.page = 0;
        this.predicate = 'key';
        this.reverse = true;
    }

    loadAll() {
        this.environmentVariablesService
            .query({
                page: this.page,
                sort: this.sort()
            })
            .subscribe(
                (res: HttpResponse<IEnvironmentVariables[]>) => {
                    this.environmentVariables = res.body;
                },
                (res: HttpErrorResponse) => this.onError(res.message)
            );
    }

    ngOnInit() {
        this.accountService.identity().then(account => {
            this.currentAccount = account;
        });
        this.loadAll();
        this.registerChangeInEnvironmentVariables();
    }

    ngOnDestroy() {
        this.eventManager.destroy(this.eventSubscriber);
    }

    trackId(index: number, item: IEnvironmentVariables) {
        return item.id;
    }

    registerChangeInEnvironmentVariables() {
        this.eventSubscriber = this.eventManager.subscribe('environmentVariablesListModification', response => this.loadAll());
    }

    protected onError(errorMessage: string) {
        this.jhiAlertService.error(errorMessage, null, null);
    }

    sort() {
        const result = [this.predicate + ',' + (this.reverse ? 'asc' : 'desc')];
        if (this.predicate !== 'key') {
            result.push('key');
        }
        return result;
    }

    reset() {
        this.page = 0;
        this.environmentVariables = [];
        this.loadAll();
    }
}
