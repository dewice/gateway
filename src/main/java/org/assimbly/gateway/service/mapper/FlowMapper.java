package org.assimbly.gateway.service.mapper;

import org.assimbly.gateway.domain.*;
import org.assimbly.gateway.service.dto.FlowDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Flow} and its DTO {@link FlowDTO}.
 */
@Mapper(componentModel = "spring", uses = {FromEndpointMapper.class, ErrorEndpointMapper.class, GatewayMapper.class})
public interface FlowMapper extends EntityMapper<FlowDTO, Flow> {

    @Mapping(source = "fromEndpoint.id", target = "fromEndpointId")
    @Mapping(source = "errorEndpoint.id", target = "errorEndpointId")
    @Mapping(source = "gateway.id", target = "gatewayId")
    FlowDTO toDto(Flow flow);

    @Mapping(source = "fromEndpointId", target = "fromEndpoint")
    @Mapping(source = "errorEndpointId", target = "errorEndpoint")
    @Mapping(target = "toEndpoints", ignore = true)
    @Mapping(target = "removeToEndpoint", ignore = true)
    @Mapping(source = "gatewayId", target = "gateway")
    Flow toEntity(FlowDTO flowDTO);

    default Flow fromId(Long id) {
        if (id == null) {
            return null;
        }
        Flow flow = new Flow();
        flow.setId(id);
        return flow;
    }
}
