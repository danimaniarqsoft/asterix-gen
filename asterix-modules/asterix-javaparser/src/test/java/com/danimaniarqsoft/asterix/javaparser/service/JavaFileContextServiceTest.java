package com.danimaniarqsoft.asterix.javaparser.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.danimaniarqsoft.asterix.javaparser.core.JavaFileContextService;
import com.danimaniarqsoft.asterix.javaparser.core.context.BeanContext;
import com.danimaniarqsoft.asterix.javaparser.core.context.FieldType;
import com.danimaniarqsoft.asterix.javaparser.core.context.JavaFileContext;
import com.danimaniarqsoft.asterix.javaparser.util.AbstractTest;
import com.danimaniarqsoft.asterix.javaparser.util.CUUtil;
import com.danimaniarqsoft.asterix.javaparser.util.NamingConvention;
import com.danimaniarqsoft.asterix.javaparser.util.PropertyBeanSet;

public class JavaFileContextServiceTest extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(JavaFileContextServiceTest.class);

	@Autowired
	private JavaFileContextService fileFactory;

	@Test(dataProvider = "asterixContext")
	public void mavenFile(BeanContext mbContext, BeanContext model) throws IOException {
		JavaFileContext pContext = new JavaFileContext(CUUtil.readJavaFileFromResource("/Usuario.java"));
		PropertyBeanSet set = fileFactory.createPropertyBeanSet(model, NamingConvention.PROPERTY_SELECTED,
				FieldType.PROPERTY);
		pContext.addPropertyBeanSet(set, NamingConvention.PROPERTY_SELECTED);
		LOGGER.info(pContext.getCompilationUnit().toString());
	}
}
