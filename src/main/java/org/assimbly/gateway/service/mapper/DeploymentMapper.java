package org.assimbly.gateway.service.mapper;

import org.assimbly.gateway.domain.Deployment;
import org.assimbly.gateway.service.dto.DeploymentDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * Mapper for the entity Deployment and its DTO DeploymentDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DeploymentMapper extends EntityMapper<DeploymentDTO, Deployment> {


//    @Mapping(source = "deployment.id", target = "id")
//    @Mapping(source = "deployment.name", target = "name")
//    DeploymentDTO toDto(Deployment deployment);

    @Mapping(target = "args", ignore = true)
    @Mapping(target = "metadata", ignore = true)
    @Mapping(target = "metaData", ignore = true)
    @Mapping(target = "port", ignore = true)
    @Mapping(target = "url", ignore = true)
    @Mapping(target = "spec", ignore = true)
    @Mapping(target = "nestedSpec", ignore = true)
    @Mapping(target = "container", ignore = true)
    Deployment toEntity(DeploymentDTO deploymentDTO);

    default Deployment fromId(Long id) {
        if (id == null) {
            return null;
        }
        Deployment deployment = new Deployment();
        deployment.setId(id);
        return deployment;
    }
}