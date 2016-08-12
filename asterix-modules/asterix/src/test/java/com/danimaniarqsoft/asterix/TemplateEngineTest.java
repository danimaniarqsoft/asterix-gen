package com.danimaniarqsoft.asterix;

import java.io.StringWriter;

import lombok.extern.slf4j.Slf4j;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.danimaniarqsoft.asterix.core.operations.AbstractCommandOperation;
import com.danimaniarqsoft.asterix.template.velocity.TemplateEngine;
import com.danimaniarqsoft.asterix.util.AbstractTest;

public class TemplateEngineTest extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(TemplateEngineTest.class);

	@Autowired
	private TemplateEngine vtemplateEngine;
	
	@Test(enabled=false)
	public void velocityTemplateEngineTest() throws ResourceNotFoundException,
			ParseErrorException, Exception {
		Template t;
		VelocityContext context = new VelocityContext();
		StringWriter writer = new StringWriter();
		try {
			t = vtemplateEngine.getTemplate("selectOneMenu.xhtml");
			context.put("id", "id");
			context.put("modelSelected", "usuarioSelected");
			context.put("modelList", "usuarioList");
			t.merge(context, writer);
		} catch (ResourceNotFoundException e) {
			LOGGER.error("Recurso no encontrado",e);
		} catch (ParseErrorException e) {
		    LOGGER.error("ParseError",e);
		} catch (Exception e) {
		    LOGGER.error("Exception",e);
		}
		LOGGER.info("\n"+writer.toString());
	}
}
