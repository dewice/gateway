package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.ErrorEndpoint;
import org.assimbly.gateway.domain.Header;
import org.assimbly.gateway.domain.Service;
import org.assimbly.gateway.service.dto.ErrorEndpointDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-24T13:50:52+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ErrorEndpointMapperImpl implements ErrorEndpointMapper {

    @Autowired
    private ServiceMapper serviceMapper;
    @Autowired
    private HeaderMapper headerMapper;

    @Override
    public List<ErrorEndpoint> toEntity(List<ErrorEndpointDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ErrorEndpoint> list = new ArrayList<ErrorEndpoint>( dtoList.size() );
        for ( ErrorEndpointDTO errorEndpointDTO : dtoList ) {
            list.add( toEntity( errorEndpointDTO ) );
        }

        return list;
    }

    @Override
    public List<ErrorEndpointDTO> toDto(List<ErrorEndpoint> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ErrorEndpointDTO> list = new ArrayList<ErrorEndpointDTO>( entityList.size() );
        for ( ErrorEndpoint errorEndpoint : entityList ) {
            list.add( toDto( errorEndpoint ) );
        }

        return list;
    }

    @Override
    public ErrorEndpointDTO toDto(ErrorEndpoint errorEndpoint) {
        if ( errorEndpoint == null ) {
            return null;
        }

        ErrorEndpointDTO errorEndpointDTO = new ErrorEndpointDTO();

        errorEndpointDTO.setServiceId( errorEndpointServiceId( errorEndpoint ) );
        errorEndpointDTO.setHeaderId( errorEndpointHeaderId( errorEndpoint ) );
        errorEndpointDTO.setId( errorEndpoint.getId() );
        errorEndpointDTO.setType( errorEndpoint.getType() );
        errorEndpointDTO.setUri( errorEndpoint.getUri() );
        errorEndpointDTO.setOptions( errorEndpoint.getOptions() );

        return errorEndpointDTO;
    }

    @Override
    public ErrorEndpoint toEntity(ErrorEndpointDTO errorEndpointDTO) {
        if ( errorEndpointDTO == null ) {
            return null;
        }

        ErrorEndpoint errorEndpoint = new ErrorEndpoint();

        errorEndpoint.setHeader( headerMapper.fromId( errorEndpointDTO.getHeaderId() ) );
        errorEndpoint.setService( serviceMapper.fromId( errorEndpointDTO.getServiceId() ) );
        errorEndpoint.setId( errorEndpointDTO.getId() );
        errorEndpoint.setType( errorEndpointDTO.getType() );
        errorEndpoint.setUri( errorEndpointDTO.getUri() );
        errorEndpoint.setOptions( errorEndpointDTO.getOptions() );

        return errorEndpoint;
    }

    private Long errorEndpointServiceId(ErrorEndpoint errorEndpoint) {
        if ( errorEndpoint == null ) {
            return null;
        }
        Service service = errorEndpoint.getService();
        if ( service == null ) {
            return null;
        }
        Long id = service.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long errorEndpointHeaderId(ErrorEndpoint errorEndpoint) {
        if ( errorEndpoint == null ) {
            return null;
        }
        Header header = errorEndpoint.getHeader();
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
