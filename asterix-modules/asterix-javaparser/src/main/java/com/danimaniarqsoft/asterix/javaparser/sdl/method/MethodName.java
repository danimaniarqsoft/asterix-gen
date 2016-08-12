package com.danimaniarqsoft.asterix.javaparser.sdl.method;

import com.github.javaparser.ast.body.MethodDeclaration;

/**
 * Clase intermedia que se utiliza para crear un API Fluente de la creación de
 * un método
 * 
 * @author Daniel Pichardo
 * 
 */
public class MethodName {
    private MethodDeclaration method = null;

    MethodName(MethodDeclaration method) {
        this.method = method;
    }

    public MethodParam witchNameIs(String methodName) {
        method.setName(methodName);
        return new MethodParam(method);
    }
}
