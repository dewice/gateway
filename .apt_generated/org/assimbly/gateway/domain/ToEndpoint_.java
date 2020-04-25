package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.assimbly.gateway.domain.enumeration.EndpointType;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ToEndpoint.class)
public abstract class ToEndpoint_ {

	public static volatile SingularAttribute<ToEndpoint, Service> service;
	public static volatile SingularAttribute<ToEndpoint, String> options;
	public static volatile SingularAttribute<ToEndpoint, Header> header;
	public static volatile SingularAttribute<ToEndpoint, Long> id;
	public static volatile SingularAttribute<ToEndpoint, EndpointType> type;
	public static volatile SingularAttribute<ToEndpoint, String> uri;
	public static volatile SingularAttribute<ToEndpoint, Flow> flow;

	public static final String SERVICE = "service";
	public static final String OPTIONS = "options";
	public static final String HEADER = "header";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String URI = "uri";
	public static final String FLOW = "flow";

}

