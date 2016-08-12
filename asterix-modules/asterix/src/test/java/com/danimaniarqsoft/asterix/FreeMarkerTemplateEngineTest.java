package com.danimaniarqsoft.asterix;

import java.io.OutputStreamWriter;
import java.io.Writer;

import lombok.extern.slf4j.Slf4j;

import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.danimaniarqsoft.asterix.template.freemaker.FreemarkerTemplateEngine;
import com.danimaniarqsoft.asterix.template.freemaker.SelectOneMenuDM;
import com.danimaniarqsoft.asterix.util.AbstractTest;

import freemarker.template.Template;

@Slf4j
public class FreeMarkerTemplateEngineTest extends AbstractTest {
    
	@Autowired
	private FreemarkerTemplateEngine fTemplateEngine;
	
	@Test(enabled=true)
	public void freemarkerTemplateEngineTest() throws ResourceNotFoundException,
			ParseErrorException, Exception {
        SelectOneMenuDM selectOneMenu = new SelectOneMenuDM();
        selectOneMenu.setComponentId("id");
        selectOneMenu.setComponentName("Usuario");
        selectOneMenu.setSelectItems("usuarioList");
        selectOneMenu.setValue("usuarioSelected");
        /* Get the template */
        Template temp = fTemplateEngine.getTemplate("selectOneMenu.xhtml");
        
        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        temp.process(selectOneMenu, out);
	}
}
