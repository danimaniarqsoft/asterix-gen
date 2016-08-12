package com.danimaniarqsoft.asterix.javaparser.core.context;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.danimaniarqsoft.asterix.javaparser.util.CUSet;
import com.danimaniarqsoft.asterix.javaparser.util.CUUtil;
import com.danimaniarqsoft.asterix.javaparser.util.NamingConvention;
import com.danimaniarqsoft.asterix.javaparser.util.PropertyBeanSet;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.BodyDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.NameExpr;

public class JavaFileContext {
	private static final Logger LOGGER = LoggerFactory.getLogger(JavaFileContext.class);

    private CompilationUnit cu;

    private LinkedHashMap<String, ImportDeclaration> imports = new LinkedHashMap<String, ImportDeclaration>();

    private LinkedHashMap<String, FieldDeclaration> fields = new LinkedHashMap<String, FieldDeclaration>();

    private LinkedHashMap<String, MethodDeclaration> methods = new LinkedHashMap<String, MethodDeclaration>();

    public JavaFileContext(File cuPath) throws IOException {
        this(CUUtil.readJavaFile(cuPath));
    }

    public JavaFileContext(String cuPath) throws IOException {
        this(new File(cuPath));
    }

    public JavaFileContext(CompilationUnit cu) {
        this.cu = cu;
        CUSet cuSet = CUUtil.extractFieldsAndMethods(cu);
        addAllImports(cuSet.getImports());
        addAllFields(cuSet.getFields());
        addAllMethods(cuSet.getMethods());
    }

    public void addAllImports(List<ImportDeclaration> imports) {
        for (ImportDeclaration importDeclaration : imports) {
            addImport(importDeclaration);
        }
    }

    public void addAllFields(List<FieldDeclaration> fields) {
        for (FieldDeclaration fieldDeclaration : fields) {
            addField(fieldDeclaration);
        }
    }

    public void addAllMethods(List<MethodDeclaration> methods) {
        for (MethodDeclaration methodDeclaration : methods) {
            addMethod(methodDeclaration);
        }
    }

    public void addImport(ImportDeclaration importDeclaration) {
        LOGGER.debug("addImport (key) ->", importDeclaration.toString());
        if (!imports.containsKey(importDeclaration.toString())) {
            imports.put(importDeclaration.toString(), importDeclaration);
        }
    }

    public void addMethod(MethodDeclaration method) {
        LOGGER.debug("addMethod (key) ->", method.toString());
        if (!methods.containsKey(method.toString())) {
            methods.put(method.toString(), method);
        }
    }

    public void addField(FieldDeclaration field) {
        LOGGER.debug("addField (key) ->", field.toString());
        if (!fields.containsKey(field.toString())) {
            fields.put(field.toString(), field);
        }
    }

    public void addPropertyBeanSet(PropertyBeanSet propertyBeanSet,
            String namingConvention) {
        if (namingConvention.equals(NamingConvention.PROPERTY_LIST)) {
            addImport(new ImportDeclaration(new NameExpr("java.util.List"),
                    false, false));
        }
        addImport(propertyBeanSet.getImportDeclaration());
        addField(propertyBeanSet.getProperty());
        addMethod(propertyBeanSet.getSetterMethod());
        addMethod(propertyBeanSet.getGetterMethod());

    }

    public CompilationUnit getCompilationUnit() {
        cu.getImports().addAll(buildNewImports());
        cu.getTypes().get(0).getMembers().addAll(buildNewMembers());
        return this.cu;
    }

    private List<BodyDeclaration> buildNewMembers() {
        /** Limpiamos los elementos anteriores **/
        cu.getTypes().get(0).getMembers().clear();
        List<BodyDeclaration> newMembers = new ArrayList<BodyDeclaration>();
        newMembers.addAll(new ArrayList<BodyDeclaration>(fields.values()));
        newMembers.addAll(new ArrayList<BodyDeclaration>(methods.values()));
        return newMembers;
    }

    private List<ImportDeclaration> buildNewImports() {
        /** Limpiamos los elementos anteriores **/
        cu.getImports().clear();
        return new ArrayList<ImportDeclaration>(imports.values());
    }
}
