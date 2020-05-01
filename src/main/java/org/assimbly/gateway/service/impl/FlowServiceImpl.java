package org.assimbly.gateway.service.impl;

import org.assimbly.gateway.service.FlowService;
import org.assimbly.gateway.service.KubernetesService;
import org.assimbly.gateway.domain.Deployment;
import org.assimbly.gateway.domain.Flow;
import org.assimbly.gateway.repository.FlowRepository;
import org.assimbly.gateway.service.dto.FlowDTO;
import org.assimbly.gateway.service.mapper.FlowMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Flow.
 */
@Service
@Transactional
public class FlowServiceImpl implements FlowService {

    private final Logger log = LoggerFactory.getLogger(FlowServiceImpl.class);

    private final FlowRepository flowRepository;
    
    private final KubernetesService ks;

    private final FlowMapper flowMapper;

    public FlowServiceImpl(FlowRepository flowRepository, FlowMapper flowMapper, KubernetesService kubeservice) {
        this.flowRepository = flowRepository;
        this.flowMapper = flowMapper;
        this.ks = kubeservice;
    }

    /**
     * Save a flow.
     *
     * @param flowDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public FlowDTO save(FlowDTO flowDTO) {
        log.debug("Request to save Flow : {}", flowDTO);

        Flow flow = flowMapper.toEntity(flowDTO);
        flow = flowRepository.save(flow);
        
        if (flow.isDistributed() == true)
        {
        	Deployment deployment = ks.createDeployment(Long.toString(flow.getId()), flow.getInstances());
        	ks.deployDeployment(deployment, Long.toString(flow.getId()));
        	log.debug("Deployment {} for flow {} is created", deployment, flow);
        	
//        	flow.setDeployment(deployment);
//        	flow = flowRepository.save(flow);
        }
        
        return flowMapper.toDto(flow);
    }

    /**
     * Get all the flows.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<FlowDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Flows");
        return flowRepository.findAll(pageable)
            .map(flowMapper::toDto);
    }

    
    /**
     * Get all the flows.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<FlowDTO> findAllByGatewayId(Pageable pageable, Long gatewayid) {
        log.debug("Request to get all Flows");
        return flowRepository.findAllByGatewayId(pageable, gatewayid).map(flowMapper::toDto);
    }    
    

    /**
     * Get one flow by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<FlowDTO> findOne(Long id) {
        log.debug("Request to get Flow : {}", id);
        return flowRepository.findById(id)
            .map(flowMapper::toDto);
    }

    /**
     * Delete the flow by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Flow : {}", id);
        flowRepository.findById(id).ifPresent(x -> {
        	if (x.isDistributed() == true) {
        		log.debug(ks.deleteDeployment(Long.toString(id)));
        	}
        });;
        flowRepository.deleteById(id);
    }
    

}
