package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.FromEndpoint;
import org.assimbly.gateway.domain.Header;
import org.assimbly.gateway.domain.Service;
import org.assimbly.gateway.service.dto.FromEndpointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-24T13:50:52+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class FromEndpointMapperImpl implements FromEndpointMapper {

    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private HeaderMapper headerMapper;

    @Override
    public List<FromEndpoint> toEntity(List<FromEndpointDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<FromEndpoint> list = new ArrayList<FromEndpoint>( dtoList.size() );
        for ( FromEndpointDTO fromEndpointDTO : dtoList ) {
            list.add( toEntity( fromEndpointDTO ) );
        }

        return list;
    }

    @Override
    public List<FromEndpointDTO> toDto(List<FromEndpoint> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<FromEndpointDTO> list = new ArrayList<FromEndpointDTO>( entityList.size() );
        for ( FromEndpoint fromEndpoint : entityList ) {
            list.add( toDto( fromEndpoint ) );
        }

        return list;
    }

    @Override
    public FromEndpointDTO toDto(FromEndpoint fromEndpoint) {
        if ( fromEndpoint == null ) {
            return null;
        }

        FromEndpointDTO fromEndpointDTO = new FromEndpointDTO();

        fromEndpointDTO.setServiceId( fromEndpointServiceId( fromEndpoint ) );
        fromEndpointDTO.setHeaderId( fromEndpointHeaderId( fromEndpoint ) );
        fromEndpointDTO.setId( fromEndpoint.getId() );
        fromEndpointDTO.setType( fromEndpoint.getType() );
        fromEndpointDTO.setUri( fromEndpoint.getUri() );
        fromEndpointDTO.setOptions( fromEndpoint.getOptions() );

        return fromEndpointDTO;
    }

    @Override
    public FromEndpoint toEntity(FromEndpointDTO fromEndpointDTO) {
        if ( fromEndpointDTO == null ) {
            return null;
        }

        FromEndpoint fromEndpoint = new FromEndpoint();

        fromEndpoint.setHeader( headerMapper.fromId( fromEndpointDTO.getHeaderId() ) );
        fromEndpoint.setService( serviceMapper.fromId( fromEndpointDTO.getServiceId() ) );
        fromEndpoint.setId( fromEndpointDTO.getId() );
        fromEndpoint.setType( fromEndpointDTO.getType() );
        fromEndpoint.setUri( fromEndpointDTO.getUri() );
        fromEndpoint.setOptions( fromEndpointDTO.getOptions() );

        return fromEndpoint;
    }

    private Long fromEndpointServiceId(FromEndpoint fromEndpoint) {
        if ( fromEndpoint == null ) {
            return null;
        }
        Service service = fromEndpoint.getService();
        if ( service == null ) {
            return null;
        }
        Long id = service.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long fromEndpointHeaderId(FromEndpoint fromEndpoint) {
        if ( fromEndpoint == null ) {
            return null;
        }
        Header header = fromEndpoint.getHeader();
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
