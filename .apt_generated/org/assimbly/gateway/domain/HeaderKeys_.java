package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(HeaderKeys.class)
public abstract class HeaderKeys_ {

	public static volatile SingularAttribute<HeaderKeys, Header> header;
	public static volatile SingularAttribute<HeaderKeys, Long> id;
	public static volatile SingularAttribute<HeaderKeys, String> type;
	public static volatile SingularAttribute<HeaderKeys, String> value;
	public static volatile SingularAttribute<HeaderKeys, String> key;

	public static final String HEADER = "header";
	public static final String ID = "id";
	public static final String TYPE = "type";
	public static final String VALUE = "value";
	public static final String KEY = "key";

}

