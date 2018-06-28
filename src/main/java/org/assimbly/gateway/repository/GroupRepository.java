package org.assimbly.gateway.repository;

import org.assimbly.gateway.domain.Group;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Spring Data JPA repository for the Group entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {
    
	//@Query("select distinct group from Group group left join fetch group.users")
    //List<Group> findAllWithEagerRelationships();

    //@Query("select group from Group group left join fetch group.users where group.id =:id")
    //Group findOneWithEagerRelationships(@Param("id") Long id);

}