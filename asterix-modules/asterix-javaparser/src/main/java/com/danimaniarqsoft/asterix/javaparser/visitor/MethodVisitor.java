package com.danimaniarqsoft.asterix.javaparser.visitor;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

/**
 * 
 * @author danimaniARQSOFT
 * 
 */
public class MethodVisitor extends VoidVisitorAdapter<String> {

    @Override
    public void visit(final MethodDeclaration n, final String arg) {
        System.out.println(n.getName());
        n.setName(arg);
        Parameter newArg = ASTHelper.createParameter(ASTHelper.INT_TYPE,
                "value");
        ASTHelper.addParameter(n, newArg);
    }

    @Override
    public void visit(VariableDeclarator n, String arg) {
        System.out.println(n.toString());
    }

    @Override
    public void visit(FieldDeclaration n, String arg) {
        System.out.println(n.toString());
    }
}
