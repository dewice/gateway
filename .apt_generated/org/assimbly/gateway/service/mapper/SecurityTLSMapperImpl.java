package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.Security;
import org.assimbly.gateway.service.dto.SecurityDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-24T13:50:51+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class SecurityTLSMapperImpl implements SecurityTLSMapper {

    @Override
    public Security toEntity(SecurityDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Security security = new Security();

        security.setId( dto.getId() );
        security.setUrl( dto.getUrl() );
        security.setCertificateName( dto.getCertificateName() );
        security.setCertificateExpiry( dto.getCertificateExpiry() );
        security.setCertificateFile( dto.getCertificateFile() );

        return security;
    }

    @Override
    public SecurityDTO toDto(Security entity) {
        if ( entity == null ) {
            return null;
        }

        SecurityDTO securityDTO = new SecurityDTO();

        securityDTO.setId( entity.getId() );
        securityDTO.setUrl( entity.getUrl() );
        securityDTO.setCertificateName( entity.getCertificateName() );
        securityDTO.setCertificateExpiry( entity.getCertificateExpiry() );
        securityDTO.setCertificateFile( entity.getCertificateFile() );

        return securityDTO;
    }

    @Override
    public List<Security> toEntity(List<SecurityDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Security> list = new ArrayList<Security>( dtoList.size() );
        for ( SecurityDTO securityDTO : dtoList ) {
            list.add( toEntity( securityDTO ) );
        }

        return list;
    }

    @Override
    public List<SecurityDTO> toDto(List<Security> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SecurityDTO> list = new ArrayList<SecurityDTO>( entityList.size() );
        for ( Security security : entityList ) {
            list.add( toDto( security ) );
        }

        return list;
    }
}
