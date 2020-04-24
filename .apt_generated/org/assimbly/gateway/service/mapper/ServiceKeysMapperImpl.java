package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.Service;
import org.assimbly.gateway.domain.ServiceKeys;
import org.assimbly.gateway.service.dto.ServiceKeysDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-24T13:50:52+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ServiceKeysMapperImpl implements ServiceKeysMapper {

    @Autowired
    private ServiceMapper serviceMapper;

    @Override
    public List<ServiceKeys> toEntity(List<ServiceKeysDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ServiceKeys> list = new ArrayList<ServiceKeys>( dtoList.size() );
        for ( ServiceKeysDTO serviceKeysDTO : dtoList ) {
            list.add( toEntity( serviceKeysDTO ) );
        }

        return list;
    }

    @Override
    public List<ServiceKeysDTO> toDto(List<ServiceKeys> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ServiceKeysDTO> list = new ArrayList<ServiceKeysDTO>( entityList.size() );
        for ( ServiceKeys serviceKeys : entityList ) {
            list.add( toDto( serviceKeys ) );
        }

        return list;
    }

    @Override
    public ServiceKeysDTO toDto(ServiceKeys serviceKeys) {
        if ( serviceKeys == null ) {
            return null;
        }

        ServiceKeysDTO serviceKeysDTO = new ServiceKeysDTO();

        serviceKeysDTO.setServiceId( serviceKeysServiceId( serviceKeys ) );
        serviceKeysDTO.setId( serviceKeys.getId() );
        serviceKeysDTO.setKey( serviceKeys.getKey() );
        serviceKeysDTO.setValue( serviceKeys.getValue() );
        serviceKeysDTO.setType( serviceKeys.getType() );

        return serviceKeysDTO;
    }

    @Override
    public ServiceKeys toEntity(ServiceKeysDTO serviceKeysDTO) {
        if ( serviceKeysDTO == null ) {
            return null;
        }

        ServiceKeys serviceKeys = new ServiceKeys();

        serviceKeys.setService( serviceMapper.fromId( serviceKeysDTO.getServiceId() ) );
        serviceKeys.setId( serviceKeysDTO.getId() );
        serviceKeys.setKey( serviceKeysDTO.getKey() );
        serviceKeys.setValue( serviceKeysDTO.getValue() );
        serviceKeys.setType( serviceKeysDTO.getType() );

        return serviceKeys;
    }

    private Long serviceKeysServiceId(ServiceKeys serviceKeys) {
        if ( serviceKeys == null ) {
            return null;
        }
        Service service = serviceKeys.getService();
        if ( service == null ) {
            return null;
        }
        Long id = service.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
