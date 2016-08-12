package com.danimaniarqsoft.asterix.commands;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.stereotype.Component;

import com.danimaniarqsoft.asterix.core.LayerInspector;

/**
 * Comando encargado de generar el código de PrimeFaces
 * 
 * @author Daniel Pichardo
 * 
 */

@Component
public class UtilCommand implements CommandMarker {

    @Autowired
    private LayerInspector layerInspector;

    @CliAvailabilityIndicator({ "find" })
    public boolean isSimpleAvailable() {
        return true;
    }
}
