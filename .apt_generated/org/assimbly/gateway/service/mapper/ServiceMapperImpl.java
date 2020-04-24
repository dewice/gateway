package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.Service;
import org.assimbly.gateway.service.dto.ServiceDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-24T13:50:52+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class ServiceMapperImpl implements ServiceMapper {

    @Override
    public ServiceDTO toDto(Service entity) {
        if ( entity == null ) {
            return null;
        }

        ServiceDTO serviceDTO = new ServiceDTO();

        serviceDTO.setId( entity.getId() );
        serviceDTO.setName( entity.getName() );
        serviceDTO.setType( entity.getType() );

        return serviceDTO;
    }

    @Override
    public List<Service> toEntity(List<ServiceDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Service> list = new ArrayList<Service>( dtoList.size() );
        for ( ServiceDTO serviceDTO : dtoList ) {
            list.add( toEntity( serviceDTO ) );
        }

        return list;
    }

    @Override
    public List<ServiceDTO> toDto(List<Service> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ServiceDTO> list = new ArrayList<ServiceDTO>( entityList.size() );
        for ( Service service : entityList ) {
            list.add( toDto( service ) );
        }

        return list;
    }

    @Override
    public Service toEntity(ServiceDTO serviceDTO) {
        if ( serviceDTO == null ) {
            return null;
        }

        Service service = new Service();

        service.setId( serviceDTO.getId() );
        service.setName( serviceDTO.getName() );
        service.setType( serviceDTO.getType() );

        return service;
    }
}
