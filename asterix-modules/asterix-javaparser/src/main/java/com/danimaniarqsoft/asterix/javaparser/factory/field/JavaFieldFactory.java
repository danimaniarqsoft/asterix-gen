package com.danimaniarqsoft.asterix.javaparser.factory.field;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.ModifierSet;

import org.springframework.stereotype.Component;

import com.danimaniarqsoft.asterix.javaparser.core.context.BodyContext;
import com.danimaniarqsoft.asterix.javaparser.core.context.FieldContext;
import com.danimaniarqsoft.asterix.javaparser.factory.JavaMemberFactory;

@Component
public class JavaFieldFactory extends JavaMemberFactory {

    @Override
    public FieldDeclaration buildMember(BodyContext bodyContext) {
        FieldContext context = (FieldContext) bodyContext;
        switch (context.getFieldType()) {
        case PROPERTY:
            return ASTHelper
                    .createFieldDeclaration(
                            ModifierSet.PRIVATE,
                            ASTHelper.createReferenceType(
                                    context.getPropertyType(), 0),
                            context.getPropertyName());

        case LIST:
            return ASTHelper.createFieldDeclaration(
                    ModifierSet.PRIVATE,
                    ASTHelper.createReferenceType(
                            "List<" + context.getPropertyType() + ">", 0),
                    context.getPropertyName());
        default:
            throw new RuntimeException("El método elegído no existe");
        }
    }
}
