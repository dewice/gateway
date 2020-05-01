package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ServiceKeys.class)
public abstract class ServiceKeys_ {

	public static volatile SingularAttribute<ServiceKeys, Service> service;
	public static volatile SingularAttribute<ServiceKeys, Long> id;
	public static volatile SingularAttribute<ServiceKeys, String> type;
	public static volatile SingularAttribute<ServiceKeys, String> value;
	public static volatile SingularAttribute<ServiceKeys, String> key;

	public static final String SERVICE = "service";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String VALUE = "value";
	public static final String KEY = "key";

}

