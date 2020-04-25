package org.assimbly.gateway.service;

import org.json.JSONObject;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import org.assimbly.gateway.domain.Deployment;

@Service
public class KubernetesService {
	
	private final Environment environment;
	private final String depName;
	private final String depUrl;
	
	public KubernetesService(Environment env) {
		this.environment = env;
		this.depName = environment.getProperty("application.cluster.deploymentName");
		this.depUrl = environment.getProperty("application.cluster.deploymentUrl");
	}

	// Creates a new kubernetes deployment
	public Deployment createDeployment(String id, Integer instances) {
		
		Deployment dep = new Deployment(Integer.parseInt(id));
		String deploymentName = depName + id;
		dep.updateArgs();
		dep.setName(deploymentName);
		dep.setSpec("replicas", instances);
		dep.setUrl(depUrl + "/" + dep.getName());
		dep.updateName();
		dep.addToContainers("image", "localhost:5000/connectorservice");
		dep.setPort(8081);
		
		return dep;
	}
	
	// Deploys deployment
	public String deployDeployment(Deployment deployment) {
		
		// Update current deployment
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		JSONObject JSONDeploy = new JSONObject(deployment);
		HttpEntity<String> put_entity = new HttpEntity<String>(JSONDeploy.toString(),headers);
		String deploymentUrl = deployment.getUrl();
		ResponseEntity<String> put_answer = restTemplate.exchange(deploymentUrl, HttpMethod.PUT, put_entity, String.class);
		
		// Ready second deployment
		String nextGetDeploymentUrl = depUrl + '/' + depName + Integer.toString(deployment.getId() + 1);
		HttpEntity<String> get_entity = new HttpEntity<String>(headers);
		
		// Execute request to check if the next deployment exist, catch error if not exist and create next deployment
		try
		{
			restTemplate.exchange(nextGetDeploymentUrl, HttpMethod.GET, get_entity, String.class);
			
		} catch(HttpClientErrorException e) {
			Deployment nextDep = createDeployment(Integer.toString((deployment.getId() + 1)), 1);
			JSONObject JSONDeploy2 = new JSONObject(nextDep);
			HttpEntity<String> entity2 = new HttpEntity<String>(JSONDeploy2.toString(), headers);
			restTemplate.postForObject(depUrl, entity2, String.class);
		}
		
		// Return the current updated deployment
		return put_answer.getBody();	
	}
}
