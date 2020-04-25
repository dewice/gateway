package org.assimbly.gateway.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONPropertyIgnore;

public class Deployment {
	private final String apiVersion = "apps/v1";
	private final String kind = "Deployment";
	private Map<String, String> metadata = new HashMap<String, String>();
	private String name;
	private String url;
	private int id;
	
	public Deployment(int flowId) {
		this.setId(flowId);
	}

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
	
	private List<String> args = new ArrayList<String>() {{
		add("-jar");
		add("/home/connector-0.0.1-SNAPSHOT.jar");
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

	public String getApiVersion() {
		return apiVersion;
	}
	
	public String getKind() {
		return kind;
	}
	
	public void setMetaData(Map<String, String> metadata) {
		this.metadata = metadata;
	}
	
	public void addMetaData(String key, String value) {
		Object add = metadata.get(key) != null ? metadata.replace(key, value) : metadata.put(key, value);
	}
	
	public Map<String, String> getMetadata() {
		return metadata;
	}
	
	public Map<String, Object> getSpec() {
		return this.spec;
	}
	
	public void addToContainers(String key, Object value) {
		HashMap<String, Object> template = (HashMap<String, Object>) this.spec.get("template");
		HashMap<String, Object> spec = (HashMap<String, Object>) template.get("spec");
		ArrayList<HashMap<String, Object>> containers = (ArrayList<HashMap<String, Object>>) spec.get("containers");
		HashMap<String, Object> keyValues = containers.get(0);
		
		Object add = keyValues.get(key) != null ? keyValues.replace(key, value) : keyValues.put(key, value);
	}
	
	public void deleteFromContainers(String key) {
		HashMap<String, Object> template = (HashMap<String, Object>) this.spec.get("template");
		HashMap<String, Object> spec = (HashMap<String, Object>) template.get("spec");
		ArrayList<HashMap<String, Object>> containers = (ArrayList<HashMap<String, Object>>) spec.get("containers");
		HashMap<String, Object> keyValues = containers.get(0);
		
		keyValues.remove(key);
	}
	
	public void addToMatchLabels(String key, Object value) {
		HashMap<String, Object> selector = (HashMap<String, Object>) this.spec.get("selector");
		HashMap<String, Object> matchlabels = (HashMap<String, Object>) selector.get("matchLabels");
		
		Object add = matchlabels.get(key) != null ? matchlabels.replace(key, value) : matchlabels.put(key, value);
	}
	
	public void addToLabels(String key, Object value) {
		HashMap<String, Object> template = (HashMap<String, Object>) this.spec.get("template");
		HashMap<String, Object> matchlabels = (HashMap<String, Object>) template.get("metadata");
		HashMap<String, Object> labels = (HashMap<String, Object>) matchlabels.get("labels");
	
		Object add = labels.get(key) != null ? labels.replace(key, value) : labels.put(key, value);
		
	}
	
	public void setSpec(String key, Object value) {
		spec.put(key, value);
	}
	
	@JSONPropertyIgnore
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
	
	public void setPort(int port) {
		addToContainers("ports", new ArrayList<HashMap<String, Object>>(){{
			add(new HashMap<String, Object>() {{
				put("containerPort", port);
			}});
		}});
	}
	
	@JSONPropertyIgnore
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	@JSONPropertyIgnore
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
