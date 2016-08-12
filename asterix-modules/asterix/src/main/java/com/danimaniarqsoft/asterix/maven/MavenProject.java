package com.danimaniarqsoft.asterix.maven;

import java.io.File;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MavenProject extends MavenFile {

    @Autowired
    private MavenProperties mavenProperties;

    @PostConstruct
    public void init() {
        mavenPom.setWebPath(new File(mavenPom.getRootPath(), SRC_PATH
                + mavenPom.getBasePackage() + mavenProperties.getWebName()));
        mavenPom.setModelPath(new File(mavenPom.getRootPath(), SRC_PATH
                + mavenPom.getBasePackage() + mavenProperties.getModelName()));
        mavenPom.setServicePath(new File(mavenPom.getRootPath(), SRC_PATH
                + mavenPom.getBasePackage() + mavenProperties.getServiceName()));
        mavenPom.setPersistencePath(new File(mavenPom.getRootPath(), SRC_PATH
                + mavenPom.getBasePackage()
                + mavenProperties.getPersistenceName()));
        mavenPom.setUtilPath(new File(mavenPom.getRootPath(), SRC_PATH
                + mavenPom.getBasePackage() + mavenProperties.getUtilName()));
    }

    public boolean isMavenProject() {
        return mavenPom.getPomPath().exists();
    }

    public File getWebPath() {
        return mavenPom.getWebPath();
    }

    public File getModelPath() {
        return mavenPom.getModelPath();
    }

    public File getServicePath() {
        return mavenPom.getServicePath();
    }

    public File getPersistencePath() {
        return mavenPom.getPersistencePath();
    }

    public File getUtilPath() {
        return mavenPom.getUtilPath();
    }

    public String getMvnCoordinates() {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupId: ").append(mavenPom.getGroupId()).append("\n");
        sb.append("ArtifactId: ").append(mavenPom.getArtifactId()).append("\n");
        sb.append("Version: ").append(mavenPom.getVersion()).append("\n");
        return sb.toString().replace(File.separatorChar, '.');
    }
}
