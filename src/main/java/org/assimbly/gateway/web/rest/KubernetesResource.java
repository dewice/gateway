package org.assimbly.gateway.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.assimbly.gateway.domain.Deployment;
import org.assimbly.gateway.repository.FlowRepository;
import org.assimbly.gateway.service.KubernetesService;

@RestController
@RequestMapping("/api")
public class KubernetesResource {
	
	@Autowired
	private KubernetesService ks;
	
	@Autowired
	private FlowRepository fs;
	
	@GetMapping(path = "/kubernetes/startDeployment/{id}/{replicas}", produces = "application/json")
	public void deployDeployment(@PathVariable String id, @PathVariable Integer replicas) {
		Deployment deployment = ks.createDeployment(id, replicas);
		
		ks.deployDeployment(deployment, id);
		fs.findById(Long.parseLong(id)).ifPresent(x -> {x.setDeployment(deployment); fs.save(x); });
	}
	
	@DeleteMapping(path = "/kubernetes/deleteDeployment/{id}", produces = "application/json")
	public String deleteDeployment(@PathVariable String id) {
		
		return ks.deleteDeployment(id);
	}
}
