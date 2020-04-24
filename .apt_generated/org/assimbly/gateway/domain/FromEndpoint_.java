package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.assimbly.gateway.domain.enumeration.EndpointType;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FromEndpoint.class)
public abstract class FromEndpoint_ {

	public static volatile SingularAttribute<FromEndpoint, Service> service;
	public static volatile SingularAttribute<FromEndpoint, String> options;
	public static volatile SingularAttribute<FromEndpoint, Header> header;
	public static volatile SingularAttribute<FromEndpoint, Long> id;
	public static volatile SingularAttribute<FromEndpoint, EndpointType> type;
	public static volatile SingularAttribute<FromEndpoint, String> uri;

	public static final String SERVICE = "service";
	public static final String OPTIONS = "options";
	public static final String HEADER = "header";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String URI = "uri";

}

