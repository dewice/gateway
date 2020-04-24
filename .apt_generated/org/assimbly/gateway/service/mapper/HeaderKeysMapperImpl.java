package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.Header;
import org.assimbly.gateway.domain.HeaderKeys;
import org.assimbly.gateway.service.dto.HeaderKeysDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-24T13:50:52+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class HeaderKeysMapperImpl implements HeaderKeysMapper {

    @Autowired
    private HeaderMapper headerMapper;

    @Override
    public List<HeaderKeys> toEntity(List<HeaderKeysDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<HeaderKeys> list = new ArrayList<HeaderKeys>( dtoList.size() );
        for ( HeaderKeysDTO headerKeysDTO : dtoList ) {
            list.add( toEntity( headerKeysDTO ) );
        }

        return list;
    }

    @Override
    public List<HeaderKeysDTO> toDto(List<HeaderKeys> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<HeaderKeysDTO> list = new ArrayList<HeaderKeysDTO>( entityList.size() );
        for ( HeaderKeys headerKeys : entityList ) {
            list.add( toDto( headerKeys ) );
        }

        return list;
    }

    @Override
    public HeaderKeysDTO toDto(HeaderKeys headerKeys) {
        if ( headerKeys == null ) {
            return null;
        }

        HeaderKeysDTO headerKeysDTO = new HeaderKeysDTO();

        headerKeysDTO.setHeaderId( headerKeysHeaderId( headerKeys ) );
        headerKeysDTO.setId( headerKeys.getId() );
        headerKeysDTO.setKey( headerKeys.getKey() );
        headerKeysDTO.setValue( headerKeys.getValue() );
        headerKeysDTO.setType( headerKeys.getType() );

        return headerKeysDTO;
    }

    @Override
    public HeaderKeys toEntity(HeaderKeysDTO headerKeysDTO) {
        if ( headerKeysDTO == null ) {
            return null;
        }

        HeaderKeys headerKeys = new HeaderKeys();

        headerKeys.setHeader( headerMapper.fromId( headerKeysDTO.getHeaderId() ) );
        headerKeys.setId( headerKeysDTO.getId() );
        headerKeys.setKey( headerKeysDTO.getKey() );
        headerKeys.setValue( headerKeysDTO.getValue() );
        headerKeys.setType( headerKeysDTO.getType() );

        return headerKeys;
    }

    private Long headerKeysHeaderId(HeaderKeys headerKeys) {
        if ( headerKeys == null ) {
            return null;
        }
        Header header = headerKeys.getHeader();
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
