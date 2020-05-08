package org.assimbly.gateway.web.rest;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/broadcast")
public class LoadbalancerResource {
	
    private final DiscoveryClient discoveryClient;
    
	private HttpHeaders headers;
	
	@Autowired
	RestTemplate restTemplate;
	
//	private String flowConfigPath = "/connector/1/setflowconfiguration/";
//	private String startFlowPath = 	"/connector/1/flow/start/";
//	private String stopFlowPath = "/connector/1/flow/stop/";
	
    public LoadbalancerResource(RouteLocator routeLocator, DiscoveryClient discoveryClient) {
    	this.discoveryClient = discoveryClient;
		this.headers = new HttpHeaders();
		this.headers.setContentType(MediaType.APPLICATION_JSON);
		this.headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    }

	@PostMapping(path = "/connector/{connectorId}/setdistributedflowconfiguration/{id}/deployment/{deploymentId}")
    public String setDistributedFlowConfiguration
    (@RequestBody String configuration, @RequestHeader("Authorization") String jwt, @PathVariable Long connectorId, @PathVariable Long id, @PathVariable Long deploymentId) {
		this.headers.add("Authorization", jwt);
		JSONObject JSONDeploy = new JSONObject(configuration);
		HttpEntity<String> post_entity = new HttpEntity<>(JSONDeploy.toString(), this.headers);
		List<ServiceInstance> array = this.discoveryClient.getInstances("connector");
		
		if(array.size() < 1)
		{
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "No instances found for flow " + id.toString()
			);
		}
		
		else if(array.size() == 1)
		{
			ServiceInstance instance = array.get(0);
			URI uri = URI.create(String.format("%s%s", instance.getUri(), "/api/connector/" + connectorId + "/setflowconfiguration/" + id));
			ResponseEntity<String> test = restTemplate.postForEntity(uri, post_entity, String.class);
			
			return test.getBody();
		}
		
		else
		{
			Map<String, Integer> responseStatusCodes = new HashMap<String, Integer>();
			
			for(ServiceInstance instance: array)
			{
				URI uri = URI.create(String.format("%s%s", instance.getUri(), "/api/connector/" + connectorId + "/setflowconfiguration/" + id));
		        ResponseEntity<String> test = restTemplate.exchange(uri, HttpMethod.POST, post_entity, String.class);
		        System.out.println("\n\n\n\n\n\n\n\n");
		        System.out.println(test.getBody());
		        System.out.println("\n\n\n\n\n\n\n\n");
		        responseStatusCodes.put(instance.getInstanceId(), test.getStatusCodeValue());
			}
			
			return responseStatusCodes.toString();
		}
    }
}
