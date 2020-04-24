package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.EnvironmentVariables;
import org.assimbly.gateway.domain.Gateway;
import org.assimbly.gateway.service.dto.EnvironmentVariablesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-24T13:50:52+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class EnvironmentVariablesMapperImpl implements EnvironmentVariablesMapper {

    @Autowired
    private GatewayMapper gatewayMapper;

    @Override
    public List<EnvironmentVariables> toEntity(List<EnvironmentVariablesDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<EnvironmentVariables> list = new ArrayList<EnvironmentVariables>( dtoList.size() );
        for ( EnvironmentVariablesDTO environmentVariablesDTO : dtoList ) {
            list.add( toEntity( environmentVariablesDTO ) );
        }

        return list;
    }

    @Override
    public List<EnvironmentVariablesDTO> toDto(List<EnvironmentVariables> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<EnvironmentVariablesDTO> list = new ArrayList<EnvironmentVariablesDTO>( entityList.size() );
        for ( EnvironmentVariables environmentVariables : entityList ) {
            list.add( toDto( environmentVariables ) );
        }

        return list;
    }

    @Override
    public EnvironmentVariablesDTO toDto(EnvironmentVariables environmentVariables) {
        if ( environmentVariables == null ) {
            return null;
        }

        EnvironmentVariablesDTO environmentVariablesDTO = new EnvironmentVariablesDTO();

        environmentVariablesDTO.setGatewayId( environmentVariablesGatewayId( environmentVariables ) );
        environmentVariablesDTO.setId( environmentVariables.getId() );
        environmentVariablesDTO.setKey( environmentVariables.getKey() );
        environmentVariablesDTO.setValue( environmentVariables.getValue() );

        return environmentVariablesDTO;
    }

    @Override
    public EnvironmentVariables toEntity(EnvironmentVariablesDTO environmentVariablesDTO) {
        if ( environmentVariablesDTO == null ) {
            return null;
        }

        EnvironmentVariables environmentVariables = new EnvironmentVariables();

        environmentVariables.setGateway( gatewayMapper.fromId( environmentVariablesDTO.getGatewayId() ) );
        environmentVariables.setId( environmentVariablesDTO.getId() );
        environmentVariables.setKey( environmentVariablesDTO.getKey() );
        environmentVariables.setValue( environmentVariablesDTO.getValue() );

        return environmentVariables;
    }

    private Long environmentVariablesGatewayId(EnvironmentVariables environmentVariables) {
        if ( environmentVariables == null ) {
            return null;
        }
        Gateway gateway = environmentVariables.getGateway();
        if ( gateway == null ) {
            return null;
        }
        Long id = gateway.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
