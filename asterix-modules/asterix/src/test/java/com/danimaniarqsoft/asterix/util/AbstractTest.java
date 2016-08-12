package com.danimaniarqsoft.asterix.util;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.danimaniarqsoft.asterix.domain.AsterixContext;
import com.danimaniarqsoft.asterix.domain.ManagedBeanElement;
import com.danimaniarqsoft.asterix.domain.DomainElement;
import com.danimaniarqsoft.asterix.maven.MavenProject;

@ContextConfiguration(locations = { "classpath:META-INF/spring/spring-shell-plugin.xml" })
public abstract class AbstractTest extends AbstractTestNGSpringContextTests {

	@Autowired
	protected MavenProject mavenProject;

	@BeforeTest
	public void initTeste() {
		String testPath = System.getProperty("user.dir");
		testPath = testPath + "/src/test/resources/webtest";
		System.setProperty("user.dir", testPath);
	}
	
	@DataProvider(name = "asterixContext")
	public Object[][] dp() {
		DomainElement modelTarget = new DomainElement();
		modelTarget.setFileName("Usuario.java");
		modelTarget.setBeanInvocationFormat("usuario");
		modelTarget.setJavaType("Usuario");
		modelTarget.setImportDeclaration("com.danimaniarqsoft.webtest.model.Usuario");

		ManagedBeanElement mbTarget = new ManagedBeanElement();
		mbTarget.setFileName("AdministracionUsuarioMB.java");
		mbTarget.setBeanInvocationFormat("administracionUsuarioMB");
		mbTarget.setJavaType("AdministracionUsuarioMB");
		mbTarget.setJavaFilePath(new File(mavenProject.getWebPath(),
				"AdministracionUsuarioMB.java"));
		AsterixContext context = new AsterixContext(mbTarget, modelTarget);
		return new Object[][] { { context } };
	}
}
