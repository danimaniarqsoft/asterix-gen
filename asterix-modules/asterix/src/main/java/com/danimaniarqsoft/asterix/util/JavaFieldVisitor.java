package com.danimaniarqsoft.asterix.util;

import com.danimaniarqsoft.asterix.domain.scaffolding.ScaffoldingContext;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

public class JavaFieldVisitor extends VoidVisitorAdapter<ScaffoldingContext> {

    @Override
    public void visit(final FieldDeclaration field, final ScaffoldingContext arg) {
        System.out.println(field.toString());
    }
}
