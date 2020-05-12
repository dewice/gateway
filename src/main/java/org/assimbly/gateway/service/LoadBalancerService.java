package org.assimbly.gateway.service;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LoadBalancerService {
	
    private final DiscoveryClient discoveryClient;
	private final Environment environment;
	private final String connectorURL = "/api/connector/";
//	private final String securityURL = "/api/securities";
	private final String depName;
	private HttpHeaders headers;
	
	@Autowired
	RestTemplate restTemplate;
	
    public LoadBalancerService(DiscoveryClient discoveryClient, Environment env) {
    	this.discoveryClient = discoveryClient;
		this.headers = new HttpHeaders();
		this.headers.setContentType(MediaType.APPLICATION_JSON);
		this.headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		this.environment = env;
		this.depName = environment.getProperty("application.cluster.deploymentName");
    }
	
	// Method for creating Connector Get-requests to given Connector paths
	public String createConnectorRequest(String jwt, Long connectorId, Long id, Long deploymentId, String path)
	{
		this.headers.add("Authorization", jwt);
		HttpEntity<String> get_entity = new HttpEntity<>("parameters", this.headers);
//		List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances(depName + deploymentId.toString());
		List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances("connector");
		
		if (serviceInstances.size() < 1)
		{
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "No instances found for flow " + id.toString()
			);
		}
		
		else if (serviceInstances.size() == 1)
		{
			ServiceInstance instance = serviceInstances.get(0);
			URI uri = URI.create(String.format("%s%s", instance.getUri(), connectorURL + connectorId + path + id));
			ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, get_entity, String.class);
			
			return response.getBody();
		}
		
		else
		{
			Map<String, String> responseStatusCodes = new HashMap<String, String>();
			
			for (ServiceInstance instance: serviceInstances)
			{
				URI uri = URI.create(String.format("%s%s", instance.getUri(), connectorURL + connectorId + path + id));
		        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, get_entity, String.class);
		        
		        if (path.equals("/flow/status/"))
		        {
					JSONObject object = new JSONObject(response.getBody());
					String message = object.get("message").toString();
		        	responseStatusCodes.put(instance.getInstanceId(), message);
		        }
		        else
		        {
			        responseStatusCodes.put(instance.getInstanceId(), Integer.toString(response.getStatusCodeValue()));
		        }

			}
			JSONObject JSONMap = new JSONObject(responseStatusCodes);
			return JSONMap.toString();
		}
	}
	
//	// Method for creating security Get-requests to given security paths for all connector instances
//	public String createSecurityRequest(String jwt, String path)
//	{
//		this.headers.add("Authorization", jwt);
//		HttpEntity<String> get_entity = new HttpEntity<>("parameters", this.headers);
//		List<String> serviceIds = this.discoveryClient.getServices();
//		Map<String, Integer> responseStatusCodes = new HashMap<String, Integer>();
//		
//		if (serviceIds.size() < 1)
//		{
//			return "No connector instances found";
//		}
//		
//		// Loop through all connector available instances and execute request
//		for (String serviceId: serviceIds) {
//			List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances(serviceId);
//			
//			if (serviceInstances.size() == 1)
//			{
//				ServiceInstance instance = serviceInstances.get(0);
//				URI uri = URI.create(String.format("%s%s", instance.getUri(), securityURL + path));
//				ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, get_entity, String.class);
//				
//				responseStatusCodes.put(instance.getInstanceId(), response.getStatusCodeValue());
//			}
//			
//			else if (serviceInstances.size() > 1)
//			{
//				for (ServiceInstance instance: serviceInstances)
//				{
//					URI uri = URI.create(String.format("%s%s", instance.getUri(), securityURL + path));
//			        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, get_entity, String.class);
//			        responseStatusCodes.put(instance.getInstanceId(), response.getStatusCodeValue());
//				}
//			}
//		}
//		return responseStatusCodes.toString();
//	}
	
	
	// Method for sending distributed flow configurations
    public String setDistributedFlowConfiguration
    (String configuration, String jwt, Long connectorId, Long id, @PathVariable Long deploymentId)
	{
		this.headers.add("Authorization", jwt);
		JSONObject JSONDeploy = new JSONObject(configuration);
		HttpEntity<String> post_entity = new HttpEntity<>(JSONDeploy.toString(), this.headers);
//		List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances(depName + deploymentId.toString());
		List<ServiceInstance> serviceInstances = this.discoveryClient.getInstances("connector");
		
		if (serviceInstances.size() < 1)
		{
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "No instances found for flow " + id.toString()
			);
		}
		
		else if (serviceInstances.size() == 1)
		{
			ServiceInstance instance = serviceInstances.get(0);
			URI uri = URI.create(String.format("%s%s", instance.getUri(), connectorURL + connectorId + "/setflowconfiguration/" + id));
			ResponseEntity<String> response = restTemplate.postForEntity(uri, post_entity, String.class);
			
			return response.getBody();
		}
		
		else
		{
			Map<String, Integer> responseStatusCodes = new HashMap<String, Integer>();
			
			for (ServiceInstance instance: serviceInstances)
			{
				URI uri = URI.create(String.format("%s%s", instance.getUri(), connectorURL + connectorId + "/setflowconfiguration/" + id));
		        ResponseEntity<String> response = restTemplate.postForEntity(uri, post_entity, String.class);
		        responseStatusCodes.put(instance.getInstanceId(), response.getStatusCodeValue());
			}
			
			return responseStatusCodes.toString();
		}
	}
}
