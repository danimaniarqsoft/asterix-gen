package com.danimaniarqsoft.asterix.javaparser.util;

import java.util.List;

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

public class CUSet {

	private List<ImportDeclaration> imports;

	private List<FieldDeclaration> fields;

	private List<MethodDeclaration> methods;

	public CUSet(List<ImportDeclaration> imports, List<FieldDeclaration> fields, List<MethodDeclaration> methods) {
		this.imports = imports;
		this.fields = fields;
		this.methods = methods;
	}

	public List<ImportDeclaration> getImports() {
		return imports;
	}

	public List<FieldDeclaration> getFields() {
		return fields;
	}

	public List<MethodDeclaration> getMethods() {
		return methods;
	}
}
