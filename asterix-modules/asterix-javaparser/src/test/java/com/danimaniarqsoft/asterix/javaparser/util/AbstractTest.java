package com.danimaniarqsoft.asterix.javaparser.util;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.danimaniarqsoft.asterix.javaparser.core.context.BeanContext;

@ContextConfiguration(locations = { "classpath:META-INF/spring/applicationContext-javaparser.xml" })
public abstract class AbstractTest extends AbstractTestNGSpringContextTests {

	@BeforeTest
	public void initTeste() {
		String testPath = System.getProperty("user.dir");
		testPath = testPath + "/src/test/resources/webtest";
		System.setProperty("user.dir", testPath);
	}

	@DataProvider(name = "asterixContext")
	public Object[][] dp() {
		BeanContext modelTarget = new BeanContext();
		modelTarget.setImportDeclaration("mx.com.test.model.Usuario");
		modelTarget.setFileName("Usuario.java");
		modelTarget.setBeanInvocationFormat("usuario");
		modelTarget.setJavaType("Usuario");

		BeanContext mbTarget = new BeanContext();
		mbTarget.setImportDeclaration("mx.com.test.exposition.AdministracionUsuarioMB");
		mbTarget.setFileName("AdministracionUsuarioMB.java");
		mbTarget.setBeanInvocationFormat("administracionUsuarioMB");
		mbTarget.setJavaType("AdministracionUsuarioMB");
		return new Object[][] { { mbTarget, modelTarget } };
	}
}
