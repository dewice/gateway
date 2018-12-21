package org.assimbly.gateway.config.environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.assimbly.gateway.domain.Flow;
import org.assimbly.gateway.domain.EnvironmentVariables;
import org.assimbly.gateway.domain.ErrorEndpoint;
import org.assimbly.gateway.domain.FromEndpoint;
import org.assimbly.gateway.domain.Gateway;
import org.assimbly.gateway.domain.Header;
import org.assimbly.gateway.domain.HeaderKeys;
import org.assimbly.gateway.domain.ServiceKeys;
import org.assimbly.gateway.domain.ToEndpoint;
import org.assimbly.gateway.domain.WireTapEndpoint;
import org.assimbly.gateway.repository.EnvironmentVariablesRepository;
import org.assimbly.gateway.repository.FlowRepository;
import org.assimbly.gateway.repository.GatewayRepository;
import org.assimbly.gateway.repository.WireTapEndpointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

@Service
@Transactional
public class DBExportProperties {

	public static int PRETTY_PRINT_INDENT_FACTOR = 4;

	private TreeMap<String, String> properties;

	public String options;
	public String componentType;
	public String uri;

	@Autowired
	private GatewayRepository gatewayRepository;

	@Autowired
	private FlowRepository flowRepository;

	@Autowired
	private WireTapEndpointRepository wireTapEndpointRepository;

	@Autowired
	private EnvironmentVariablesRepository environmentVariablesRepository;

	private FromEndpoint fromEndpoint;

	private ErrorEndpoint errorEndpoint;

	private Set<ToEndpoint> toEndpoints;

	private org.assimbly.gateway.domain.Service service;

	private Header header;
	public String xmlConfiguration;
	private Element rootElement;
	private Document doc;
	private Element flows;
	private Element services;
	private Element headers;
	private Element flow;
	public String connectorId;

	private List<String> servicesList;
	private List<String> headersList;

	public String configuration;

	private Element offloading;

	private Node environmentVariablesList;

	private List<TreeMap<String, String>> propertiesList;

	// Treemap get methods
	public List<TreeMap<String, String>> getProperties(Long gatewayId) throws Exception {

		propertiesList = new ArrayList<>();
		List<Flow> flows = flowRepository.findAllByGatewayId(gatewayId);

		for (Flow flow : flows) {
			if (flow != null) {
				TreeMap<String, String> flowConfiguration = getFlowProperties(flow);
				if (flowConfiguration != null) {
					propertiesList.add(flowConfiguration);
				}
			}
		}

		return propertiesList;

	}

	public TreeMap<String, String> getFlowProperties(Long id) throws Exception {

		properties = new TreeMap<String, String>();

		Flow flow = flowRepository.findOne(id);

		if (flow == null) {
			throw new Exception("Flow ID does not exists");
		}

		getGeneralFlowPropertiesFromDB(flow);

		if (fromEndpoint == null || toEndpoints == null || errorEndpoint == null) {
			throw new Exception("Set of configuration failed. Endpoint cannot be null");
		} else {
			getEndpointPropertiesFromDB(flow);
		}

		return properties;

	}

	public TreeMap<String, String> getFlowProperties(Flow flow) throws Exception {

		properties = new TreeMap<String, String>();

		getGeneralFlowPropertiesFromDB(flow);

		if (fromEndpoint == null || toEndpoints == null || errorEndpoint == null) {
			throw new Exception("Set of configuration failed. Endpoint cannot be null");
		} else {
			getEndpointPropertiesFromDB(flow);
		}

		return properties;

	}

	public void getEndpointPropertiesFromDB(Flow flow) throws Exception {

		// set from properties
		getURIfromAssimblyDB("from");
		getServiceFromAssimblyDB("from");
		getHeaderFromAssimblyDB("from");

		// set to properties
		getURIfromAssimblyDB("to");
		getServiceFromAssimblyDB("to");
		getHeaderFromAssimblyDB("to");

		// set error properties
		getURIfromAssimblyDB("error");
		getServiceFromAssimblyDB("error");
		getHeaderFromAssimblyDB("error");

		// set up defaults settings if null -->
		properties.put("id", Long.toString(flow.getId()));

		if (properties.get("from.uri") != null) {
			properties.put("route", "default");
		} else {
			properties.put("route", "none");
		}

		if (properties.get("to.uri") == null) {
			properties.put("to.uri", "stream:out");
		} else if (properties.get("to.uri").contains("wastebin")) {

			String uri = properties.get("to.uri");
			uri = uri.replace("wastebin:", "mock:wastebin");
			properties.put("to.uri", uri);
		}

		properties.put("header.contenttype", "text/xml;charset=UTF-8");

	}

	public void getURIfromAssimblyDB(String type) {

		options = "";

		switch (type) {
		case "from":

			componentType = fromEndpoint.getType().name();
			uri = fromEndpoint.getUri();
			options = fromEndpoint.getOptions();

			getURIProperties(type, componentType, uri, options);

			break;
		case "to":

			for (ToEndpoint toEndpoint : toEndpoints) {

				componentType = toEndpoint.getType().name();
				uri = toEndpoint.getUri();
				options = toEndpoint.getOptions();

				getURIProperties(type, componentType, uri, options);
			}

			break;
		case "error":

			componentType = errorEndpoint.getType().name();
			uri = errorEndpoint.getUri();
			options = errorEndpoint.getOptions();

			getURIProperties(type, componentType, uri, options);

			break;
		}
	}

	public void getURIProperties(String type, String componentType, String uri, String confOptions) {

		componentType = componentType.toLowerCase();

		componentType = setDefaultComponentType(componentType);

		// note that following doesn't set datasource
		confOptions = setDefaultOptions(componentType, confOptions);

		if (confOptions == null) {
			uri = componentType.toLowerCase() + uri;
		} else {
			uri = componentType.toLowerCase() + uri + "?" + confOptions;
		}

		properties.put(type + ".uri", uri);
	}

	public void getServiceFromAssimblyDB(String type) {

		switch (type) {
		case "from":

			service = fromEndpoint.getService();
			break;

		case "to":

			for (ToEndpoint toEndpoint : toEndpoints) {
				service = toEndpoint.getService();
			}

			break;

		case "error":

			service = errorEndpoint.getService();
			break;
		}

		if (service != null) {
			getServiceProperties(type, service);
		}

	}

	public void getServiceProperties(String type, org.assimbly.gateway.domain.Service service) {
		properties.put(type + ".service.id", service.getId().toString());
	}

	public void getHeaderFromAssimblyDB(String type) {

		switch (type) {
		case "from":

			header = fromEndpoint.getHeader();

			break;
		case "to":

			for (ToEndpoint toEndpoint : toEndpoints) {

				header = toEndpoint.getHeader();
			}

			break;
		case "error":

			header = errorEndpoint.getHeader();
			break;
		}

		if (header != null) {
			Set<HeaderKeys> headerKeys = header.getHeaderKeys();

			for (HeaderKeys headerKey : headerKeys) {
				properties.put(type + ".header." + headerKey.getKey(), headerKey.getValue());
			}
		}
	}

	private void getGeneralFlowPropertiesFromDB(Flow flow) throws Exception {

		fromEndpoint = flow.getFromEndpoint();
		errorEndpoint = flow.getErrorEndpoint();
		toEndpoints = flow.getToEndpoints();

	}

	private String setDefaultComponentType(String componentType) {

		if (componentType.equals("file") || componentType.equals("ftp") || componentType.equals("sftp")
				|| componentType.equals("ftps")) {
			componentType = componentType + "://";
		} else if (componentType.equals("http") || componentType.equals("http4")) {
			componentType = "http4://";
		} else {
			componentType = componentType + ":";
		}

		return componentType;
	}

	private String setDefaultOptions(String componentType, String confOptions) {

		if (componentType.matches("(file|ftp|sftp|sjms|sonicmq).*")) {
			if (confOptions.isEmpty() || confOptions == null) {
				confOptions = "bridgeErrorHandler=true";
			} else if (!confOptions.contains("bridgeErrorHandler")) {
				confOptions = confOptions + "&bridgeErrorHandler=true";
			}
		}

		return confOptions;
	}

}
