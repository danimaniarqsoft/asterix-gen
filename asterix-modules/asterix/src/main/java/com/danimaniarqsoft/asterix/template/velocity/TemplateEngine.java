package com.danimaniarqsoft.asterix.template.velocity;

import java.util.Properties;

import javax.annotation.PostConstruct;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class TemplateEngine {

    private VelocityEngine velocityEngine;

    @PostConstruct
    public void init() throws Exception {
        /*
         * Cargamos las configuraciones de velocity desde un archivo de
         * propiedades
         */
        Properties properties = new Properties();
        properties
                .load(TemplateEngine.class
                        .getResourceAsStream("/META-INF/velocity/velocity_engine.properties"));
        /* Obtenemos e inicializamos el motor de Velocity */
        velocityEngine = new VelocityEngine(properties);
        velocityEngine.init();
    }

    public Template getTemplate(String template)
            throws ResourceNotFoundException, ParseErrorException, Exception {
        return velocityEngine.getTemplate("/META-INF/velocity/templates/"
                + template);
    }
}
