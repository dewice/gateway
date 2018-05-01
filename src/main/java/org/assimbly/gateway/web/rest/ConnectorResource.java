package org.assimbly.gateway.web.rest;

import io.swagger.annotations.ApiParam;

import org.assimbly.connector.Connector;
import org.assimbly.connector.impl.CamelConnector;
import org.assimbly.gateway.web.rest.util.ResponseUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codahale.metrics.annotation.Timed;

import java.net.URISyntaxException;

import javax.annotation.PostConstruct;

/**
 * Resource to return information about the currently running Spring profiles.
 */
@RestController
@RequestMapping("/api")
public class ConnectorResource {

	private Connector connector = new CamelConnector();

	private String flowId;


	private boolean plainResponse;

	private String gatewayConfiguration;
	private String flowConfiguration;

	private String status;

    public ConnectorResource() {}
    
    //configure connector (by gatewayid)
    
    /**
     * POST  /connector/{connectorid}/setconfiguration : Set configuration from XML.
     *
     * @param connectorId (gatewayId)
     * @param configuration as xml
     * @return the ResponseEntity with status 200 (Successful) and status 400 (Bad Request) if the configuration failed
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping(path = "/connector/{connectorId}/setconfiguration", consumes =  {"text/plain","application/xml","application/json"}, produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String> setConfiguration(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId,@RequestBody String configuration) throws Exception {
    	
       	try {
       		connector.setConfiguration(connectorId.toString(), mediaType, configuration);
   			return ResponseUtil.createSuccessResponse(connectorId, mediaType,"setConfiguration","Connector configuration set");
   		} catch (Exception e) {
   			return ResponseUtil.createFailureResponse(connectorId, mediaType,"setConfiguration","Connector configuration set",e);
   		}
    	
    }    
    
    /**
     * Get  /connector/{connectorId}/getconfiguration : get XML configuration for gateway.
     *
     * @param connectorid (gatewayId)
     * @return the ResponseEntity with status 200 (Successful) and status 400 (Bad Request) if the configuration failed
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @GetMapping(path = "/connector/{connectorId}/getconfiguration", produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String> getConfiguration(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId) throws Exception {

    	plainResponse = true;
    	
    	try {
			gatewayConfiguration = connector.getConfiguration(connectorId.toString(),mediaType);
			if(gatewayConfiguration.startsWith("Error")||gatewayConfiguration.startsWith("Warning")) {plainResponse = false;}
			return ResponseUtil.createSuccessResponse(connectorId, mediaType,"getConfiguration",gatewayConfiguration,plainResponse);				
   		} catch (Exception e) {
   			return ResponseUtil.createFailureResponse(connectorId, mediaType,"getConfiguration",gatewayConfiguration,e);
   		}

    }    

    /**
     * POST  /connector/{connectorId}/setflowconfiguration/{id} : Set configuration from XML.
     *
     * @param connectorid (gatewayId)
     * @param id (FlowId)
     * @param configuration as XML / if empty get from db (for the time being)
     * @return the ResponseEntity with status 200 (Successful) and status 400 (Bad Request) if the configuration failed
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping(path = "/connector/{connectorId}/setflowconfiguration/{id}", consumes =  {"text/plain","application/xml","application/json"}, produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String> setFlowConfiguration(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId,@PathVariable Long id,@RequestBody String configuration) throws Exception {
  	
    	System.out.println("mediaType=" + mediaType);
    	
       	try {
       		connector.setFlowConfiguration(id.toString(), mediaType, configuration);
			return ResponseUtil.createSuccessResponse(connectorId, mediaType,"setFlowConfiguration","Flow configuration set");
			
   		} catch (Exception e) {
   			return ResponseUtil.createFailureResponse(connectorId, mediaType,"setFlowConfiguration","Flow configuration set",e);
   		}
    }    

    /**
     * Get  /connector/{connectorId}/getflowconfiguration/{id} : get XML configuration for gateway.
     *
     * @param connectorid (gatewayId)
     * @param id (flowId)
     * @return the ResponseEntity with status 200 (Successful) and status 400 (Bad Request) if the configuration failed
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @GetMapping(path = "/connector/{connectorId}/getflowconfiguration/{id}", produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String> getFlowConfiguration(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId, @PathVariable Long id) throws Exception {

    	plainResponse = true;
    	
    	try {
			flowConfiguration = connector.getFlowConfiguration(id.toString(),mediaType);
			if(flowConfiguration.startsWith("Error")||flowConfiguration.startsWith("Warning")) {plainResponse = false;}
			return ResponseUtil.createSuccessResponse(connectorId, mediaType,"getFlowConfiguration",flowConfiguration,plainResponse);				
   		} catch (Exception e) {
   			return ResponseUtil.createFailureResponse(connectorId, mediaType,"getFlowConfiguration",flowConfiguration,e);
   		}
    }    

    
	//manage connector
    /**
     * Get  /start : starts connector.
     * 
     * @param connectorId (by gatewayId)
     * @return The ResponseEntity with status 200 (Successful) and status 400 (Bad Request) if the starting connector failed
     * @throws Exception 
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @GetMapping(path = "/connector/{connectorId}/start", produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String> start(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId) throws Exception {
       	try {
   			connector.start();
   			return ResponseUtil.createSuccessResponse(connectorId, mediaType,"start","Connector started");
   		} catch (Exception e) {
   			return ResponseUtil.createFailureResponse(connectorId, mediaType,"start","Connector started",e);
   		} 
    }
    
    /**
    * GET  /stop : stops connector.
    *
    * @param connectorId (by gatewayId)
    * @return the ResponseEntity with status 200 (Successful) and status 400 (Bad Request) if the stopping connector failed
    * @throws URISyntaxException if the Location URI syntax is incorrect
    */
   @GetMapping(path = "/connector/{connectorId}/stop", produces = {"text/plain","application/xml","application/json"})
   @Timed
   public ResponseEntity<String> stop(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType,  @PathVariable Long connectorId) throws Exception {
       
      	try {
  			connector.stop();
  			return ResponseUtil.createSuccessResponse(connectorId, mediaType,"stop","Connector stopped");
  		} catch (Exception e) {
  			return ResponseUtil.createFailureResponse(connectorId, mediaType,"stop","Connector stopped",e);
  		}
   }

    
   /**
   * GET  /istarted : checks if connector is started.
   *
   * @param connectorId (by GatewaId)
   * @return the ResponseEntity with status 200 (Successful) and status 400 (Bad Request) if the stopping connector failed
 * @throws Exception 
   */
  @GetMapping(path = "/connector/{connectorId}/isStarted", produces = {"text/plain","application/xml","application/json"})
  @Timed
  public ResponseEntity<String> isStarted(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType,  @PathVariable Long connectorId) throws Exception {
 
		try {
			Boolean started = connector.isStarted();
			return ResponseUtil.createSuccessResponse(connectorId, mediaType,"isStarted",started.toString());
		} catch (Exception e) {
			return ResponseUtil.createFailureResponse(connectorId, mediaType,"isStarted","Retrieving connector status",e);
		}  
	  
  }
  
	//manage flow
    @GetMapping(path = "/connector/{connectorId}/hasflow/{id}", produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String> hasFlow(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId, @PathVariable Long id) throws Exception {

		try {
			Boolean hasFlow = connector.hasFlow(id.toString());
			return ResponseUtil.createSuccessResponse(connectorId, mediaType,"isStarted",hasFlow.toString());
		} catch (Exception e) {
			return ResponseUtil.createFailureResponse(connectorId, mediaType,"isStarted","Retrieving flows",e);
		}  
 
    }

    @GetMapping(path = "/connector/{connectorId}/removeflow/{id}", produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String> removeFlow(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId, @PathVariable Long id) throws Exception {

		try {
			Boolean removedFlow = connector.removeFlow(id.toString());
			return ResponseUtil.createSuccessResponse(connectorId, mediaType,"isStarted",removedFlow.toString());
		} catch (Exception e) {
			return ResponseUtil.createFailureResponse(connectorId, mediaType,"isStarted","Retrieving flows",e);
		}  
 
    }    
    
    @GetMapping(path = "/connector/{connectorId}/flow/start/{id}", produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String> startflow(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId, @PathVariable Long id) throws Exception {

		try {
        	init();
        	flowId = id.toString();
    		status = connector.startFlow(flowId);
    		if(status.equals("started")) {
    			return ResponseUtil.createSuccessResponseWithHeaders(connectorId, mediaType,"startFlow","started","started flow " + flowId,flowId);
    		}else {
    			throw new Exception(status);
    		}			
		} catch (Exception e) {
			return ResponseUtil.createFailureResponseWithHeaders(connectorId, mediaType,"startFlow","unable to start flow " + flowId,"unable to start flow " + flowId,flowId,e);
		}   	

    }

	@GetMapping(path = "/connector/{connectorId}/flow/stop/{id}", produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String>  stopflow(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId, @PathVariable Long id) throws Exception {

		try {
        	init();
        	flowId = id.toString();
    		status = connector.stopFlow(flowId);
    		if(status.equals("stopped")) {
    			return ResponseUtil.createSuccessResponseWithHeaders(connectorId, mediaType,"stopFlow","stopped","stopped flow " + flowId,flowId);
    		}else {
    			throw new Exception(status);
    		}			
		} catch (Exception e) {
			return ResponseUtil.createFailureResponseWithHeaders(connectorId, mediaType,"stopFlow","unable to stop flow " + flowId,"unable to stop flow " + flowId,flowId,e);
		}
				
     }

    @GetMapping(path = "/connector/{connectorId}/flow/restart/{id}", produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String>  restartflow(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId, @PathVariable Long id) throws Exception {

		try {
        	init();
        	flowId = id.toString();
    		status = connector.restartFlow(flowId);
    		if(status.equals("started")) {
    			return ResponseUtil.createSuccessResponseWithHeaders(connectorId, mediaType,"restartFlow","restarted","restarted flow " + flowId,flowId);
    		}else {
    			throw new Exception(status);
    		}			
		} catch (Exception e) {
			return ResponseUtil.createFailureResponseWithHeaders(connectorId, mediaType,"restartFlow","unable to restart flow " + flowId,"unable to restart flow " + flowId,flowId,e);
		}

    }    

    @GetMapping(path = "/connector/{connectorId}/flow/pause/{id}", produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String>  pauseflow(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId, @PathVariable Long id) throws Exception {

		try {
        	init();
        	flowId = id.toString();
    		status = connector.pauseFlow(flowId);
    		if(status.equals("suspended")) {
    			return ResponseUtil.createSuccessResponseWithHeaders(connectorId, mediaType,"pauseFlow","paused","paused flow " + flowId,flowId);
    		}else {
    			throw new Exception(status);
    		}			
		} catch (Exception e) {
			return ResponseUtil.createFailureResponseWithHeaders(connectorId, mediaType,"pauseFlow","unable to pause flow " + flowId,"unable to pause flow " + flowId,flowId,e);
		}    	
            
     }

    @GetMapping(path = "/connector/{connectorId}/flow/resume/{id}" , produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String> resumeflow(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId, @PathVariable Long id) throws Exception {

    	try {
        	init();
        	flowId = id.toString();
    		status = connector.resumeFlow(flowId);
    		if(status.equals("started")) {
    			return ResponseUtil.createSuccessResponseWithHeaders(connectorId, mediaType,"resumeFlow","resumed","resumed flow " + flowId,flowId);
    		}else {
    			throw new Exception(status);
    		}			
		} catch (Exception e) {
			return ResponseUtil.createFailureResponseWithHeaders(connectorId, mediaType,"pauseFlow","unable to resume flow " + flowId,"unable to resume flow " + flowId,flowId,e);
		}     
     }    
    
    @GetMapping(path = "/connector/{connectorId}/flow/status/{id}", produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String> getStatusflow(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId, @PathVariable Long id) throws Exception {

		try {
        	init();
        	flowId = id.toString();
    		status = connector.getFlowStatus(flowId);
			return ResponseUtil.createSuccessResponseWithHeaders(connectorId, mediaType,"getStatusFlow",status,status,flowId);
		} catch (Exception e) {
			return ResponseUtil.createFailureResponseWithHeaders(connectorId, mediaType,"getStatusFlow","unable to get status for flow " + flowId,"unable to get status for flow " + flowId,flowId,e);
		}  
    	
    }

    @GetMapping(path = "/connector/{connectorId}/flow/uptime/{id}", produces = {"text/plain","application/xml","application/json"})
    @Timed
    public ResponseEntity<String> getUptimeflow(@ApiParam(hidden = true) @RequestHeader("Accept") String mediaType, @PathVariable Long connectorId, @PathVariable Long id) throws Exception {

		try {
        	init();
        	flowId = id.toString();
    		String uptime = connector.getFlowUptime(flowId);
			return ResponseUtil.createSuccessResponseWithHeaders(connectorId, mediaType,"getUptimeFlow",uptime,uptime,flowId);
		} catch (Exception e) {
			return ResponseUtil.createFailureResponseWithHeaders(connectorId, mediaType,"getUptimeFlow","unable to get status flow " + flowId,"unable to get uptime flow " + flowId,flowId,e);
		}
    	
    }    
    
    //private methods    
    
    //This method is called on application startup and on manage flow calls
    @PostConstruct
    private void init() throws Exception {
    
       	if(!connector.isStarted()){
        	try {
				connector.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
	}
}