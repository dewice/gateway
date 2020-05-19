package org.assimbly.gateway.web.rest;

import org.assimbly.gateway.service.LoadBalancerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/broadcast")
public class LoadbalancerResource {
	
	@Autowired
	LoadBalancerService lbs;
	
	@PostMapping(path = "/connector/{connectorId}/setdistributedflowconfiguration/{id}/deployment/{deploymentId}")
    public String setDistributedFlowConfiguration
    (@RequestBody String configuration, @RequestHeader("Authorization") String jwt, @PathVariable Long connectorId, @PathVariable Long id, @PathVariable Long deploymentId)
	{
		return lbs.setDistributedFlowConfiguration(configuration, jwt, connectorId, id, deploymentId);
    }
	
	@GetMapping(path = "/connector/{connectorId}/flow/start/{id}/deployment/{deploymentId}", produces = "application/json")
    public String startFlowDistributed
    (@RequestHeader("Authorization") String jwt, @PathVariable Long connectorId, @PathVariable Long id, @PathVariable Long deploymentId)
	{
		return lbs.createConnectorRequest(jwt, connectorId, id, deploymentId, "/flow/start/");
	}
	
	@GetMapping(path = "/connector/{connectorId}/flow/stop/{id}/deployment/{deploymentId}", produces = "application/json")
    public String stopFlowDistributed
    (@RequestHeader("Authorization") String jwt, @PathVariable Long connectorId, @PathVariable Long id, @PathVariable Long deploymentId)
	{
		return lbs.createConnectorRequest(jwt, connectorId, id, deploymentId, "/flow/stop/");
	}

	@GetMapping(path = "/connector/{connectorId}/flow/pause/{id}/deployment/{deploymentId}", produces = "application/json")
    public String pauseFlowDistributed
    (@RequestHeader("Authorization") String jwt, @PathVariable Long connectorId, @PathVariable Long id, @PathVariable Long deploymentId)
	{
		return lbs.createConnectorRequest(jwt, connectorId, id, deploymentId, "/flow/pause/");
	}

	@GetMapping(path = "/connector/{connectorId}/flow/resume/{id}/deployment/{deploymentId}", produces = "application/json")
    public String resumeFlowDistributed
    (@RequestHeader("Authorization") String jwt, @PathVariable Long connectorId, @PathVariable Long id, @PathVariable Long deploymentId)
	{
		return lbs.createConnectorRequest(jwt, connectorId, id, deploymentId, "/flow/resume/");
	}

	@GetMapping(path = "/connector/{connectorId}/flow/restart/{id}/deployment/{deploymentId}", produces = "application/json")
    public String restartFlowDistributed
    (@RequestHeader("Authorization") String jwt, @PathVariable Long connectorId, @PathVariable Long id, @PathVariable Long deploymentId)
	{
		return lbs.createConnectorRequest(jwt, connectorId, id, deploymentId, "/flow/restart/");
	}
	
    @GetMapping(path = "/connector/{connectorId}/flow/status/{id}/deployment/{deploymentId}", produces = "application/json")
    public String getDistributedFlowStatus
    (@RequestHeader("Authorization") String jwt, @PathVariable Long connectorId, @PathVariable Long id, @PathVariable Long deploymentId)
	{
		return lbs.createConnectorRequest(jwt, connectorId, id, deploymentId, "/flow/status/");
	}
	
    @GetMapping(path = "/connector/{connectorId}/flow/stats/{id}/deployment/{deploymentId}", produces = "application/json")
    public String getDistributedFlowStats
    (@RequestHeader("Authorization") String jwt, @PathVariable Long connectorId, @PathVariable Long id, @PathVariable Long deploymentId)
	{
		return lbs.createConnectorRequest(jwt, connectorId, id, deploymentId, "/flow/stats/");
	}
//	@GetMapping(path = "/securities/syncTrustore")
//    public String syncSecurityInTruststoreDistributed
//    (@RequestHeader("Authorization") String jwt)
//	{
//		return lbs.createSecurityRequest(jwt, "/syncTrustore");
//	}
	
}