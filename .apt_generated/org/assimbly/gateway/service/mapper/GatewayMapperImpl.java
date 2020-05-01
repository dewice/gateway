package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.Gateway;
import org.assimbly.gateway.domain.WireTapEndpoint;
import org.assimbly.gateway.service.dto.GatewayDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-30T17:00:20+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class GatewayMapperImpl implements GatewayMapper {

    @Autowired
    private WireTapEndpointMapper wireTapEndpointMapper;

    @Override
    public List<Gateway> toEntity(List<GatewayDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Gateway> list = new ArrayList<Gateway>( dtoList.size() );
        for ( GatewayDTO gatewayDTO : dtoList ) {
            list.add( toEntity( gatewayDTO ) );
        }

        return list;
    }

    @Override
    public List<GatewayDTO> toDto(List<Gateway> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<GatewayDTO> list = new ArrayList<GatewayDTO>( entityList.size() );
        for ( Gateway gateway : entityList ) {
            list.add( toDto( gateway ) );
        }

        return list;
    }

    @Override
    public GatewayDTO toDto(Gateway gateway) {
        if ( gateway == null ) {
            return null;
        }

        GatewayDTO gatewayDTO = new GatewayDTO();

        gatewayDTO.setWiretapEndpointId( gatewayWiretapEndpointId( gateway ) );
        gatewayDTO.setId( gateway.getId() );
        gatewayDTO.setName( gateway.getName() );
        gatewayDTO.setType( gateway.getType() );
        gatewayDTO.setEnvironmentName( gateway.getEnvironmentName() );
        gatewayDTO.setStage( gateway.getStage() );
        gatewayDTO.setConnectorType( gateway.getConnectorType() );
        gatewayDTO.setDefaultFromEndpointType( gateway.getDefaultFromEndpointType() );
        gatewayDTO.setDefaultToEndpointType( gateway.getDefaultToEndpointType() );
        gatewayDTO.setDefaultErrorEndpointType( gateway.getDefaultErrorEndpointType() );

        return gatewayDTO;
    }

    @Override
    public Gateway toEntity(GatewayDTO gatewayDTO) {
        if ( gatewayDTO == null ) {
            return null;
        }

        Gateway gateway = new Gateway();

        gateway.setWiretapEndpoint( wireTapEndpointMapper.fromId( gatewayDTO.getWiretapEndpointId() ) );
        gateway.setId( gatewayDTO.getId() );
        gateway.setName( gatewayDTO.getName() );
        gateway.setType( gatewayDTO.getType() );
        gateway.setEnvironmentName( gatewayDTO.getEnvironmentName() );
        gateway.setStage( gatewayDTO.getStage() );
        gateway.setConnectorType( gatewayDTO.getConnectorType() );
        gateway.setDefaultFromEndpointType( gatewayDTO.getDefaultFromEndpointType() );
        gateway.setDefaultToEndpointType( gatewayDTO.getDefaultToEndpointType() );
        gateway.setDefaultErrorEndpointType( gatewayDTO.getDefaultErrorEndpointType() );

        return gateway;
    }

    private Long gatewayWiretapEndpointId(Gateway gateway) {
        if ( gateway == null ) {
            return null;
        }
        WireTapEndpoint wiretapEndpoint = gateway.getWiretapEndpoint();
        if ( wiretapEndpoint == null ) {
            return null;
        }
        Long id = wiretapEndpoint.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
