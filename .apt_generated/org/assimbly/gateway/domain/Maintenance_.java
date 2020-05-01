package org.assimbly.gateway.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Maintenance.class)
public abstract class Maintenance_ {

	public static volatile SingularAttribute<Maintenance, Instant> duration;
	public static volatile SingularAttribute<Maintenance, Instant> startTime;
	public static volatile SingularAttribute<Maintenance, Long> id;
	public static volatile SingularAttribute<Maintenance, Instant> endTime;
	public static volatile SingularAttribute<Maintenance, String> frequency;

	public static final String DURATION = "duration";
	public static final String START_TIME = "startTime";
	public static final String ID = "id";
	public static final String END_TIME = "endTime";
	public static final String FREQUENCY = "frequency";

}

