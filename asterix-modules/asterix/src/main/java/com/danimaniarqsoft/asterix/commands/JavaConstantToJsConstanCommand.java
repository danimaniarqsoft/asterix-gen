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
import com.danimaniarqsoft.asterix.domain.JavaConstantClassTarget;
import com.danimaniarqsoft.asterix.util.AsterixContextFactory;
import com.danimaniarqsoft.asterix.util.AsterixUtils;
import com.danimaniarqsoft.asterix.validators.MavenLayerValidator;

/**
 * Comando encargado de crear la conversión de una clase de constantes a un
 * archivo javascript de constantes
 * 
 * @author Daniel Pichardo
 * 
 */

@Component
public class JavaConstantToJsConstanCommand implements CommandMarker {

    @Autowired
    @Qualifier("javaToJavaScriptOperation")
    private AbstractCommandOperation operation;
    @Autowired
    private MavenLayerValidator mavenValidator;

    @CliAvailabilityIndicator({ "convert javaFileTo jsFile" })
    public boolean isSimpleAvailable() {
        return mavenValidator.validateLayer().isEmpty();
    }

    @CliCommand(value = "convert javaFileTo jsFile", help = "Crea un archivo Js con las constantes descritas en el archivo Java")
    public String selectOneMenuSimple(
            @CliOption(key = { "", "javaFile" }, mandatory = true, help = "Archivo Java con las constantes a Mappear") final JavaConstantClassTarget javaConstantClassTarget)
            throws IOException {
        AsterixContext context = AsterixContextFactory
                .buildJavaToJavascriptContext(javaConstantClassTarget);
        return AsterixUtils.processCommand(operation, context);
    }
}
