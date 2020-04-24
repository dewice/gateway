package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.assimbly.gateway.domain.enumeration.ConnectorType;
import org.assimbly.gateway.domain.enumeration.EnvironmentType;
import org.assimbly.gateway.domain.enumeration.GatewayType;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Gateway.class)
public abstract class Gateway_ {

	public static volatile SingularAttribute<Gateway, ConnectorType> connectorType;
	public static volatile SingularAttribute<Gateway, String> defaultToEndpointType;
	public static volatile SingularAttribute<Gateway, EnvironmentType> stage;
	public static volatile SetAttribute<Gateway, Flow> flows;
	public static volatile SingularAttribute<Gateway, String> environmentName;
	public static volatile SetAttribute<Gateway, EnvironmentVariables> environmentVariables;
	public static volatile SingularAttribute<Gateway, String> defaultFromEndpointType;
	public static volatile SingularAttribute<Gateway, String> name;
	public static volatile SingularAttribute<Gateway, Long> id;
	public static volatile SingularAttribute<Gateway, GatewayType> type;
	public static volatile SingularAttribute<Gateway, String> defaultErrorEndpointType;
	public static volatile SingularAttribute<Gateway, WireTapEndpoint> wiretapEndpoint;

	public static final String CONNECTOR_TYPE = "connectorType";
	public static final String DEFAULT_TO_ENDPOINT_TYPE = "defaultToEndpointType";
	public static final String STAGE = "stage";
	public static final String FLOWS = "flows";
	public static final String ENVIRONMENT_NAME = "environmentName";
	public static final String ENVIRONMENT_VARIABLES = "environmentVariables";
	public static final String DEFAULT_FROM_ENDPOINT_TYPE = "defaultFromEndpointType";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String DEFAULT_ERROR_ENDPOINT_TYPE = "defaultErrorEndpointType";
	public static final String WIRETAP_ENDPOINT = "wiretapEndpoint";

}

