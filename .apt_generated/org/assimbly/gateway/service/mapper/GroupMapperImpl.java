package org.assimbly.gateway.service.mapper;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.assimbly.gateway.domain.Group;
import org.assimbly.gateway.domain.User;
import org.assimbly.gateway.service.dto.GroupDTO;
import org.assimbly.gateway.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-04-30T17:00:21+0200",
    comments = "version: 1.3.1.Final, compiler: Eclipse JDT (IDE) 3.20.0.v20191203-2131, environment: Java 11.0.6 (Oracle Corporation)"
)
@Component
public class GroupMapperImpl implements GroupMapper {

    @Autowired
    private UserMapper userMapper;

    @Override
    public GroupDTO toDto(Group entity) {
        if ( entity == null ) {
            return null;
        }

        GroupDTO groupDTO = new GroupDTO();

        groupDTO.setId( entity.getId() );
        groupDTO.setName( entity.getName() );
        groupDTO.setUsers( userSetToUserDTOSet( entity.getUsers() ) );

        return groupDTO;
    }

    @Override
    public List<Group> toEntity(List<GroupDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Group> list = new ArrayList<Group>( dtoList.size() );
        for ( GroupDTO groupDTO : dtoList ) {
            list.add( toEntity( groupDTO ) );
        }

        return list;
    }

    @Override
    public List<GroupDTO> toDto(List<Group> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<GroupDTO> list = new ArrayList<GroupDTO>( entityList.size() );
        for ( Group group : entityList ) {
            list.add( toDto( group ) );
        }

        return list;
    }

    @Override
    public Group toEntity(GroupDTO groupDTO) {
        if ( groupDTO == null ) {
            return null;
        }

        Group group = new Group();

        group.setId( groupDTO.getId() );
        group.setName( groupDTO.getName() );
        group.setUsers( userDTOSetToUserSet( groupDTO.getUsers() ) );

        return group;
    }

    protected Set<UserDTO> userSetToUserDTOSet(Set<User> set) {
        if ( set == null ) {
            return null;
        }

        Set<UserDTO> set1 = new HashSet<UserDTO>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( User user : set ) {
            set1.add( userMapper.userToUserDTO( user ) );
        }

        return set1;
    }

    protected Set<User> userDTOSetToUserSet(Set<UserDTO> set) {
        if ( set == null ) {
            return null;
        }

        Set<User> set1 = new HashSet<User>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( UserDTO userDTO : set ) {
            set1.add( userMapper.userDTOToUser( userDTO ) );
        }

        return set1;
    }
}
