package org.assimbly.gateway.domain.enumeration;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The EndpointType enumeration.
 * This is an alpabetic list based on Camel's component reference https://camel.apache.org/components/latest
 */
public enum EndpointType {
	
	ACTIVEMQ("ACTIVEMQ"),
	
	AHC("AHC"),
	
	@JsonProperty("AHC-WS")
	AHCWS("AHC-WS"),
	
	@JsonProperty("AHC-WSS")
	
	AHCWSS("AHC-WSS"),
	
	AMAZONMQ("AMAZONMQ"),
	
	AMQP("AMQP"),
	
	APNS("APNS"),
	
	AS2("AS2"),
	
	ASTERISK("ASTERISK"),
	
	ATMOS("ATMOS"),
	
	@JsonProperty("ATMOSPHERE-WEBSOCKET")
	ATMOSPHEREWEBSOCKET("ATMOSPHERE-WEBSOCKET"),
	
	ATOM("ATOM"),
	
	@JsonProperty("ATOMIX-MAP")
	ATOMIXMAP("ATOMIX-MAP"),
	
	@JsonProperty("ATOMIX-MESSAGING")
	ATOMIXMESSAGING("ATOMIX-MESSAGING"),
	
	@JsonProperty("ATOMIX-MULTIMAP")
	ATOMIXMULTIMAP("ATOMIX-MULTIMAP"),
	
	@JsonProperty("ATOMIX-QUEUE")
	ATOMIXQUEUE("ATOMIX-QUEUE"),
	
	@JsonProperty("ATOMIX-SET")
	ATOMIXSET("ATOMIX-SET"),	
	
	@JsonProperty("ATOMIX-VALUE")
	ATOMIXVALUE("ATOMIX-VALUE"),	
	
	AVRO("AVRO"),
	
	@JsonProperty("AWS-CW")
	AWSCW("AWS-CW"),	

	@JsonProperty("AWS-DDB")
	AWSDDB("AWS-DDB"),	
	
	@JsonProperty("AWS-DDBSTREAM")
	AWSDDBSTREAM("AWS-DDBSTREAM"),	
	
	@JsonProperty("AWS-EC2")
	AWSEC2("AWS-EC2"),
	
	@JsonProperty("AWS-ECS")
	AWSECS("AWS-ECS"),
	
	@JsonProperty("AWS-EKS")
	AWSEKS("AWS-EKS"),	
	
	@JsonProperty("AWS-KMS")
	AWSKMS("AWS-KMS"),	
	
	@JsonProperty("AWS-KINESIS")
	AWSKINESIS("AWS-KINESIS"),	

	@JsonProperty("AWS-KINESIS-FIREHOSE")
	AWSKINESISFIREHOSE("AWS-KINESIS-FIREHOSE"),	

	@JsonProperty("AWS-LAMBDA")
	AWSLAMBDA("AWS-LAMBDA"),	

	@JsonProperty("AWS-MQ")
	AWSMQ("AWS-MQ"),	

	@JsonProperty("AWS-MSK")
	AWSMSK("AWS-MSK"),
	
	@JsonProperty("AWS-S3")
	AWSS3("AWS-S3"),
	
	@JsonProperty("AWS-SDB")
	AWSSDB("AWS-SDB"),
	
	@JsonProperty("AWS-SES")
	AWSSES("AWS-SES"),
	
	@JsonProperty("AWS-SNS")
	AWSSNS("AWS-SNS"),
	
	@JsonProperty("AWS-SQS")
	AWSSQS("AWS-SQS"),
	
	@JsonProperty("AWS-SWF")
	AWSSWF("AWS-SWF"),

	@JsonProperty("AWS-TRANSLATE")
	AWSTRANSLATE("AWS-TRANSLATE"),

	@JsonProperty("AZURE-BLOB")
	AZUREBLOB("AZURE-BLOB"),

	@JsonProperty("AZURE-QUEUE")
	AZUREQUEUE("AZURE-QUEUE"),
	
	@JsonProperty("BEAN-VALIDATOR")
	BEANVALIDATOR("BEAN-VALIDATOR"),

	BEAN("BEAN"),

	CLASS("CLASS"),

	BEANSTALK("BEANSTALK"),
	
	BONITA("BONITA"),

	BOX("BOX"),

	BRAINTREE("BRAINTREE"),

	BROWSE("BROWSE"),

	@JsonProperty("CAFFEINE-CACHE")
	CAFFEINECACHE("CAFFEINE-CACHE"),

	@JsonProperty("CAFFEINE-LOADCACHE")
	CAFFEINELOADCACHE("CAFFEINE-LOADCACHE"),

	CQL("CQL"),

	CHATSCRIPT("CHATSCRIPT"),
	
	CHUNK("CHUNK"),

	@JsonProperty("CM-SMS")
	CMSMS("CM-SMS"),

	CMIS("CMIS"),

	COAP("COAP"),

	COMETD("COMETD"),

	CONSUL("CONSUL"),

	CONTROLBUS("CONTROLBUS"),

	CORDA("CORDA"),
	
	COUCHBASE("COUCHBASE"),
	
	COUCHDB("COUCHDB"),
	
	CRON("CRON"),

	CRYPTO("CRYPTO"),
	
	@JsonProperty("CRYPTO-SMS")
	CRYPTOSMS("CRYPTO-SMS"),

	CXF("CXF"),
	
	CXFRS("CXFRS"),
	
	DATAFORMAT("DATAFORMAT"),

	DATASET("DATASET"),

	@JsonProperty("DATASET-TEST")
	DATASETTEST("DATASET-TEST"),

	@JsonProperty("DEBEZIUM-MONGODB")
	DEBEZIUMMONGODB("DEBEZIUM-MONGODB"),

	@JsonProperty("DEBEZIUM-MYSQL")
	DEBEZIUMMYSQL("DEBEZIUM-MYSQL"),	

	@JsonProperty("DEBEZIUM-POSTGRESQL")
	DEBEZIUMPOSTGRESQL("DEBEZIUM-POSTGRESQL"),

	@JsonProperty("DEBEZIUM-SQLSERVER")
	DEBEZIUMSQLSERVER("DEBEZIUM-SQLSERVER"),
	
	DIGITALOCEAN("DIGITALOCEAN"),

	DIRECT("DIRECT"),
	
	@JsonProperty("DIRECT-VM")
	DIRECTVM("DIRECT-VM"),	

	DISRUPTOR("DISRUPTOR"),
	
	@JsonProperty("DISRUPTOR-VM")
	DISRUPTORVM("DISRUPTOR-VM"),		

	DNS("DNS"),

	DOCKER("DOCKER"),

	DOZER("DOZER"),

	DRILL("DRILL"),

	DROPBOX("DROPBOX"),

	EHCACHE("EHCACHE"),
	
	ELASTICSEARCH("ELASTICSEARCH"),

	@JsonProperty("ELASTICSEARCH-REST")
	ELASTICSEARCHREST("ELASTICSEARCH-REST"),	

	ELSQL("ELSQL"),

	ELYTRON("ELYTRON"),

	ETCD("ETCD"),

	EVENTADMIN("EVENTADMIN"),

	EXEC("EXEC"),

	FACEBOOK("FACEBOOK"),

	FHIR("FHIR"),
	
	FILE("FILE"),

	@JsonProperty("FILE-WATCH")
	FILEWATCH("FILE-WATCH"),	

	FLATPACK("FLATPACK"),

	FLINK("FLINK"),

	FOP("FOP"),
	
	FREEMARKER("FREEMARKER"),
	
	FTP("FTP"),
	
	FTPS("FTPS"),

	GANGLIA("GANGLIA"),

	GEOCODER("GEOCODER"),
	
	GIT("GIT"),
	
	GITHUB("GITHUB"),

	@JsonProperty("GOOGLE-BIGQUERY")
	GOOGLEBIGQUERY("GOOGLE-BIGQUERY"),

	@JsonProperty("GOOGLE-BIGQUERY-SQL")
	GOOGLEBIGQUERYSQL("GOOGLE-BIGQUERY-SQL"),
	
	@JsonProperty("GOOGLE-CALENDAR")
	GOOGLECALENDAR("GOOGLE-CALENDAR"),

	@JsonProperty("GOOGLE-CALENDAR-STREAM")
	GOOGLECALENDARSTREAM("GOOGLE-CALENDAR-STREAM"),

	@JsonProperty("GOOGLE-DRIVE")
	GOOGLEDRIVE("GOOGLE-DRIVE"),

	@JsonProperty("GOOGLE-MAIL")
	GOOGLEMAIL("GOOGLE-MAIL"),

	@JsonProperty("GOOGLE-MAIL-STREAM")
	GOOGLEMAILSTREAM("GOOGLE-MAIL-STREAM"),

	@JsonProperty("GOOGLE-PUBSUB")
	GOOGLEPUBSUB("GOOGLE-PUBSUB"),
	
	@JsonProperty("GOOGLE-SHEETS")
	GOOGLESHEETS("GOOGLE-SHEETS"),

	@JsonProperty("GOOGLE-SHEETS-STREAM")
	GOOGLESHEETSSTREAM("GOOGLE-SHEETS-STREAM"),
	
	GORA("GORA"),

	GRAPE("GRAPE"),

	GRAPHQL("GRAPHQL"),

	GRPC("GRPC"),

	@JsonProperty("GUAVA-EVENTBUS")
	GUAVAEVENTBUS("GUAVA-EVENTBUS"),

	@JsonProperty("HAZELCAST-ATOMICVALUE")
	HAZELCASTATOMICVALUE("HAZELCAST-ATOMICVALUE"),

	@JsonProperty("HAZELCAST-INSTANCE")
	HAZELCASTINSTANCE("HAZELCAST-INSTANCE"),

	@JsonProperty("HAZELCAST-LIST")
	HAZELCASTLIST("HAZELCAST-LIST"),

	@JsonProperty("HAZELCAST-MAP")
	HAZELCASTMAP("HAZELCAST-MAP"),

	@JsonProperty("HAZELCAST-MULTIMAP")
	HAZELCASTMULTIMAP("HAZELCAST-MULTIMAP"),

	@JsonProperty("HAZELCAST-QUEUE")
	HAZELCASTQUEUE("HAZELCAST-QUEUE"),

	@JsonProperty("HAZELCAST-REPLICATEDMAP")
	HAZELCASTREPLICATEDMAP("HAZELCAST-REPLICATEDMAP"),

	@JsonProperty("HAZELCAST-RINGBUFFER")
	HAZELCASTRINGBUFFER("HAZELCAST-RINGBUFFER"),

	@JsonProperty("HAZELCAST-SEDA")
	HAZELCASTSEDA("HAZELCAST-SEDA"),

	@JsonProperty("HAZELCAST-SET")
	HAZELCASTSET("HAZELCAST-SET"),

	@JsonProperty("HAZELCAST-TOPIC")
	HAZELCASTTOPIC("HAZELCAST-TOPIC"),

	HBASE("HBASE"),

	HDFS("HDFS"),

	HIPCHAT("HIPCHAT"),

	HTTP("HTTP"),

	HTTPS("HTTPS"),
	
	@JsonProperty("IEC60870-CLIENT")
	IEC60870CLIENT("IEC60870-CLIENT"),
	
	@JsonProperty("IEC60870-SERVER")
	IEC60870SERVER("IEC60870-SERVER"),
	
	@JsonProperty("IGNITE-CACHE")
	IGNITECACHE("IGNITE-CACHE"),

	@JsonProperty("IGNITE-COMPUTE")
	IGNITECOMPUTE("IGNITE-COMPUTE"),

	@JsonProperty("IGNITE-EVENTS")
	IGNITEEVENTS("IGNITE-EVENTS"),

	@JsonProperty("IGNITE-IDGEN")
	IGNITEIDGEN("IGNITE-IDGEN"),
	
	@JsonProperty("IGNITE-MESSAGING")
	IGNITEMESSAGING("IGNITE-MESSAGING"),
	
	@JsonProperty("IGNITE-QUEUE")
	IGNITEQUEUE("IGNITE-QUEUE"),

	@JsonProperty("IGNITE-SET")
	IGNITESET("IGNITE-SET"),

	IMAP("IMAP"),
	
	IMAPS("IMAPS"),

	INFINISPAN("INFINISPAN"),	

	INFLUXDB("INFLUXDB"),	

	IOTA("IOTA"),	

	IPFS("IPFS"),

	IRC("IRC"),

	IRONMQ("IRONMQ"),

	JBPM("JBPM"),

	JCACHE("JCACHE"),

	JCLOUDS("JCLOUDS"),

	JCR("JCR"),

	JDBC("JDBC"),

	JETTY("JETTY"),

	JGROEPS("JGROEPS"),

	@JsonProperty("JGROEPS-RAFT")
	JGROEPSRAFT("JGROEPS-RAFT"),

	JING("JING"),

	JIRA("JIRA"),

	JMS("JMS"),

	JMX("JMX"),

	JOLT("JOLT"),

	JOOQ("JOOQ"),
	
	JPA("JPA"),

	JSLT("JSLT"),

	@JsonProperty("JSON-VALIDATOR")
	JSONVALIDATOR("JSON-VALIDATOR"),

	JT400("JT400"),

	KAFKA("KAFKA"),

	@JsonProperty("KUBERNETES-CONFIG-MAPS")
	KUBERNETESCONFIGMAPS("KUBERNETES-CONFIG-MAPS"),
	
	@JsonProperty("KUBERNETES-DEPLOYMENTS")
	KUBERNETESDEPLOYMENTS("KUBERNETES-DEPLOYMENTS"),

	@JsonProperty("KUBERNETES-HPA")
	KUBERNETESHPA("KUBERNETES-HPA"),

	@JsonProperty("KUBERNETES-JOB")
	KUBERNETESJOB("KUBERNETES-JOB"),

	@JsonProperty("KUBERNETES-NAMESPACES")
	KUBERNETESNAMESPACES("KUBERNETES-NAMESPACES"),

	@JsonProperty("KUBERNETES-NODES")
	KUBERNETESNODES("KUBERNETES-NODES"),

	@JsonProperty("KUBERNETES-PERSISTENT-VOLUMES")
	KUBERNETESPERSISTENTVOLUMES("KUBERNETES-PERSISTENT-VOLUMES"),
	
	@JsonProperty("KUBERNETES-PERSISTENT-VOLUMES-CLAIM")
	KUBERNETESPERSISTENTVOLUMESCLAIM("KUBERNETES-PERSISTENT-VOLUMES-CLAIM"),

	@JsonProperty("KUBERNETES-PODS")
	KUBERNETESPODS("KUBERNETES-PODS"),

	@JsonProperty("KUBERNETES-REPLICATION-CONTROLLERS")
	KUBERNETESREPLICATIONCONTROLLERS("KUBERNETES-REPLICATION-CONTROLLERS"),

	@JsonProperty("KUBERNETES-RESOURCES-QUOTA")
	KUBERNETESRESOURCESQUOTA("KUBERNETES-RESOURCES-QUOTA"),

	@JsonProperty("KUBERNETES-SECRETS")
	KUBERNETESSECRETS("KUBERNETES-SECRETS"),

	@JsonProperty("KUBERNETES-SERVICE-ACCOUNTS")
	KUBERNETESSERVICEACCOUNTS("KUBERNETES-SERVICE-ACCOUNTS"),
	
	@JsonProperty("KUBERNETES-SERVICES")
	KUBERNETESSERVICES("KUBERNETES-SERVICES"),

	@JsonProperty("OPENSHIFT-BUILDS")
	OPENSHIFTBUILDS("OPENSHIFT-BUILDS"),

	@JsonProperty("OPENSHIFT-BUILD-CONFIGS")
	OPENSHIFTBUILDCONFIGS("OPENSHIFT-BUILD-CONFIGS"),
	
	KUDU("KUDU"),
	
	LANGUAGE("LANGUAGE"),

	LDAP("LDAP"),

	LDIF("LDIF"),
	
	LEVELDB("LEVELDB"),
	
	LOG("LOG"),	

	LUCENE("LUCENE"),	

	LUMBERJACK("LUMBERJACK"),

	MASTER("MASTER"),

	MECTRICS("MECTRICS"),

	MICROMETER("MICROMETER"),

	@JsonProperty("MICROPROFILE-METRICS")
	MICROPROFILEMETRICS("MICROPROFILE-METRICS"),

	@JsonProperty("MILO-CLIENT")
	MILOCLIENT("MILO-CLIENT"),

	@JsonProperty("MILO-SERVER")
	MILOSERVER("MILO-SERVER"),

	MINA("MINA"),

	MLLP("MLLP"),

	MOCK("MOCK"),

	MONGODB("MONGODB"),

	@JsonProperty("MONGODB-GRIDFS")
	MONGODBGRIDFS("MONGODB-GRIDFS"),

	MSV("MSV"),
	
	MUSTACHE("MUSTACHE"),

	MVEL("MVEL"),
	
	MYBATIS("MYBATIS"),	

	@JsonProperty("MYBATIS-BEAN")
	MYBATISBEAN("MYBATIS-BEAN"),

	NAGIOS("NAGIOS"),

	NATS("NATS"),

	NETTY4("NETTY4"),

	@JsonProperty("NETTY-HTTP")
	NETTYHTTP("NETTY-HTTP"),

	NITRITE("NITRITE"),

	NSQ("NSQ"),
	
	OLINGO2("OLINGO2"),
	
	OLINGO4("OLINGO4"),

	@JsonProperty("OPENSTACK-CINDER")
	OPENSTACKCINDER("OPENSTACK-CINDER"),

	@JsonProperty("OPENSTACK-GLANCE")
	OPENSTACKGLANCE("OPENSTACK-GLANCE"),

	@JsonProperty("OPENSTACK-KEYSTONE")
	OPENSTACKKEYSTONE("OPENSTACK-KEYSTONE"),

	@JsonProperty("OPENSTACK-NEUTRON")
	OPENSTACKNEUTRON("OPENSTACK-NEUTRON"),

	@JsonProperty("OPENSTACK-")
	OPENSTACK("OPENSTACK-"),

	@JsonProperty("OPENSTACK-NOVA")
	OPENSTACKNOVA("OPENSTACK-NOVA"),

	@JsonProperty("OPENSTACK-SWIFT")
	OPENSTACKSWIFT("OPENSTACK-SWIFT"),

	OPTAPLANNER("OPTAPLANER"),

	PAHTO("PAHTO"),

	PAXLOGGING("PAXLOGGING"),

	PDF("PDF"),

	@JsonProperty("PG-REPLICATION-SLOT")
	PGREPLICATIONSLOT("PG-REPLICATION-SLOT"),

	PGEVENT("PGEVENT"),

	@JsonProperty("PLATFORM-HTTP")
	PLATFORMHTTP("PLATFORM-HTTP"),

	LPR("LPR"),

	PUBNUB("PUBNUB"),

	PULSAR("PULSAR"),

	QUARTZ("QUARTZ"),

	QUICKFIX("QUICKFIX"),
	
	RABBITMQ("RABBITMQ"),

	@JsonProperty("REACTIVE-STREAMS")
	REACTIVESTREAMS("REACTIVE-STREAMS"),	
	
	REF("REF"),
	
	REST("REST"),

	@JsonProperty("REST-API")
	RESTAPI("REST-API"),	

	@JsonProperty("REST-OPENAPI")
	RESTOPENAPI("REST-OPENAPI"),	
	
	@JsonProperty("REST-SWAGGER")
	RESTSWAGGER("REST-SWAGGER"),	

	RSS("RSS"),

	SAGA("SAGA"),

	SALESFORCE("SALESFORCE"),

	@JsonProperty("SAP-NETWEAVER")
	SAPNETWEAVER("SAP-NETWEAVER"),
	
	SCHEDULER("SCHEDULER"),

	SCHEMATRON("SCHEMATRON"),
	
	SCP("SCP"),

	SEDA("SEDA"),

	SERVICE("SERVICE"),
	
	SERVICENOW("SERVICENOW"),
	
	SERVLET("SERVLET"),

	SFTP("SFTP"),
	
	SIP("SIP"),

	SIPS("SIPS"),

	SJMS("SJMS"),

	SJMS2("SJMS2"),

	SLACK("SLACK"),

	SMMP("SMMP"),

	SMMPS("SMMPS"),

	SNMP("SNMP"),

	SMTP("SMTP"),

	SMTPS("SMTPS"),
	
	SOLR("SOLR"),
	
	SOLRS("SOLRS"),

	SPARK("SPARK"),
	
	@JsonProperty("SPARK-REST")
	SPARKREST("SPARK-REST"),

	SPLUNK("SPLUNK"),

	@JsonProperty("SPRING-BATCH")
	SPRINGBATCH("SPRING-BATCH"),

	@JsonProperty("SPRING-INTEGRATION")
	SPRINGINTEGRATION("SPRING-INTEGRATION"),
	
	@JsonProperty("SPRING-LDAP")
	SPRINGLDAP("SPRING-LDAP"),
	
	@JsonProperty("SPRING-REDIS")
	SPRINGREDIS("SPRING-REDIS"),

	@JsonProperty("SPRING-WS")
	SPRINGWS("SPRING-WS"),

	@JsonProperty("SPRING-EVENT")
	SPRINGEVENT("SPRING-EVENT"),
	
	SQL("SQL"),

	@JsonProperty("SQL-STORED")
	SQLSTORED("SQL-STORED"),

	SSH("SSH"),

	SONICMQ("SONICMQ"),

	STAX("STAX"),

	STOMP("STOMP"),

	STREAM("STREAM"),
	
	STUB("STUB"),
	
	TELEGRAM("TELEGRAM"),

	THRIFT("THRIFT"),

	TIKA("TIKA"),
	
	TIMER("TIMER"),

	TWILIO("TWILIO"),

	@JsonProperty("TWITTER-DIRECTMESSAGE")
	TWITTERDIRECTMESSAGE("TWITTER-DIRECTMESSAGE"),
	
	@JsonProperty("TWITTER-SEARCH")
	TWITTERSEARCH("TWITTER-SEARCH"),

	@JsonProperty("TWITTER-TIMELINE")
	TWITTERTIMELINE("TWITTER-TIMELINE"),

	UNDERTOW("UNDERTOW"),

	VALIDATOR("VALIDATOR"),

	VELOCITY("VELOCITY"),

	VERTX("VERTX"),
	
	VM("VM"),
	
	WASTEBIN("WASTEBIN"),

	WEATHER("WEATHER"),

	WEB3J("WEB3J"),

	WEBHOOK("WEBHOOK"),

	WEBSOCKET("WEBSOCKET"),

	@JsonProperty("WEBSOCKET-JSR")
	WEBSOCKETJSR("WEBSOCKET-JSR"),

	WORDPRESS("WORDPRESS"),
	
	XCHANGE("XCHANGE"),

	XJ("XJ"),

	XMPP("XMPP"),

	XQUERY("XQUERY"),

	XSLT("XSLT"),
	
	@JsonProperty("XSLT-SAXON")
	XSLTSAXON("XSLT-SAXON"),

	YAMMER("YAMMER"),

	ZENDESK("ZENDESK"),

	ZOOKEEPER("ZOOKEEPER"),

	@JsonProperty("ZOOKEEPER-MASTER")
	ZOOKEEPERMASTER("ZOOKEEPER-MASTER");

	
    private String endpoint;
 
    EndpointType(String endpoint) {
        this.endpoint = endpoint;
    }
 
    public String getEndpoint() {
        return endpoint;
    }
	
	
}
