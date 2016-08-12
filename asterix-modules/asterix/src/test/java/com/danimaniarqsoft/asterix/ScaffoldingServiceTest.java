package com.danimaniarqsoft.asterix;

import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;

import lombok.extern.slf4j.Slf4j;

import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.danimaniarqsoft.asterix.domain.scaffolding.ScaffoldingContext;
import com.danimaniarqsoft.asterix.javaparser.core.ScaffoldingService;
import com.danimaniarqsoft.asterix.maven.MavenProject;
import com.danimaniarqsoft.asterix.template.freemaker.FreemarkerTemplateEngine;
import com.danimaniarqsoft.asterix.template.freemaker.SelectOneMenuDM;
import com.danimaniarqsoft.asterix.util.AbstractTest;
import com.danimaniarqsoft.asterix.util.JavaFieldVisitor;
import com.danimaniarqsoft.asterix.util.TemplateCatalog;
import com.github.javaparser.ast.CompilationUnit;

import freemarker.template.Template;

@Slf4j
public class ScaffoldingServiceTest extends AbstractTest {
    
	@Autowired
	private FreemarkerTemplateEngine fTemplateEngine;
	
	@Autowired
        private MavenProject mavenFile;
	
	@Autowired
	private ScaffoldingService scaffoldingService;
	
	@Test
	public void init(){
	    CompilationUnit cu = scaffoldingService.parseJavaFile(new File(mavenFile.getModelPath()+"/Usuario.java"));
	    ScaffoldingContext scaffoldingContext = new ScaffoldingContext();
	    scaffoldingService.createCrudPage(cu, new JavaFieldVisitor(), scaffoldingContext);
	}
	
	@Test(enabled=false)
	public void freemarkerTemplateEngineTest() throws ResourceNotFoundException,
			ParseErrorException, Exception {
        SelectOneMenuDM selectOneMenu = new SelectOneMenuDM();
        selectOneMenu.setComponentId("id");
        selectOneMenu.setComponentName("Usuario");
        selectOneMenu.setSelectItems("usuarioList");
        selectOneMenu.setValue("usuarioSelected");
        /* Get the template */
        Template temp = fTemplateEngine.getTemplate(TemplateCatalog.SERVICE_TEMPLATE);
        
        /* Merge data-model with template */
        Writer out = new OutputStreamWriter(System.out);
        temp.process(selectOneMenu, out);
	}
}
