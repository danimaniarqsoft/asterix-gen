package com.danimaniarqsoft.asterix.javaparser.sdl.method;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.ast.body.MethodDeclaration;

public class MethodParam extends BuildMethod {

    MethodParam(MethodDeclaration method) {
        this.method = method;
    }

    public MethodParam withParam(String type, String name) {
        this.params.add(ASTHelper.createParameter(
                ASTHelper.createReferenceType(type, 0), name));
        return this;
    }
}
