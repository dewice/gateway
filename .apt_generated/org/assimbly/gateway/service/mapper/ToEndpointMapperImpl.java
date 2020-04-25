package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.Flow;
import org.assimbly.gateway.domain.Header;
import org.assimbly.gateway.domain.Service;
import org.assimbly.gateway.domain.ToEndpoint;
import org.assimbly.gateway.service.dto.ToEndpointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-25T05:24:06+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ToEndpointMapperImpl implements ToEndpointMapper {

    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private HeaderMapper headerMapper;
    @Autowired
    private FlowMapper flowMapper;

    @Override
    public List<ToEndpointDTO> toDto(List<ToEndpoint> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<ToEndpointDTO> list = new ArrayList<ToEndpointDTO>( arg0.size() );
        for ( ToEndpoint toEndpoint : arg0 ) {
            list.add( toDto( toEndpoint ) );
        }

        return list;
    }

    @Override
    public List<ToEndpoint> toEntity(List<ToEndpointDTO> arg0) {
        if ( arg0 == null ) {
            return null;
        }

        List<ToEndpoint> list = new ArrayList<ToEndpoint>( arg0.size() );
        for ( ToEndpointDTO toEndpointDTO : arg0 ) {
            list.add( toEntity( toEndpointDTO ) );
        }

        return list;
    }

    @Override
    public ToEndpointDTO toDto(ToEndpoint toEndpoint) {
        if ( toEndpoint == null ) {
            return null;
        }

        ToEndpointDTO toEndpointDTO = new ToEndpointDTO();

        toEndpointDTO.setServiceId( toEndpointServiceId( toEndpoint ) );
        toEndpointDTO.setFlowId( toEndpointFlowId( toEndpoint ) );
        toEndpointDTO.setHeaderId( toEndpointHeaderId( toEndpoint ) );
        toEndpointDTO.setId( toEndpoint.getId() );
        toEndpointDTO.setOptions( toEndpoint.getOptions() );
        toEndpointDTO.setType( toEndpoint.getType() );
        toEndpointDTO.setUri( toEndpoint.getUri() );

        return toEndpointDTO;
    }

    @Override
    public ToEndpoint toEntity(ToEndpointDTO toEndpointDTO) {
        if ( toEndpointDTO == null ) {
            return null;
        }

        ToEndpoint toEndpoint = new ToEndpoint();

        toEndpoint.setHeader( headerMapper.fromId( toEndpointDTO.getHeaderId() ) );
        toEndpoint.setService( serviceMapper.fromId( toEndpointDTO.getServiceId() ) );
        toEndpoint.setFlow( flowMapper.fromId( toEndpointDTO.getFlowId() ) );
        toEndpoint.setId( toEndpointDTO.getId() );
        toEndpoint.setType( toEndpointDTO.getType() );
        toEndpoint.setUri( toEndpointDTO.getUri() );
        toEndpoint.setOptions( toEndpointDTO.getOptions() );

        return toEndpoint;
    }

    private Long toEndpointServiceId(ToEndpoint toEndpoint) {
        if ( toEndpoint == null ) {
            return null;
        }
        Service service = toEndpoint.getService();
        if ( service == null ) {
            return null;
        }
        Long id = service.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long toEndpointFlowId(ToEndpoint toEndpoint) {
        if ( toEndpoint == null ) {
            return null;
        }
        Flow flow = toEndpoint.getFlow();
        if ( flow == null ) {
            return null;
        }
        Long id = flow.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long toEndpointHeaderId(ToEndpoint toEndpoint) {
        if ( toEndpoint == null ) {
            return null;
        }
        Header header = toEndpoint.getHeader();
        if ( header == null ) {
            return null;
        }
        Long id = header.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
