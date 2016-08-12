/**
 * Creado por: danimaniARQSOFT
 * Autor     : Daniel Pichardo	
 * Fecha     : Apr 25, 2014
 * Hora      : 11:37:10 PM
 * 
 */
package com.danimaniarqsoft.asterix.javaparser.core;



import java.io.File;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.danimaniarqsoft.asterix.javaparser.core.context.BeanContext;
import com.danimaniarqsoft.asterix.javaparser.core.context.FieldContext;
import com.danimaniarqsoft.asterix.javaparser.core.context.FieldType;
import com.danimaniarqsoft.asterix.javaparser.core.context.JavaFileContext;
import com.danimaniarqsoft.asterix.javaparser.core.context.MethodContext;
import com.danimaniarqsoft.asterix.javaparser.factory.JavaMemberFactory;
import com.danimaniarqsoft.asterix.javaparser.util.CUUtil;
import com.danimaniarqsoft.asterix.javaparser.util.JavaMemberContextUtils;
import com.danimaniarqsoft.asterix.javaparser.util.PropertyBeanSet;
import com.danimaniarqsoft.asterix.javaparser.visitor.ConstantsFieldVisitor;
import com.danimaniarqsoft.asterix.javaparser.visitor.context.JavaScriptVisitorContext;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.NameExpr;

/**
 * La Class JavaFileContextService. Esta clase es la interfaz principal del
 * módulo de asterix-javaparser
 * 
 * @author Daniel Pichardo
 */
@Service
public class JavaFileContextService {
	private static final Logger LOGGER = LoggerFactory.getLogger(JavaFileContextService.class);


    @Autowired
    @Qualifier("javaFieldFactory")
    private JavaMemberFactory fieldFactory;
    @Autowired
    @Qualifier("javaMethodFactory")
    private JavaMemberFactory methodFactory;

    /**
     * Adds the setter method to java file context.
     * 
     * @param context
     *            the context
     * @param javaFileContext
     *            the java file context
     */
    public void addSetterMethodToJavaFileContext(BeanContext context,
            JavaFileContext javaFileContext, FieldType fieldType) {
        MethodContext setter = JavaMemberContextUtils
                .createSetterMethodContext(context.getJavaType(),
                        context.getBeanInvocationFormat(), fieldType);
        javaFileContext.addMethod((MethodDeclaration) methodFactory
                .buildMember(setter));
    }

    /**
     * Adds the getter method to java file context.
     * 
     * @param context
     *            the context
     * @param javaFileContext
     *            the java file context
     */
    public void addGetterMethodToJavaFileContext(BeanContext context,
            JavaFileContext javaFileContext, FieldType fieldType) {
        MethodContext getter = JavaMemberContextUtils
                .createGetterMethodContext(context.getJavaType(),
                        context.getBeanInvocationFormat(), fieldType);
        javaFileContext.addMethod((MethodDeclaration) methodFactory
                .buildMember(getter));
    }

    /**
     * Adds the property to java file context.
     * 
     * @param context
     *            the context
     * @param javaFileContext
     *            the java file context
     */
    public void addPropertyToJavaFileContext(BeanContext context,
            JavaFileContext javaFileContext, FieldType fieldType) {
        FieldContext field = JavaMemberContextUtils.createPropertyFieldContext(
                context.getJavaType(), context.getBeanInvocationFormat(),
                fieldType);
        javaFileContext.addField((FieldDeclaration) fieldFactory
                .buildMember(field));
    }

    /**
     * Creates the property bean set.
     * 
     * @param context
     *            the context
     * @return el property bean set
     */
    public PropertyBeanSet createPropertyBeanSet(final BeanContext context,
            final String namingConvention, FieldType fieldType) {
        ImportDeclaration importDeclaration = new ImportDeclaration(
                new NameExpr(context.getImportDeclaration()), false, false);

        FieldContext field = JavaMemberContextUtils.createPropertyFieldContext(
                context.getJavaType(), context.getBeanInvocationFormat()
                        + namingConvention, fieldType);
        MethodContext getter = JavaMemberContextUtils
                .createGetterMethodContext(context.getJavaType(),
                        context.getBeanInvocationFormat() + namingConvention,
                        fieldType);
        MethodContext setter = JavaMemberContextUtils
                .createSetterMethodContext(context.getJavaType(),
                        context.getBeanInvocationFormat() + namingConvention,
                        fieldType);

        return PropertyBeanSet
                .builder()
                .importDeclaration(importDeclaration)
                .property((FieldDeclaration) fieldFactory.buildMember(field))
                .setterMethod(
                        (MethodDeclaration) methodFactory.buildMember(setter))
                .getterMethod(
                        (MethodDeclaration) methodFactory.buildMember(getter))
                .build();
    }

    /**
     * Write java file context to java file.
     * 
     * @param javaFile
     *            the java file
     * @param context
     *            the context
     */
    public void writeJavaFileContextToJavaFile(File javaFile,
            JavaFileContext context) {
        CompilationUnit cu = context.getCompilationUnit();
        try {
            CUUtil.writeCU(cu, javaFile);
        } catch (IOException e) {
            LOGGER.error("La ruta {} no existe", javaFile.toString());
        }
    }

    /**
     * 
     * @param javaFile
     * @param context
     * @return String con la representación del archivo java a JavaScript
     */
    public String convertFromJavaToJavaScript(File javaFile,
            JavaFileContext context) {
        CompilationUnit cu = context.getCompilationUnit();
        JavaScriptVisitorContext jsvContext = new JavaScriptVisitorContext(
                "CONSTANTES");
        new ConstantsFieldVisitor().visit(cu, jsvContext);
        return jsvContext.buildJavaScriptConstantString();
    }
}
