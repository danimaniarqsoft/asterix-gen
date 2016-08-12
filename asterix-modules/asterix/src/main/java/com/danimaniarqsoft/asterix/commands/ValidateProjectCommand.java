package com.danimaniarqsoft.asterix.commands;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.stereotype.Component;

import com.danimaniarqsoft.asterix.maven.MavenProject;
import com.danimaniarqsoft.asterix.validators.MavenLayerValidator;
import com.danimaniarqsoft.asterix.validators.MessageBuilder;

/**
 * Comando encargado de generar el código de PrimeFaces
 * 
 * @author Daniel Pichardo
 * 
 */
@Component
public class ValidateProjectCommand implements CommandMarker {

    @Autowired
    private MavenProject mavenProject;

    @Autowired
    private MavenLayerValidator mavenValidator;

    @CliAvailabilityIndicator({ "validate", "mvninfo" })
    public boolean isValidateAvailable() {
        // siempre disponible
        return true;
    }

    @CliCommand(value = "validate", help = "valida que el proyecto cumpla con la estructura Mínima para operar")
    public String validate() {
        ArrayList<Integer> errores = mavenValidator.validateLayer();
        String mensaje = mavenValidator.validateLayer().isEmpty() ? "El proyecto es correcto!!"
                : MessageBuilder.createMessage(errores);
        return mensaje;
    }

    @CliCommand(value = "mvninfo", help = "llee la información del pom.xml")
    public String projectInfo() {
        return mavenProject.getMvnCoordinates();
    }
}
