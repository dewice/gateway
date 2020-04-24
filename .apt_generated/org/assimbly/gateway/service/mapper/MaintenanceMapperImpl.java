package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.Maintenance;
import org.assimbly.gateway.service.dto.MaintenanceDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-24T13:50:52+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class MaintenanceMapperImpl implements MaintenanceMapper {

    @Override
    public List<Maintenance> toEntity(List<MaintenanceDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Maintenance> list = new ArrayList<Maintenance>( dtoList.size() );
        for ( MaintenanceDTO maintenanceDTO : dtoList ) {
            list.add( toEntity( maintenanceDTO ) );
        }

        return list;
    }

    @Override
    public List<MaintenanceDTO> toDto(List<Maintenance> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MaintenanceDTO> list = new ArrayList<MaintenanceDTO>( entityList.size() );
        for ( Maintenance maintenance : entityList ) {
            list.add( toDto( maintenance ) );
        }

        return list;
    }

    @Override
    public MaintenanceDTO toDto(Maintenance maintenance) {
        if ( maintenance == null ) {
            return null;
        }

        MaintenanceDTO maintenanceDTO = new MaintenanceDTO();

        maintenanceDTO.setId( maintenance.getId() );
        maintenanceDTO.setStartTime( maintenance.getStartTime() );
        maintenanceDTO.setEndTime( maintenance.getEndTime() );
        maintenanceDTO.setDuration( maintenance.getDuration() );
        maintenanceDTO.setFrequency( maintenance.getFrequency() );

        return maintenanceDTO;
    }

    @Override
    public Maintenance toEntity(MaintenanceDTO maintenanceDTO) {
        if ( maintenanceDTO == null ) {
            return null;
        }

        Maintenance maintenance = new Maintenance();

        maintenance.setId( maintenanceDTO.getId() );
        maintenance.setStartTime( maintenanceDTO.getStartTime() );
        maintenance.setEndTime( maintenanceDTO.getEndTime() );
        maintenance.setDuration( maintenanceDTO.getDuration() );
        maintenance.setFrequency( maintenanceDTO.getFrequency() );

        return maintenance;
    }
}
