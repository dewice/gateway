package org.assimbly.gateway.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.json.JSONPropertyIgnore;


@Entity
@Table(name = "deployment")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Deployment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Transient
	private final String apiVersion = "apps/v1";
	
	@Transient
	private final String kind = "Deployment";
	
	@Transient
	private Map<String, String> metadata = new HashMap<String, String>();
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column(name = "name")
    private String name;
    
    @Transient
	private String url;
	
	public Deployment() {}
	
	@Transient
	@SuppressWarnings("unchecked")
	private Map<String, Object> spec = new HashMap<String, Object>() {{		
		put("selector", new HashMap<String, Object>() {{
			put("matchLabels", new HashMap<String, Object>());
		}});
		put("template", new HashMap<String, Object>() {{
			put("metadata", new HashMap<String, Object>() {{
				put("labels", new HashMap<String, Object>());
			}});
			put("spec", new HashMap<String, Object>() {{
				put("containers", new ArrayList<HashMap<String, Object>>(){{
					add(new HashMap<String, Object>() {{
						put("command", new ArrayList<String>() {{
							add("java");
						}});
					}});
				}});
			}});
		}});
	}};
	
	@Transient
	private List<String> args = new ArrayList<String>() {{
		add("-jar");
		add("/home/connector-1.0-SNAPSHOT.jar");
		add("--spring.main.lazy-initialization=true");
        add("-Xverify:none");
        add("--spring.main.banner-mode=OFF");
        add("-noverify");
		add("-XX:+UnlockExperimentalVMOptions");
		add("-XX:+UseCGroupMemoryLimitForHeap");
		add("--spring.cloud.config.uri=http://admin:admin@10.102.230.214:8761/config");
		add("--eureka.client.serviceUrl.defaultZone=http://admin:admin@10.102.230.214:8761/eureka/");
		add("--spring.config.location=classpath:/config/application.yml,classpath:/config/application-dev.yml,classpath:/config/bootstrap.yml");
	}};
	
	@Transient
	public String getApiVersion() {
		return apiVersion;
	}
	
	@Transient
	public String getKind() {
		return kind;
	}
	
	public void setMetaData(Map<String, String> metadata) {
		this.metadata = metadata;
	}
	
	public void addMetaData(String key, String value) {
		Object add = metadata.get(key) != null ? metadata.replace(key, value) : metadata.put(key, value);
	}
	
	@Transient
	public Map<String, String> getMetadata() {
		return metadata;
	}
	
	@Transient
	public Map<String, Object> getSpec() {
		return this.spec;
	}
	
	@Transient
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> getNestedSpec() {
		HashMap<String, Object> template = (HashMap<String, Object>) this.spec.get("template");
		return (HashMap<String, Object>) template.get("spec");
	}
	
	@Transient
	@SuppressWarnings("unchecked")
	public ArrayList<HashMap<String, Object>> getContainer() {
		HashMap<String, Object> spec = getNestedSpec();
		return (ArrayList<HashMap<String, Object>>) spec.get("containers");
	}
	
	public void addToSpec(String key, Object value) {
		HashMap<String, Object> spec = getNestedSpec();
		
		Object add = spec.get(key) != null ? spec.replace(key, value) : spec.put(key, value);
	}
	
	public void addToContainers(String key, Object value) {
		ArrayList<HashMap<String, Object>> containers = getContainer();
		HashMap<String, Object> keyValues = containers.get(0);
		
		Object add = keyValues.get(key) != null ? keyValues.replace(key, value) : keyValues.put(key, value);
	}
	
	public void deleteFromContainers(String key) {
		ArrayList<HashMap<String, Object>> containers = getContainer();
		HashMap<String, Object> keyValues = containers.get(0);
		
		keyValues.remove(key);
	}
	
	@SuppressWarnings("unchecked")
	public void addToMatchLabels(String key, Object value) {
		HashMap<String, Object> selector = (HashMap<String, Object>) this.spec.get("selector");
		HashMap<String, Object> matchlabels = (HashMap<String, Object>) selector.get("matchLabels");
		
		Object add = matchlabels.get(key) != null ? matchlabels.replace(key, value) : matchlabels.put(key, value);
	}
	
	@SuppressWarnings("unchecked")
	public void addToLabels(String key, Object value) {
		HashMap<String, Object> template = (HashMap<String, Object>) this.spec.get("template");
		HashMap<String, Object> matchlabels = (HashMap<String, Object>) template.get("metadata");
		HashMap<String, Object> labels = (HashMap<String, Object>) matchlabels.get("labels");
	
		Object add = labels.get(key) != null ? labels.replace(key, value) : labels.put(key, value);
		
	}
	
	@SuppressWarnings("unchecked")
	public void addVolumeProperties(String name, String mountPath) {
		addToContainers("volumeMounts", new ArrayList<HashMap<String, Object>>(){{
			add(new HashMap<String, Object>() {{
				put("name", name);
				put("mountPath", mountPath);
			}});
		}});
	}
	
	@SuppressWarnings("unchecked")
	public void addVolume(String name, String path) {
		addToSpec("volumes", new ArrayList<HashMap<String, Object>>(){{
			add(new HashMap<String, Object>() {{
				put("name", name);
				put("hostPath", new HashMap<String, Object>() {{ 
					put("path", path);
				}});
			}});
		}});
	}
	
	public void setSpec(String key, Object value) {
		spec.put(key, value);
	}
	
	@JSONPropertyIgnore
	@Transient
	public List<String> getArgs() {
		return args;
	}
	
	public void setArgs(List<String> args) {
		this.args = args;
	}
	
	public void addArgs(String arg) {
		Object add = this.args.contains(arg) ? this.args.set(args.indexOf(arg), arg) : this.args.add(arg);
	}
	
	public void updateArgs() {
		deleteFromContainers("args");
		addToContainers("args", getArgs());
	}
	
	public void removeArg(String arg) {
		this.args.remove(arg);
	}
	
	@JSONPropertyIgnore
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void updateName() {
		addToLabels("app", name);
		addToMatchLabels("app", name);
		addMetaData("name", name);
		addToContainers("name", name);
		addArgs("--eureka.instance.appname=" + name);
		addArgs("--spring.application.name=" + name);
	}
	
	@SuppressWarnings("unchecked")
	public void setPort(int port) {
		addToContainers("ports", new ArrayList<HashMap<String, Object>>(){{
			add(new HashMap<String, Object>() {{
				put("containerPort", port);
			}});
		}});
	}
	
	@JSONPropertyIgnore
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@JSONPropertyIgnore
	@Transient
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	@Transient
	public String toString() {
		return this.name;
	}
}
