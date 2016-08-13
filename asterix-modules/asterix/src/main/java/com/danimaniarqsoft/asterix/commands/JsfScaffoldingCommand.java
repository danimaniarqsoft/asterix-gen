package com.danimaniarqsoft.asterix.commands;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
public class JsfScaffoldingCommand extends Command {

	@Autowired
	public JsfScaffoldingCommand(@Qualifier("selectOneMenuOperation") AbstractCommandOperation operation) {
		this.operation = operation;
	}

	@CliAvailabilityIndicator({ "jsf scaffolding" })
	public boolean isFullAvailable() {
		return mavenValidator.validateLayer().isEmpty();
	}

	@CliCommand(value = "jsf scaffolding", help = "Construye un cliclo CRUD de la entidad seleccionada")
	public String jsfScaffolding(
			@CliOption(key = { "",
					"model" }, mandatory = true, help = "clase de dominio a partir de la cual se genera su CRUD") final DomainElement domainElement)
			throws IOException {

		AsterixContext context = AsterixContextFactory.buildScaffoldingContext(domainElement);
		return AsterixUtils.processCommand(operation, context);
	}
}
