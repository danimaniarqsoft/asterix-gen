package com.danimaniarqsoft.asterix.services;

import java.io.IOException;
import java.io.StringWriter;

import lombok.extern.log4j.Log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danimaniarqsoft.asterix.core.operations.AbstractCommandOperation;
import com.danimaniarqsoft.asterix.domain.FacesComponente;
import com.danimaniarqsoft.asterix.template.freemaker.FreemarkerTemplateEngine;
import com.danimaniarqsoft.asterix.template.freemaker.SelectOneMenuDM;
import com.github.javaparser.ast.CompilationUnit;

import freemarker.template.Template;
import freemarker.template.TemplateException;

import com.danimaniarqsoft.asterix.util.TemplateCatalog;

/**
 * 
 * @author Daniel Cortes Pichardo
 *
 */
@Log4j
@Service
public class ScaffoldingTemplateService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCommandOperation.class);

    @Autowired
    private FreemarkerTemplateEngine templateEngine;

    public String buildFacesComponent(CompilationUnit cu) {
        try {
            templateEngine.getTemplate(TemplateCatalog.SELECT_ONE_MENU);
        } catch (IOException e) {
            LOGGER.error("No se logró encontrar el archivo", e);
        }
        return null;
    }

    private String createSelectOneMenu(FacesComponente facesComponente) {
        Template template;
        try (StringWriter writer = new StringWriter()) {
            template = templateEngine.getTemplate("selectOneMenu.xhtml");
            SelectOneMenuDM selectOneMenu = createSelectOneMenuDM(facesComponente);
            template.process(selectOneMenu, writer);
            return writer.toString();
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        } catch (TemplateException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }

    private SelectOneMenuDM createSelectOneMenuDM(
            FacesComponente facesComponente) {
        SelectOneMenuDM selectOneMenu = new SelectOneMenuDM();
        selectOneMenu.setComponentId(facesComponente.getId());
        selectOneMenu.setComponentName(facesComponente.getModelSelected());
        selectOneMenu.setSelectItems(facesComponente.getModelList());
        selectOneMenu.setValue(facesComponente.getModelSelected());
        return selectOneMenu;
    }
}
