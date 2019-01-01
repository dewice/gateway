import { IToEndpoint } from 'app/shared/model//to-endpoint.model';

export interface IFlow {
    id?: number;
    name?: string;
    autoStart?: boolean;
    offLoading?: boolean;
    gatewayId?: number;
    fromEndpointId?: number;
    errorEndpointId?: number;
    toEndpoints?: IToEndpoint[];
}

export class Flow implements IFlow {
    constructor(
        public id?: number,
        public name?: string,
        public autoStart?: boolean,
        public offLoading?: boolean,
        public gatewayId?: number,
        public fromEndpointId?: number,
        public errorEndpointId?: number,
        public toEndpoints?: IToEndpoint[]
    ) {
        this.autoStart = this.autoStart || false;
        this.offLoading = this.offLoading || false;
    }
}