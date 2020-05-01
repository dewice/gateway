package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.Broker;
import org.assimbly.gateway.service.dto.BrokerDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-30T17:00:21+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class BrokerMapperImpl implements BrokerMapper {

    @Override
    public Broker toEntity(BrokerDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Broker broker = new Broker();

        broker.setId( dto.getId() );
        broker.setName( dto.getName() );
        broker.setType( dto.getType() );
        broker.setConfigurationType( dto.getConfigurationType() );
        broker.setAutoStart( dto.isAutoStart() );

        return broker;
    }

    @Override
    public BrokerDTO toDto(Broker entity) {
        if ( entity == null ) {
            return null;
        }

        BrokerDTO brokerDTO = new BrokerDTO();

        brokerDTO.setId( entity.getId() );
        brokerDTO.setName( entity.getName() );
        brokerDTO.setType( entity.getType() );
        brokerDTO.setConfigurationType( entity.getConfigurationType() );
        brokerDTO.setAutoStart( entity.isAutoStart() );

        return brokerDTO;
    }

    @Override
    public List<Broker> toEntity(List<BrokerDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Broker> list = new ArrayList<Broker>( dtoList.size() );
        for ( BrokerDTO brokerDTO : dtoList ) {
            list.add( toEntity( brokerDTO ) );
        }

        return list;
    }

    @Override
    public List<BrokerDTO> toDto(List<Broker> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BrokerDTO> list = new ArrayList<BrokerDTO>( entityList.size() );
        for ( Broker broker : entityList ) {
            list.add( toDto( broker ) );
        }

        return list;
    }
}
