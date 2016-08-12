package com.danimaniarqsoft.asterix.template.freemaker;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

@Service
public class FreemarkerTemplateEngine {

    private Configuration configuration;

    @PostConstruct
    public void init() throws Exception {
        configuration = new Configuration();
        configuration.setClassForTemplateLoading(getClass(), "/");
        // Se especifica la manera en que los template procesarán el modelo de
        // datos
        configuration.setObjectWrapper(new DefaultObjectWrapper());

        // Se configura el charset con el que se leerán los templates
        configuration.setDefaultEncoding("UTF-8");

        // Sets how errors will appear. Here we assume we are developing HTML
        // pages.
        // For production systems TemplateExceptionHandler.RETHROW_HANDLER is
        // better.
        configuration
                .setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // At least in new projects, specify that you want the fixes that aren't
        // 100% backward compatible too (these are very low-risk changes as far
        // as the
        // 1st and 2nd version number remains):
        configuration.setIncompatibleImprovements(new Version(2, 3, 20)); // FreeMarker
                                                                          // 2.3.20
    }

    public Template getTemplate(String template) throws IOException {
        return configuration.getTemplate("META-INF/velocity/templates/"
                + template);
    }
}
