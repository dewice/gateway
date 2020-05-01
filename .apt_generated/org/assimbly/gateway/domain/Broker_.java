package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Broker.class)
public abstract class Broker_ {

	public static volatile SingularAttribute<Broker, String> name;
	public static volatile SingularAttribute<Broker, Long> id;
	public static volatile SingularAttribute<Broker, String> type;
	public static volatile SingularAttribute<Broker, String> configurationType;
	public static volatile SingularAttribute<Broker, Boolean> autoStart;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String CONFIGURATION_TYPE = "configurationType";
	public static final String AUTO_START = "autoStart";

}

