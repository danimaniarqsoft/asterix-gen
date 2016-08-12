package com.danimaniarqsoft.asterix.maven;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MavenProperties {

	@Value("${maven.package.model}")
	private String modelName;

	@Value("${maven.package.web}")
	private String webName;

	@Value("${maven.package.service}")
	private String serviceName;

	@Value("${maven.package.persistence}")
	private String persistenceName;

	@Value("${maven.package.util}")
	private String utilName;

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getWebName() {
		return webName;
	}

	public void setWebName(String webName) {
		this.webName = webName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getPersistenceName() {
		return persistenceName;
	}

	public void setPersistenceName(String persistenceName) {
		this.persistenceName = persistenceName;
	}

	public String getUtilName() {
		return utilName;
	}

	public void setUtilName(String utilName) {
		this.utilName = utilName;
	}

}
