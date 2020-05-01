package org.assimbly.gateway.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Group.class)
public abstract class Group_ {

	public static volatile SingularAttribute<Group, String> name;
	public static volatile SingularAttribute<Group, Long> id;
	public static volatile SetAttribute<Group, User> users;

	public static final String NAME = "name";
	public static final String ID = "id";
	public static final String USERS = "users";

}

