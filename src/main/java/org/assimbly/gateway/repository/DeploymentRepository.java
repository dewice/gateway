package org.assimbly.gateway.repository;

//import java.util.Optional;
//
//import javax.persistence.OrderBy;

import org.assimbly.gateway.domain.Deployment;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Deployment entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DeploymentRepository extends JpaRepository<Deployment, Long> {

}
