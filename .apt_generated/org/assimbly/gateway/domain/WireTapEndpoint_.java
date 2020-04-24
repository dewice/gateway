package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.assimbly.gateway.domain.enumeration.EndpointType;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WireTapEndpoint.class)
public abstract class WireTapEndpoint_ {

	public static volatile SingularAttribute<WireTapEndpoint, Service> service;
	public static volatile SingularAttribute<WireTapEndpoint, String> options;
	public static volatile SingularAttribute<WireTapEndpoint, Header> header;
	public static volatile SingularAttribute<WireTapEndpoint, Long> id;
	public static volatile SingularAttribute<WireTapEndpoint, EndpointType> type;
	public static volatile SingularAttribute<WireTapEndpoint, String> uri;

	public static final String SERVICE = "service";
	public static final String OPTIONS = "options";
	public static final String HEADER = "header";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String URI = "uri";

}

