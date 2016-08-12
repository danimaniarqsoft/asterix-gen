package com.danimaniarqsoft.asterix.javaparser;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.ParseException;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.ModifierSet;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.danimaniarqsoft.asterix.javaparser.core.context.FieldType;
import com.danimaniarqsoft.asterix.javaparser.core.context.MethodContext;
import com.danimaniarqsoft.asterix.javaparser.factory.TypeOfMethod;
import com.danimaniarqsoft.asterix.javaparser.factory.method.JavaMethodFactory;
import com.danimaniarqsoft.asterix.javaparser.util.CUUtil;
import com.danimaniarqsoft.asterix.javaparser.util.JavaMemberContextUtils;

public class JavaFileParsingTest {

	private String varType;
	private String varName;

	@BeforeClass
	public void init() {
		this.varType = "Usuario";
		this.varName = "usuarioList";
	}

	@Test
	public void main() throws ParseException, IOException {

		CompilationUnit cu = CUUtil.readJavaFileFromResource("/Usuario.java");
		
		FieldDeclaration fd = ASTHelper.createFieldDeclaration(
				ModifierSet.PRIVATE, ASTHelper.createReferenceType(varType, 0),
				varName);

		List<BodyDeclaration> bd = cu.getTypes().get(0).getMembers();
		bd.add(0, fd);

		MethodContext method = JavaMemberContextUtils
				.createSetterMethodContext(varType, varName, FieldType.PROPERTY);
		JavaMethodFactory factory = new JavaMethodFactory();
		bd.add(factory.buildMember(method));
		method.setTypeOfMethod(TypeOfMethod.GETTER);
		bd.add(factory.buildMember(method));
		System.out.println(cu.toString());
	}
}