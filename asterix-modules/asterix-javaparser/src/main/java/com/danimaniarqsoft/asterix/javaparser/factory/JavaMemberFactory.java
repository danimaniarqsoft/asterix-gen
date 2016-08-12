package com.danimaniarqsoft.asterix.javaparser.factory;

import com.github.javaparser.ast.body.BodyDeclaration;

import com.danimaniarqsoft.asterix.javaparser.core.context.BodyContext;

public abstract class JavaMemberFactory {
    abstract public BodyDeclaration buildMember(BodyContext context);
}
