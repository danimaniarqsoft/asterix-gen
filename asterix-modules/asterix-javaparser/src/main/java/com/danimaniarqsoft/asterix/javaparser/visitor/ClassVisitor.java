package com.danimaniarqsoft.asterix.javaparser.visitor;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class ClassVisitor extends VoidVisitorAdapter {

    @Override
    public void visit(MethodDeclaration n, Object arg) {
        // change the name of the method to upper case
        n.setName(n.getName().toUpperCase());
        // create the new parameter
        Parameter newArg = ASTHelper.createParameter(ASTHelper.INT_TYPE,
                "value");
        // add the parameter to the method
        ASTHelper.addParameter(n, newArg);
    }
}
