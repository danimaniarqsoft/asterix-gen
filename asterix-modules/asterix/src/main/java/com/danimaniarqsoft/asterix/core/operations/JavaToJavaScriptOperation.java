package com.danimaniarqsoft.asterix.core.operations;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danimaniarqsoft.asterix.domain.AsterixContext;
import com.danimaniarqsoft.asterix.domain.JavaConstantClassTarget;
import com.danimaniarqsoft.asterix.javaparser.core.JavaFileContextService;
import com.danimaniarqsoft.asterix.javaparser.core.context.JavaFileContext;

@Service
public class JavaToJavaScriptOperation extends AbstractCommandOperation {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCommandOperation.class);

	@Autowired
	private JavaFileContextService javaFileContextService;

	@Override
	protected void parseUtilLayer(AsterixContext context) {
		LOGGER.debug("Parsing Util Layer");
		super.parseUtilLayer(context);
		// localizar archivo java
		File javaConstantFile = this.mavenProject.getUtilPath();
		JavaConstantClassTarget jConstantClass = context.getJavaConstantClassTarget();
		JavaFileContext pContext = context.getJavaFileContext();
		// Leer archivo de Constantes y crear String con la información Js
		String result = javaFileContextService.convertFromJavaToJavaScript(javaConstantFile, pContext);
		context.setJavaScriptConstant(result);
		LOGGER.debug(result);
	}
}
