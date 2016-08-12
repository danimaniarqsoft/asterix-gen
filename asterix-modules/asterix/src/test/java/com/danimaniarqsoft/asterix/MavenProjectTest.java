package com.danimaniarqsoft.asterix;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.danimaniarqsoft.asterix.core.operations.AbstractCommandOperation;
import com.danimaniarqsoft.asterix.maven.MavenProject;
import com.danimaniarqsoft.asterix.util.AbstractTest;


public class MavenProjectTest extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(MavenProjectTest.class);

	@Autowired
	private MavenProject mavenFile;

	@Test
	public void mavenFile() {
		LOGGER.info("Es proyecto maven? : {}", mavenFile.isMavenProject());
		LOGGER.info("capa Web: {}", mavenFile.getWebPath().exists());
		LOGGER.info("capa Model: {}", mavenFile.getModelPath().exists());
		LOGGER.info("capa Service: {}", mavenFile.getServicePath().exists());
		LOGGER.info("capa Persistence: {}", mavenFile.getPersistencePath()
				.exists());
		LOGGER.info("list capa Model: {}", mavenFile.getModelPath().list());
	}
}
