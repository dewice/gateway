package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.ErrorEndpoint;
import org.assimbly.gateway.domain.Flow;
import org.assimbly.gateway.domain.FromEndpoint;
import org.assimbly.gateway.domain.Gateway;
import org.assimbly.gateway.service.dto.FlowDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-25T05:24:05+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class FlowMapperImpl implements FlowMapper {

    @Autowired
    private GatewayMapper gatewayMapper;
    @Autowired
    private FromEndpointMapper fromEndpointMapper;
    @Autowired
    private ErrorEndpointMapper errorEndpointMapper;

    @Override
    public List<FlowDTO> toDto(List<Flow> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<FlowDTO> list = new ArrayList<FlowDTO>( arg0.size() );
        for ( Flow flow : arg0 ) {
            list.add( toDto( flow ) );
        }

        return list;
    }

    @Override
    public List<Flow> toEntity(List<FlowDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<Flow> list = new ArrayList<Flow>( arg0.size() );
        for ( FlowDTO flowDTO : arg0 ) {
            list.add( toEntity( flowDTO ) );
        }

        return list;
    }

    @Override
    public FlowDTO toDto(Flow flow) {
        if ( flow == null ) {
            return null;
        }

        FlowDTO flowDTO = new FlowDTO();

        flowDTO.setErrorEndpointId( flowErrorEndpointId( flow ) );
        flowDTO.setGatewayId( flowGatewayId( flow ) );
        flowDTO.setFromEndpointId( flowFromEndpointId( flow ) );
        flowDTO.setId( flow.getId() );
        flowDTO.setName( flow.getName() );
        flowDTO.setAutoStart( flow.isAutoStart() );
        flowDTO.setOffLoading( flow.isOffLoading() );
        flowDTO.setMaximumRedeliveries( flow.getMaximumRedeliveries() );
        flowDTO.setRedeliveryDelay( flow.getRedeliveryDelay() );
        flowDTO.setType( flow.getType() );
        flowDTO.setLoadBalancing( flow.isLoadBalancing() );
        flowDTO.setInstances( flow.getInstances() );
        flowDTO.setLogLevel( flow.getLogLevel() );
        flowDTO.setDistributed( flow.isDistributed() );
        flowDTO.setDeployment_id( flow.getDeployment_id() );

        return flowDTO;
    }

    @Override
    public Flow toEntity(FlowDTO flowDTO) {
        if ( flowDTO == null ) {
            return null;
        }

        Flow flow = new Flow();

        flow.setErrorEndpoint( errorEndpointMapper.fromId( flowDTO.getErrorEndpointId() ) );
        flow.setFromEndpoint( fromEndpointMapper.fromId( flowDTO.getFromEndpointId() ) );
        flow.setGateway( gatewayMapper.fromId( flowDTO.getGatewayId() ) );
        flow.setId( flowDTO.getId() );
        flow.setName( flowDTO.getName() );
        flow.setAutoStart( flowDTO.isAutoStart() );
        flow.setOffLoading( flowDTO.isOffLoading() );
        flow.setMaximumRedeliveries( flowDTO.getMaximumRedeliveries() );
        flow.setRedeliveryDelay( flowDTO.getRedeliveryDelay() );
        flow.setType( flowDTO.getType() );
        flow.setLoadBalancing( flowDTO.isLoadBalancing() );
        flow.setInstances( flowDTO.getInstances() );
        flow.setLogLevel( flowDTO.getLogLevel() );
        flow.setDistributed( flowDTO.isDistributed() );
        flow.setDeployment_id( flowDTO.getDeployment_id() );

        return flow;
    }

    private Long flowErrorEndpointId(Flow flow) {
        if ( flow == null ) {
            return null;
        }
        ErrorEndpoint errorEndpoint = flow.getErrorEndpoint();
        if ( errorEndpoint == null ) {
            return null;
        }
        Long id = errorEndpoint.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long flowGatewayId(Flow flow) {
        if ( flow == null ) {
            return null;
        }
        Gateway gateway = flow.getGateway();
        if ( gateway == null ) {
            return null;
        }
        Long id = gateway.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long flowFromEndpointId(Flow flow) {
        if ( flow == null ) {
            return null;
        }
        FromEndpoint fromEndpoint = flow.getFromEndpoint();
        if ( fromEndpoint == null ) {
            return null;
        }
        Long id = fromEndpoint.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
