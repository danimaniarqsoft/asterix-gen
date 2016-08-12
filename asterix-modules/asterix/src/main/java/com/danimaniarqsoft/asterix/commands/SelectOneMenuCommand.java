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
import com.danimaniarqsoft.asterix.domain.ManagedBeanElement;
import com.danimaniarqsoft.asterix.domain.DomainElement;
import com.danimaniarqsoft.asterix.util.AsterixContextFactory;
import com.danimaniarqsoft.asterix.util.AsterixUtils;
import com.danimaniarqsoft.asterix.validators.MavenLayerValidator;

/**
 * Comando encargado de generar el código de PrimeFaces
 * 
 * @author Daniel Pichardo
 * 
 */

@Component
public class SelectOneMenuCommand implements CommandMarker {

    @Autowired
    @Qualifier("selectOneMenuOperation")
    private AbstractCommandOperation operation;

    @Autowired
    private MavenLayerValidator mavenValidator;

    @CliAvailabilityIndicator({ "selectOneMenu simple" })
    public boolean isSimpleAvailable() {
        return mavenValidator.validateLayer().isEmpty();
    }

    @CliCommand(value = "selectOneMenu simple", help = "Crea un selectOneMenu basado en una clase de modelo")
    public String selectOneMenuSimple(
            @CliOption(key = { "", "model" }, mandatory = true, help = "clase de modelo a partir de la cual se genera el selecOneMenu") final DomainElement modelTarget,
            @CliOption(key = { "", "managedBean" }, mandatory = true, help = "clase de modelo a partir de la cual se genera el selecOneMenu") final ManagedBeanElement managedBeanTarget)
            throws IOException {

        AsterixContext context = AsterixContextFactory
                .buildSelectOneMenuSimpleContext(managedBeanTarget, modelTarget);
        return AsterixUtils.processCommand(operation, context);
    }
}
