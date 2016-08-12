package com.danimaniarqsoft.asterix.faces.templates;

import java.io.IOException;
import java.io.StringWriter;

import lombok.extern.log4j.Log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.danimaniarqsoft.asterix.core.operations.AbstractCommandOperation;
import com.danimaniarqsoft.asterix.domain.FacesComponente;
import com.danimaniarqsoft.asterix.template.freemaker.FreemarkerTemplateEngine;
import com.danimaniarqsoft.asterix.template.freemaker.SelectOneMenuDM;

import freemarker.template.Template;
import freemarker.template.TemplateException;

@Log4j
@Component
public class FacesTemplateFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractCommandOperation.class);

    @Autowired
    private FreemarkerTemplateEngine templateEngine;

    public String buildFacesComponent(FacesComponente facesComponente) {
        switch (facesComponente.getTypeOfComponent()) {
        case SELECT_ONE_MENU_SIMPLE:
            return createSelectOneMenu(facesComponente);
        default:
            throw new UnsupportedOperationException("Método no existente");
        }
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
