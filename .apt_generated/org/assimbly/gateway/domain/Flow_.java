package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.assimbly.gateway.domain.enumeration.LogLevelType;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Flow.class)
public abstract class Flow_ {

	public static volatile SingularAttribute<Flow, FromEndpoint> fromEndpoint;
	public static volatile SetAttribute<Flow, ToEndpoint> toEndpoints;
	public static volatile SingularAttribute<Flow, Integer> instances;
	public static volatile SingularAttribute<Flow, Boolean> distributed;
	public static volatile SingularAttribute<Flow, ErrorEndpoint> errorEndpoint;
	public static volatile SingularAttribute<Flow, String> type;
	public static volatile SingularAttribute<Flow, Boolean> loadBalancing;
	public static volatile SingularAttribute<Flow, Boolean> autoStart;
	public static volatile SingularAttribute<Flow, Boolean> offLoading;
	public static volatile SingularAttribute<Flow, LogLevelType> logLevel;
	public static volatile SingularAttribute<Flow, String> name;
	public static volatile SingularAttribute<Flow, Integer> redeliveryDelay;
	public static volatile SingularAttribute<Flow, Long> id;
	public static volatile SingularAttribute<Flow, String> deployment_id;
	public static volatile SingularAttribute<Flow, Integer> maximumRedeliveries;
	public static volatile SingularAttribute<Flow, Gateway> gateway;

	public static final String FROM_ENDPOINT = "fromEndpoint";
	public static final String TO_ENDPOINTS = "toEndpoints";
	public static final String INSTANCES = "instances";
	public static final String DISTRIBUTED = "distributed";
	public static final String ERROR_ENDPOINT = "errorEndpoint";
	public static final String TYPE = "type";
	public static final String LOAD_BALANCING = "loadBalancing";
	public static final String AUTO_START = "autoStart";
	public static final String OFF_LOADING = "offLoading";
	public static final String LOG_LEVEL = "logLevel";
	public static final String NAME = "name";
	public static final String REDELIVERY_DELAY = "redeliveryDelay";
	public static final String ID = "id";
	public static final String DEPLOYMENT_ID = "deployment_id";
	public static final String MAXIMUM_REDELIVERIES = "maximumRedeliveries";
	public static final String GATEWAY = "gateway";

}

