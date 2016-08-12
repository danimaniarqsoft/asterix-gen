package com.danimaniarqsoft.asterix.javaparser.visitor;

import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.VariableDeclarator;
import com.github.javaparser.ast.type.PrimitiveType;
import com.github.javaparser.ast.type.PrimitiveType.Primitive;
import com.github.javaparser.ast.type.ReferenceType;
import com.github.javaparser.ast.type.Type;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;

import com.danimaniarqsoft.asterix.javaparser.visitor.context.JavaScriptVisitorContext;

/**
 * 
 * @author danimaniARQSOFT
 * 
 */
public class ConstantsFieldVisitor extends VoidVisitorAdapter<JavaScriptVisitorContext> {

	@Override
	public void visit(final VariableDeclarator variable, JavaScriptVisitorContext jsvContext) {
		FieldDeclaration field = (FieldDeclaration) variable.getParentNode();
		Type type = field.getType();

		if (type instanceof PrimitiveType) {
			PrimitiveType pType = (PrimitiveType) type;
			Primitive p = pType.getType();
			if (p.equals(Primitive.Int)) {
				jsvContext.agregarConstante(variable.getId().toString(), variable.getInit());
			}
		}
		if (type instanceof ReferenceType) {
			jsvContext.agregarConstante(variable.getId().toString(), variable.getInit());
		}
	}
}
