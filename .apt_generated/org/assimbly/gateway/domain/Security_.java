package org.assimbly.gateway.domain;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Security.class)
public abstract class Security_ {

	public static volatile SingularAttribute<Security, String> certificateName;
	public static volatile SingularAttribute<Security, Long> id;
	public static volatile SingularAttribute<Security, String> certificateFile;
	public static volatile SingularAttribute<Security, String> url;
	public static volatile SingularAttribute<Security, Instant> certificateExpiry;

	public static final String CERTIFICATE_NAME = "certificateName";
	public static final String ID = "id";
	public static final String CERTIFICATE_FILE = "certificateFile";
	public static final String URL = "url";
	public static final String CERTIFICATE_EXPIRY = "certificateExpiry";

}

