package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.assimbly.gateway.domain.enumeration.EndpointType;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ErrorEndpoint.class)
public abstract class ErrorEndpoint_ {

	public static volatile SingularAttribute<ErrorEndpoint, Service> service;
	public static volatile SingularAttribute<ErrorEndpoint, String> options;
	public static volatile SingularAttribute<ErrorEndpoint, Header> header;
	public static volatile SingularAttribute<ErrorEndpoint, Long> id;
	public static volatile SingularAttribute<ErrorEndpoint, EndpointType> type;
	public static volatile SingularAttribute<ErrorEndpoint, String> uri;

	public static final String SERVICE = "service";
	public static final String OPTIONS = "options";
	public static final String HEADER = "header";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String URI = "uri";

}

