package com.danimaniarqsoft.asterix.javaparser;

import com.github.javaparser.ast.body.MethodDeclaration;

import org.testng.annotations.Test;

import com.danimaniarqsoft.asterix.javaparser.core.context.BodyContext;
import com.danimaniarqsoft.asterix.javaparser.core.context.FieldType;
import com.danimaniarqsoft.asterix.javaparser.factory.JavaMemberFactory;
import com.danimaniarqsoft.asterix.javaparser.factory.method.JavaMethodFactory;
import com.danimaniarqsoft.asterix.javaparser.util.JavaMemberContextUtils;


public class CreateMethodTest {
	
	private JavaMemberFactory factory = new JavaMethodFactory();
	
    @Test
    public void createMethodTest() {
    	BodyContext context = JavaMemberContextUtils.createSetterMethodContext("Usuario", "usuarioList", FieldType.PROPERTY);
    	MethodDeclaration method =  (MethodDeclaration) factory.buildMember(context);
    	System.out.println(method.toString());
    	context = JavaMemberContextUtils.createSetterMethodContext("Usuario", "usuario", FieldType.LIST);
    	method =  (MethodDeclaration) factory.buildMember(context);
    	System.out.println(method.toString());
    }
}