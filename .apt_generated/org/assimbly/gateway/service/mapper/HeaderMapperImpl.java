package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.Header;
import org.assimbly.gateway.service.dto.HeaderDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-24T13:50:52+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class HeaderMapperImpl implements HeaderMapper {

    @Override
    public HeaderDTO toDto(Header entity) {
        if ( entity == null ) {
            return null;
        }

        HeaderDTO headerDTO = new HeaderDTO();

        headerDTO.setId( entity.getId() );
        headerDTO.setName( entity.getName() );

        return headerDTO;
    }

    @Override
    public List<Header> toEntity(List<HeaderDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Header> list = new ArrayList<Header>( dtoList.size() );
        for ( HeaderDTO headerDTO : dtoList ) {
            list.add( toEntity( headerDTO ) );
        }

        return list;
    }

    @Override
    public List<HeaderDTO> toDto(List<Header> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HeaderDTO> list = new ArrayList<HeaderDTO>( entityList.size() );
        for ( Header header : entityList ) {
            list.add( toDto( header ) );
        }

        return list;
    }

    @Override
    public Header toEntity(HeaderDTO headerDTO) {
        if ( headerDTO == null ) {
            return null;
        }

        Header header = new Header();

        header.setId( headerDTO.getId() );
        header.setName( headerDTO.getName() );

        return header;
    }
}
