package com.danimaniarqsoft.asterix.maven;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.apache.maven.project.MavenProject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danimaniarqsoft.asterix.core.operations.AbstractCommandOperation;
import com.danimaniarqsoft.asterix.javaparser.util.FileUtil;

@Slf4j
public class MavenFile {
	private static final Logger LOGGER = LoggerFactory.getLogger(MavenFile.class);


    public final static String SRC_PATH = "src" + File.separator + "main"
            + File.separator + "java" + File.separator;

    protected MavenPom mavenPom;

    public MavenFile() {
        mavenPom = new MavenPom();
        mavenPom.setRootPath(new File(System.getProperty("user.dir")));
        mavenPom.setPomPath(new File(mavenPom.getRootPath(), "pom.xml"));
        initMavenApi(mavenPom);
        LOGGER.debug("ROOT FILE: {}", mavenPom.getRootPath().getAbsolutePath());
        LOGGER.debug("POM FILE: {}", mavenPom.getPomPath().getAbsolutePath());
    }

    private void initMavenApi(MavenPom mavenPom) {
        Model model = null;
        FileReader reader = null;
        MavenXpp3Reader mavenreader = new MavenXpp3Reader();
        try {
            reader = new FileReader(mavenPom.getPomPath());
            model = mavenreader.read(reader);
        } catch (Exception ex) {

        } finally {
            FileUtil.close(reader);
        }

        buildMavenPom(new MavenProject(model), mavenPom);
    }

    private MavenPom buildMavenPom(MavenProject mavenProject, MavenPom mavenPom) {
        mavenPom.setArtifactId(convertDotForFileSeparator(mavenProject
                .getArtifactId()));
        mavenPom.setGroupId(convertDotForFileSeparator(mavenProject
                .getGroupId()));
        mavenPom.setName(convertDotForFileSeparator(mavenProject.getName()));
        mavenPom.setPackaging(convertDotForFileSeparator(mavenProject
                .getPackaging()));
        mavenPom.setVersion(convertDotForFileSeparator(mavenProject
                .getVersion()));
        return mavenPom;
    }

    private String convertDotForFileSeparator(String dotPath) {
        return dotPath.replaceAll("\\.", File.separatorChar + "");
    }
}
