package com.danimaniarqsoft.asterix.javaparser.sdl.method;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.Parameter;
import com.github.javaparser.ast.stmt.BlockStmt;

import java.util.ArrayList;
import java.util.List;

public abstract class BuildMethod {
    protected MethodDeclaration method = null;
    protected List<Parameter> params = new ArrayList<Parameter>();

    public MethodDeclaration build() {
        for (Parameter param : params) {
            ASTHelper.addParameter(method, param);
        }
        BlockStmt block = new BlockStmt();
        method.setBody(block);
        return method;
    }
}
