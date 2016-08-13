package com.danimaniarqsoft.asterix.commands;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import com.danimaniarqsoft.asterix.core.operations.AbstractCommandOperation;
import com.danimaniarqsoft.asterix.domain.AsterixContext;
import com.danimaniarqsoft.asterix.domain.DomainElement;
import com.danimaniarqsoft.asterix.util.AsterixContextFactory;
import com.danimaniarqsoft.asterix.util.AsterixUtils;
import com.danimaniarqsoft.asterix.validators.MavenLayerValidator;

/**
 * Comando encargado de generar código para Prime Faces
 * 
 * @author Daniel Pichardo
 * 
 */

@Component
public class ScaffoldingCommand implements CommandMarker {

	@Autowired
	@Qualifier("selectOneMenuOperation")
	private AbstractCommandOperation operation;

	@Autowired
	private MavenLayerValidator mavenValidator;

	@CliAvailabilityIndicator({ "scaffolding full" })
	public boolean isFullAvailable() {
		return mavenValidator.validateLayer().isEmpty();
	}

	@CliCommand(value = "scaffolding full", help = "Crea un scaffolding basado en una clase de dominio")
	public String scaffoldingFull(
			@CliOption(key = { "",
					"model" }, mandatory = true, help = "clase de dominio a partir de la cual se genera su CRUD") final DomainElement domainElement)
			throws IOException {

		AsterixContext context = AsterixContextFactory.buildScaffoldingContext(domainElement);
		return AsterixUtils.processCommand(operation, context);
	}
}
