package org.assimbly.gateway.service;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.assimbly.gateway.repository.DeploymentRepository;
import org.assimbly.gateway.repository.FlowRepository;

import java.util.Optional;

import org.assimbly.gateway.domain.Deployment;
import org.assimbly.gateway.domain.Flow;

@Service
public class KubernetesService {
	
	@Autowired
	private DeploymentRepository deploymentRepository;

	@Autowired
	private FlowRepository flowRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private HttpHeaders headers;
	
	private final Environment environment;
	private final String depName;
	private final String depUrl;
	private boolean needsSaving;
	
	public KubernetesService(Environment env) {
		this.environment = env;
		this.depName = environment.getProperty("application.cluster.deploymentName");
		this.depUrl = environment.getProperty("application.cluster.deploymentUrl");
		
		this.headers = new HttpHeaders();
		this.headers.setContentType(MediaType.APPLICATION_JSON);
		this.needsSaving = true;
	}

	// Creates a new kubernetes deployment
	public Deployment createDeployment(String id, Integer instances) {
		
		Deployment dep = new Deployment();
		
		// Save to database to auto-generate id, only for flow deployments
		if (needsSaving == true) {
			deploymentRepository.save(dep);
			String deploymentName = depName + Long.toString(dep.getId());
			dep.setName(deploymentName);
		}
		
		// Next deployments use given id's
		else {
			String deploymentName = depName + id;
			dep.setName(deploymentName);
		}

		dep.updateArgs();
		dep.setSpec("replicas", instances);
		dep.setUrl(depUrl + "/" + dep.getName());
		dep.updateName();
		dep.addToContainers("image", "localhost:5000/connectorservice");
		dep.setPort(8081);
		
		// Save changes to database for flow deployments
		if (needsSaving == true) {
			deploymentRepository.save(dep);
		}
		
		return dep;
	}
	
	// Deploys deployment
	public void deployDeployment(Deployment deployment, String id) {
		
		// Update current deployment
		JSONObject JSONDeploy = new JSONObject(deployment);
		HttpEntity<String> put_entity = new HttpEntity<String>(JSONDeploy.toString(),headers);
		String deploymentUrl = deployment.getUrl();
		restTemplate.exchange(deploymentUrl, HttpMethod.PUT, put_entity, String.class);
//		flowRepository.findById(Long.parseLong(id)).ifPresent(x -> x.setDeployment(deployment));
		
		// Ready second deployment
		String nextGetDeploymentUrl = depUrl + '/' + depName + Long.toString(deployment.getId() + 1);
		HttpEntity<String> get_entity = new HttpEntity<String>(headers);
		
		// Execute request to check if the next deployment exist, catch error if not exist and create next deployment
		try
		{
			restTemplate.exchange(nextGetDeploymentUrl, HttpMethod.GET, get_entity, String.class);
			
		} catch(HttpClientErrorException e) {
			this.needsSaving = false;
			
			Deployment nextDep = createDeployment(Long.toString((deployment.getId() + 1)), 1);
			JSONObject JSONDeploy2 = new JSONObject(nextDep);
			HttpEntity<String> entity2 = new HttpEntity<String>(JSONDeploy2.toString(), headers);
			restTemplate.postForObject(depUrl, entity2, String.class);
			
			this.needsSaving = true;

		}
		
		// Return the current updated deployment
//		return put_answer.getBody();
	}
	
	public String deleteDeployment(String flowId) {
		Optional<Flow> flow = flowRepository.findById(Long.parseLong(flowId));
		
		if (flow.isPresent()) {

			Flow flowObj = flow.get();
			Deployment deployment = flowObj.getDeployment();
			
			if (deployment != null)
			{
				HttpEntity<String> delete_entity = new HttpEntity<String>(headers);
				String deploymentName = deployment.getName();
				String deleteDeploymentUrl = depUrl + '/' + deploymentName;
				
				ResponseEntity<String> delete_answer = restTemplate.exchange(deleteDeploymentUrl, HttpMethod.DELETE, delete_entity, String.class);
				
				return delete_answer.getBody();
			}
		}
		
		return "DeploymentFlow not found";
	}
	
	public boolean checkCluster() {
		String clusterUrl = "";
		
		// Build clusterUrl from application properties till /api is reached e.g: http://<url>/api
		for(int i = 0; i < 4; i++) {
			clusterUrl += depUrl.split("(?=/)")[i];
		}
		
		// Execute request to check if the cluster is reachable, return true if reachable else false
		try
		{
			HttpEntity<String> get_entity = new HttpEntity<String>(headers);
			restTemplate.exchange(clusterUrl, HttpMethod.GET, get_entity, String.class);
			
			return true;
			
		} catch(ResourceAccessException e) {

			return false;
		}
		
	}
}

