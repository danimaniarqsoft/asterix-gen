package com.danimaniarqsoft.asterix.maven;

import java.io.File;

public class MavenPom {

    /**
     * Variables referentes al proyecto
     */

    private File rootPath;
    private File pomPath;

    /**
     * Variables referentes al POM
     */
    private String groupId;
    private String artifactId;
    private String packaging;
    private String version;
    private String name;

    private File webPath;
    private File modelPath;
    private File servicePath;
    private File persistencePath;
    private File utilPath;

    public String getBasePackage() {
        return getGroupId() + File.separatorChar + getArtifactId()
                + File.separatorChar;
    }

	public File getRootPath() {
		return rootPath;
	}

	public void setRootPath(File rootPath) {
		this.rootPath = rootPath;
	}

	public File getPomPath() {
		return pomPath;
	}

	public void setPomPath(File pomPath) {
		this.pomPath = pomPath;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getArtifactId() {
		return artifactId;
	}

	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}

	public String getPackaging() {
		return packaging;
	}

	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public File getWebPath() {
		return webPath;
	}

	public void setWebPath(File webPath) {
		this.webPath = webPath;
	}

	public File getModelPath() {
		return modelPath;
	}

	public void setModelPath(File modelPath) {
		this.modelPath = modelPath;
	}

	public File getServicePath() {
		return servicePath;
	}

	public void setServicePath(File servicePath) {
		this.servicePath = servicePath;
	}

	public File getPersistencePath() {
		return persistencePath;
	}

	public void setPersistencePath(File persistencePath) {
		this.persistencePath = persistencePath;
	}

	public File getUtilPath() {
		return utilPath;
	}

	public void setUtilPath(File utilPath) {
		this.utilPath = utilPath;
	}
}
