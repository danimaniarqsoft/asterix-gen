package com.danimaniarqsoft.asterix.core.operations;

import com.github.javaparser.ParseException;

import java.io.FileNotFoundException;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.danimaniarqsoft.asterix.core.ModelOperationsService;
import com.danimaniarqsoft.asterix.domain.AsterixContext;
import com.danimaniarqsoft.asterix.domain.FacesComponente;
import com.danimaniarqsoft.asterix.faces.factory.FacesComponentFactory;
import com.danimaniarqsoft.asterix.faces.templates.FacesTemplateFactory;
import com.danimaniarqsoft.asterix.faces.templates.TypeOfComponent;
import com.danimaniarqsoft.asterix.maven.MavenProject;

@Slf4j
public abstract class AbstractCommandOperation {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCommandOperation.class);

	@Autowired
	protected FacesComponentFactory facesComponentFactory;

	@Autowired
	protected FacesTemplateFactory facesTemplateFactory;

	@Autowired
	protected MavenProject mavenProject;

	public String processCommand(AsterixContext context) throws FileNotFoundException, ParseException {

		parsePersistenceLayer(context);
		parseModelLayer(context);
		parseServiceLayer(context);
		parseUtilLayer(context);
		parseWebLayer(context);
		return buildFrontComponent(context);
	}

	private String buildFrontComponent(AsterixContext context) {
		if (context.getTypeOfComponent().equals(TypeOfComponent.JAVA_TO_JAVASCRIPT)) {
			return context.getJavaScriptConstant();
		} else {
			return buildFacesComponent(context);
		}
	}

	protected void parsePersistenceLayer(AsterixContext context) {
		LOGGER.debug("Parseando la capa de persistencia");
	}

	protected void parseModelLayer(AsterixContext context) {
		LOGGER.debug("Parseando la capa de modelo");
	}

	protected void parseServiceLayer(AsterixContext context) {
		LOGGER.debug("Parseando capa de servicio");
	}

	protected void parseWebLayer(AsterixContext context) throws FileNotFoundException, ParseException {
		LOGGER.debug("Parseando capa web");
	}

	protected void parseUtilLayer(AsterixContext context) {
		LOGGER.debug("Parseando capa Util");
	}

	protected String buildFacesComponent(AsterixContext context) {
		LOGGER.debug("Creando un FacesComponent");
		FacesComponente facesComponent = facesComponentFactory.buildFacesComponent(context);
		return facesTemplateFactory.buildFacesComponent(facesComponent);
	}

}
