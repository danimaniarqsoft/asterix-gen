package com.danimaniarqsoft.asterix.javaparser.sdl.method;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.type.Type;

public class MethodReturnType {
    private MethodDeclaration method = null;

    MethodReturnType(MethodDeclaration method) {
        this.method = method;
    }

    public MethodName thatReturns(Type returnType) {
        method.setType(returnType);
        return new MethodName(method);
    }

    public MethodName thatReturns(String returnType) {
        method.setType(ASTHelper.createReferenceType(returnType, 0));
        return new MethodName(method);
    }

    public MethodName thatReturns(Class<?> returnType) {
        method.setType(ASTHelper.createReferenceType(
                returnType.getSimpleName(), 0));
        return new MethodName(method);
    }
}
