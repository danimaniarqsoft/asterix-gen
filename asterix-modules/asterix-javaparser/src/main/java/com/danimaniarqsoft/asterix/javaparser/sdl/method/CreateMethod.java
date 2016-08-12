package com.danimaniarqsoft.asterix.javaparser.sdl.method;

import com.github.javaparser.ast.body.MethodDeclaration;

/**
 * 
 * @author Daniel Pichardo
 * 
 */
public class CreateMethod {
    public static MethodReturnType withAccess(int accessType) {
        MethodDeclaration method = new MethodDeclaration();
        method.setModifiers(accessType);
        return new MethodReturnType(method);
    }
}
