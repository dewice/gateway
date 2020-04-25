package org.assimbly.gateway.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.assimbly.gateway.domain.Deployment;
import org.assimbly.gateway.service.KubernetesService;

@RestController
@RequestMapping("/api")
public class KubernetesResource {
	
	@Autowired
	private KubernetesService ks;
	
	@GetMapping(path = "/kubernetes/startDeployment/{id}/{replicas}", produces = "application/json")
	public String deployDeployment(@PathVariable String id, @PathVariable Integer replicas) {
		Deployment deployment = ks.createDeployment(id, replicas);

		return ks.deployDeployment(deployment);
	}
}
