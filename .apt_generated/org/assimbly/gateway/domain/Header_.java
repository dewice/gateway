package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Header.class)
public abstract class Header_ {

	public static volatile SingularAttribute<Header, String> name;
	public static volatile SingularAttribute<Header, Long> id;
	public static volatile SetAttribute<Header, HeaderKeys> headerKeys;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String HEADER_KEYS = "headerKeys";

}

