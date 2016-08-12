package com.danimaniarqsoft.asterix.javaparser.factory.method;

import com.github.javaparser.ASTHelper;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.body.ModifierSet;
import com.github.javaparser.ast.expr.AssignExpr;
import com.github.javaparser.ast.expr.AssignExpr.Operator;
import com.github.javaparser.ast.expr.FieldAccessExpr;
import com.github.javaparser.ast.expr.NameExpr;
import com.github.javaparser.ast.stmt.ReturnStmt;


import org.springframework.stereotype.Component;

import com.danimaniarqsoft.asterix.javaparser.core.context.BodyContext;
import com.danimaniarqsoft.asterix.javaparser.core.context.MethodContext;
import com.danimaniarqsoft.asterix.javaparser.factory.JavaMemberFactory;
import com.danimaniarqsoft.asterix.javaparser.sdl.method.CreateMethod;
import com.danimaniarqsoft.asterix.javaparser.sdl.method.MethodName;

@Component
public class JavaMethodFactory extends JavaMemberFactory {

    @Override
    public MethodDeclaration buildMember(BodyContext bodyContext) {
        MethodContext context = (MethodContext) bodyContext;
        MethodDeclaration method = null;
        switch (context.getTypeOfMethod()) {
        case ACTION_LISTENER:
            method = CreateMethod.withAccess(ModifierSet.PUBLIC)
                    .thatReturns(MethodName.class)
                    .witchNameIs("consultaUsuario")
                    .withParam("ActionEvent", "event").build();
            return method;
        case SETTER:
            method = CreateMethod
                    .withAccess(context.getAccessType())
                    .thatReturns("void")
                    .witchNameIs(
                            formatSetter(context.getMethodParam().get(0)
                                    .getVarName()))
                    .withParam(context.getMethodParam().get(0).getVarType(),
                            context.getMethodParam().get(0).getVarName())
                    .build();
            NameExpr thisOp = new NameExpr("this");
            FieldAccessExpr fieldAccess = new FieldAccessExpr(thisOp, context
                    .getMethodParam().get(0).getVarName());
            NameExpr beanAssign = new NameExpr(context.getMethodParam().get(0)
                    .getVarName());
            AssignExpr assignExpr = new AssignExpr(fieldAccess, beanAssign,
                    Operator.assign);
            ASTHelper.addStmt(method.getBody(), assignExpr);
            return method;

        case GETTER:
            method = CreateMethod
                    .withAccess(context.getAccessType())
                    .thatReturns(context.getReturnType())
                    .witchNameIs(
                            formatGetter(context.getMethodParam().get(0)
                                    .getVarName())).build();
            NameExpr op1 = new NameExpr("this");
            FieldAccessExpr returnProperty = new FieldAccessExpr(op1, context
                    .getMethodParam().get(0).getVarName());
            ReturnStmt returnStmt = new ReturnStmt(returnProperty);
            ASTHelper.addStmt(method.getBody(), returnStmt);
            return method;
        default:
            throw new RuntimeException("El método elegído no existe");
        }
    }

    private String formatGetter(String property) {
        return setterAndGetterFormat(property, "get");
    }

    private String formatSetter(String property) {
        return setterAndGetterFormat(property, "set");
    }

    private String setterAndGetterFormat(String property, String setOrGet) {
        StringBuilder sb = new StringBuilder(setOrGet);
        String format = (property.charAt(0) + "").toUpperCase();
        sb.append(property.replaceFirst(property.charAt(0) + "",
                (property.charAt(0) + "").toUpperCase()));
        return sb.toString();
    }
}
