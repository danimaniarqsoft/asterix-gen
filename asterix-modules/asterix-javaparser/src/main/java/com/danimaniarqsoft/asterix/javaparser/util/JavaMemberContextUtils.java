package com.danimaniarqsoft.asterix.javaparser.util;

import com.github.javaparser.ast.body.ModifierSet;

import java.util.ArrayList;
import java.util.List;

import com.danimaniarqsoft.asterix.javaparser.core.context.FieldContext;
import com.danimaniarqsoft.asterix.javaparser.core.context.FieldType;
import com.danimaniarqsoft.asterix.javaparser.core.context.MethodContext;
import com.danimaniarqsoft.asterix.javaparser.factory.Param;
import com.danimaniarqsoft.asterix.javaparser.factory.TypeOfMethod;

public class JavaMemberContextUtils {

    public static MethodContext createSetterMethodContext(String propertyType,
            String propertyName, FieldType fieldType) {
        MethodContext context = new MethodContext();
        context.setTypeOfMethod(TypeOfMethod.SETTER);
        formatIfList(context, fieldType);
        propertyType = formatPropertyIfList(propertyType, fieldType);
        return createSetterAndGetterMethodContextCommons(propertyType,
                propertyName, context);
    }

    public static MethodContext createGetterMethodContext(String propertyType,
            String propertyName, FieldType fieldType) {
        MethodContext context = new MethodContext();
        context.setTypeOfMethod(TypeOfMethod.GETTER);
        formatIfList(context, fieldType);
        propertyType = formatPropertyIfList(propertyType, fieldType);
        return createSetterAndGetterMethodContextCommons(propertyType,
                propertyName, context);
    }

    private static String formatPropertyIfList(String propertyType,
            FieldType fieldType) {
        if (fieldType == FieldType.LIST) {
            return "List<" + propertyType + ">";
        } else {
            return propertyType;
        }
    }

    public static FieldContext createPropertyFieldContext(String propertyType,
            String propertyName, FieldType fieldType) {
        FieldContext context = new FieldContext();
        context.setAccessType(ModifierSet.PRIVATE);
        context.setFieldType(fieldType);
        context.setPropertyType(propertyType);
        context.setPropertyName(propertyName);
        return context;
    }

    private static MethodContext createSetterAndGetterMethodContextCommons(
            String propertyType, String propertyName, MethodContext context) {
        context.setAccessType(ModifierSet.PUBLIC);
        List<Param> params = new ArrayList<Param>();
        params.add(new Param(propertyType, propertyName));
        context.setMethodParam(params);
        context.setReturnType(propertyType);
        return context;
    }

    private static void formatIfList(MethodContext context, FieldType fieldType) {
        if (fieldType == FieldType.LIST) {
            context.setReturnType("List<" + context.getReturnType() + ">");
        }
    }
}
