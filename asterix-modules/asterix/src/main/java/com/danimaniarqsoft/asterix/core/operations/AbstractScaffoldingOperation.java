package com.danimaniarqsoft.asterix.core.operations;

import com.github.javaparser.ParseException;

import java.io.FileNotFoundException;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.danimaniarqsoft.asterix.domain.AsterixScaffoldingContext;
import com.danimaniarqsoft.asterix.maven.MavenProject;
import com.danimaniarqsoft.asterix.services.TemplateService;

/**
 * 
 * @author Daniel Cortes Pichardo
 *
 */

public class AbstractScaffoldingOperation {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCommandOperation.class);

	@Autowired
	protected TemplateService templateService;

	@Autowired
	protected MavenProject mavenProject;

	public void processCommand(AsterixScaffoldingContext context) throws FileNotFoundException, ParseException {
		parsePersistenceLayer(context);
	}

	protected void parsePersistenceLayer(AsterixScaffoldingContext context) {
		LOGGER.debug("Parseando la capa de persistencia");
	}

}
