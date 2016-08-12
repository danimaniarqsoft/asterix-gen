package com.danimaniarqsoft.asterix.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danimaniarqsoft.asterix.maven.MavenProject;

@Service
public class ModelOperationsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(ModelOperationsService.class);

	@Autowired
	private MavenProject mavenProject;

	public String showModelList() {
		LOGGER.info(mavenProject.getModelPath().getAbsolutePath());
		StringBuilder sb = new StringBuilder();
		for (String file : mavenProject.getModelPath().list()) {
			sb.append(file);
			sb.append("\n");
		}
		return sb.toString();
	}
}
