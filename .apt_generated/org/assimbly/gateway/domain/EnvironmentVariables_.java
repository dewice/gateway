package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(EnvironmentVariables.class)
public abstract class EnvironmentVariables_ {

	public static volatile SingularAttribute<EnvironmentVariables, Long> id;
	public static volatile SingularAttribute<EnvironmentVariables, String> value;
	public static volatile SingularAttribute<EnvironmentVariables, String> key;
	public static volatile SingularAttribute<EnvironmentVariables, Gateway> gateway;

	public static final String ID = "id";
	public static final String VALUE = "value";
	public static final String KEY = "key";
	public static final String GATEWAY = "gateway";

}

