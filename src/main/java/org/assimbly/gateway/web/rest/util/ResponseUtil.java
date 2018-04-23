package org.assimbly.gateway.web.rest.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

/**
 * Utility class for HTTP body creation.
 */
public final class ResponseUtil {

    private final static Logger log = LoggerFactory.getLogger(ResponseUtil.class);
	
    private static ResponseEntity<String> response;


	private ResponseUtil() {
    }

    
    public static ResponseEntity<String> createSuccessResponse(long connectorId, String mediaType, String action, String message) throws Exception{

    	log.debug("REST request with action " + action + " for gateway with id " + connectorId);
    	
    	switch (mediaType.toLowerCase()) {    	
	        case "application/json":
	        	response = ResponseEntity.ok()
	        		.body(BodyUtil.createSuccessJSONResponse(connectorId, action, message));
	            break;
	        case "application/xml":
	        	response = ResponseEntity.ok()
	        		.body(BodyUtil.createSuccessXMLResponse(connectorId, action, message));
	            break;
	        default: 
	        	response = ResponseEntity.ok()
	        		.body(BodyUtil.createSuccessTEXTResponse(message));
	            break;
    	}
    	
   		return response;    	
    }

    public static ResponseEntity<String> createSuccessResponse(long connectorId, String mediaType, String action, String message, boolean plainResponse) throws Exception{

    	log.debug("REST request with action " + action + " for gateway with id " + connectorId);
    
    	if(plainResponse) {
        	response = ResponseEntity.ok()
	        		.body(message);
    	}else {

        	switch (mediaType.toLowerCase()) {    	
		        case "application/json":
		        	response = ResponseEntity.ok()
		        		.body(BodyUtil.createSuccessJSONResponse(connectorId, action, message));
		            break;
		        case "application/xml":
		        	response = ResponseEntity.ok()
		        		.body(BodyUtil.createSuccessXMLResponse(connectorId, action, message));
		            break;
		        default: 
		        	response = ResponseEntity.ok()
		        		.body(BodyUtil.createSuccessTEXTResponse(message));
		            break;
        	}
    	}
    	
    	return response;	
   	}
    
    
    public static ResponseEntity<String> createSuccessResponseWithHeaders(long connectorId, String mediaType, String action, String message, String headerMessage, String headerParam) throws Exception{

    	log.debug("REST request with action " + action + " for gateway with id " + connectorId);
    	
    	switch (mediaType.toLowerCase()) {    	
	        case "application/json":
	        	response = ResponseEntity.ok().headers(HeaderUtil.createAlert(headerMessage,headerParam))
	        		.body(BodyUtil.createSuccessJSONResponse(connectorId, action, message));
	            break;
	        case "application/xml":
	        	response = ResponseEntity.ok().headers(HeaderUtil.createAlert(headerMessage,headerParam))
	        		.body(BodyUtil.createSuccessXMLResponse(connectorId, action, message));
	            break;
	        default: 
	        	response = ResponseEntity.ok().headers(HeaderUtil.createAlert(headerMessage,headerParam))
	        		.body(BodyUtil.createSuccessTEXTResponse(message));
	            break;
    	}
    	
   		return response;    	
    }    
    
    public static ResponseEntity<String> createFailureResponse(long connectorId, String mediaType, String action, String message, Exception e) throws Exception{

		log.error("REST request with action " + action + " for gateway with id " + connectorId + " failed.");
		e.printStackTrace();

    	switch (mediaType.toLowerCase()) {    	
	        case "application/json":
	        	response = ResponseEntity.badRequest()
	        		.body(BodyUtil.createFailureJSONResponse(connectorId, action, message + " failed: " + e.getMessage()));
	            break;
	        case "application/xml":
	        	response = ResponseEntity.badRequest()
	        		.body(BodyUtil.createFailureXMLResponse(connectorId, action, message + " failed: " + e.getMessage()));
	
	            break;
	        default: 
	        	response = ResponseEntity.badRequest()
	        		.body(BodyUtil.createFailureTEXTResponse(message + " failed: " + e.getMessage()));
	            break;
    	}
		
		return response;
	}	

    
    public static ResponseEntity<String> createFailureResponseWithHeaders(long connectorId, String mediaType, String action, String message, String headerMessage, String headerParam, Exception e) throws Exception{

		log.error("REST request with action " + action + " for gateway with id " + connectorId + " failed.");
		e.printStackTrace();

    	switch (mediaType.toLowerCase()) {    	
	        case "application/json":
	        	response = ResponseEntity.badRequest().headers(HeaderUtil.createAlert(headerMessage,headerParam))
	        		.body(BodyUtil.createFailureJSONResponse(connectorId, action, message + " failed: " + e.getMessage()));
	            break;
	        case "application/xml":
	        	response = ResponseEntity.badRequest().headers(HeaderUtil.createAlert(headerMessage,headerParam))
	        		.body(BodyUtil.createFailureXMLResponse(connectorId, action, message + " failed: " + e.getMessage()));
	
	            break;
	        default: 
	        	response = ResponseEntity.badRequest().headers(HeaderUtil.createAlert(headerMessage,headerParam))
	        		.body(BodyUtil.createFailureTEXTResponse(message + " failed: " + e.getMessage()));
	            break;
    	}
		
		return response;
	}
    
}