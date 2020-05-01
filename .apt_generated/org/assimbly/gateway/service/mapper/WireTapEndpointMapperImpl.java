package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.Header;
import org.assimbly.gateway.domain.Service;
import org.assimbly.gateway.domain.WireTapEndpoint;
import org.assimbly.gateway.service.dto.WireTapEndpointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-30T17:00:21+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class WireTapEndpointMapperImpl implements WireTapEndpointMapper {

    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private HeaderMapper headerMapper;

    @Override
    public List<WireTapEndpoint> toEntity(List<WireTapEndpointDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<WireTapEndpoint> list = new ArrayList<WireTapEndpoint>( dtoList.size() );
        for ( WireTapEndpointDTO wireTapEndpointDTO : dtoList ) {
            list.add( toEntity( wireTapEndpointDTO ) );
        }

        return list;
    }

    @Override
    public List<WireTapEndpointDTO> toDto(List<WireTapEndpoint> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<WireTapEndpointDTO> list = new ArrayList<WireTapEndpointDTO>( entityList.size() );
        for ( WireTapEndpoint wireTapEndpoint : entityList ) {
            list.add( toDto( wireTapEndpoint ) );
        }

        return list;
    }

    @Override
    public WireTapEndpointDTO toDto(WireTapEndpoint wireTapEndpoint) {
        if ( wireTapEndpoint == null ) {
            return null;
        }

        WireTapEndpointDTO wireTapEndpointDTO = new WireTapEndpointDTO();

        wireTapEndpointDTO.setServiceId( wireTapEndpointServiceId( wireTapEndpoint ) );
        wireTapEndpointDTO.setHeaderId( wireTapEndpointHeaderId( wireTapEndpoint ) );
        wireTapEndpointDTO.setId( wireTapEndpoint.getId() );
        wireTapEndpointDTO.setType( wireTapEndpoint.getType() );
        wireTapEndpointDTO.setUri( wireTapEndpoint.getUri() );
        wireTapEndpointDTO.setOptions( wireTapEndpoint.getOptions() );

        return wireTapEndpointDTO;
    }

    @Override
    public WireTapEndpoint toEntity(WireTapEndpointDTO wireTapEndpointDTO) {
        if ( wireTapEndpointDTO == null ) {
            return null;
        }

        WireTapEndpoint wireTapEndpoint = new WireTapEndpoint();

        wireTapEndpoint.setHeader( headerMapper.fromId( wireTapEndpointDTO.getHeaderId() ) );
        wireTapEndpoint.setService( serviceMapper.fromId( wireTapEndpointDTO.getServiceId() ) );
        wireTapEndpoint.setId( wireTapEndpointDTO.getId() );
        wireTapEndpoint.setType( wireTapEndpointDTO.getType() );
        wireTapEndpoint.setUri( wireTapEndpointDTO.getUri() );
        wireTapEndpoint.setOptions( wireTapEndpointDTO.getOptions() );

        return wireTapEndpoint;
    }

    private Long wireTapEndpointServiceId(WireTapEndpoint wireTapEndpoint) {
        if ( wireTapEndpoint == null ) {
            return null;
        }
        Service service = wireTapEndpoint.getService();
        if ( service == null ) {
            return null;
        }
        Long id = service.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long wireTapEndpointHeaderId(WireTapEndpoint wireTapEndpoint) {
        if ( wireTapEndpoint == null ) {
            return null;
        }
        Header header = wireTapEndpoint.getHeader();
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
