package com.danimaniarqsoft.asterix.uiconsole;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.HistoryFileNameProvider;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Daniel Pichardo
 * 
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AsterixHistoryFileName implements HistoryFileNameProvider {

    @Value("${asterix.log.name}")
    private String logFileName;

    public String name() {
        return "Nombre para el archivo log";
    }

    @Override
    public String getHistoryFileName() {
        return logFileName;
    }

    public String getProviderName() {
        return "Nombre para el archivo log";
    }
}
