package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Service.class)
public abstract class Service_ {

	public static volatile SetAttribute<Service, ServiceKeys> serviceKeys;
	public static volatile SingularAttribute<Service, String> name;
	public static volatile SingularAttribute<Service, Long> id;
	public static volatile SingularAttribute<Service, String> type;

	public static final String SERVICE_KEYS = "serviceKeys";
	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TYPE = "type";

}

