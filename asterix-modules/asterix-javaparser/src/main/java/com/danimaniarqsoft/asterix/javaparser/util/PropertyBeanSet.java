package com.danimaniarqsoft.asterix.javaparser.util;

import com.github.javaparser.ast.ImportDeclaration;
import com.github.javaparser.ast.body.FieldDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;

import lombok.experimental.Builder;


public class PropertyBeanSet {
	private ImportDeclaration importDeclaration;
	private FieldDeclaration property;
	private MethodDeclaration setterMethod;
	private MethodDeclaration getterMethod;

	public ImportDeclaration getImportDeclaration() {
		return importDeclaration;
	}

	public void setImportDeclaration(ImportDeclaration importDeclaration) {
		this.importDeclaration = importDeclaration;
	}

	public FieldDeclaration getProperty() {
		return property;
	}

	public void setProperty(FieldDeclaration property) {
		this.property = property;
	}

	public MethodDeclaration getSetterMethod() {
		return setterMethod;
	}

	public void setSetterMethod(MethodDeclaration setterMethod) {
		this.setterMethod = setterMethod;
	}

	public MethodDeclaration getGetterMethod() {
		return getterMethod;
	}

	public void setGetterMethod(MethodDeclaration getterMethod) {
		this.getterMethod = getterMethod;
	}
	public static PropertyBeanSetBuilder builder(){
		return new PropertyBeanSetBuilder();
	}
	public static class PropertyBeanSetBuilder {
        private PropertyBeanSet targetObject;
 
        public PropertyBeanSetBuilder() {
        	targetObject = new PropertyBeanSet();
        }
 
        public PropertyBeanSetBuilder importDeclaration(ImportDeclaration importDeclaration) {
        	targetObject.importDeclaration = importDeclaration;
            return this;
        }
 
        public PropertyBeanSetBuilder property(FieldDeclaration property) {
            targetObject.property = property;
            return this;
        }
 
        public PropertyBeanSetBuilder setterMethod(MethodDeclaration setterMethod) {
            targetObject.setterMethod= setterMethod;
            return this;
        }
        public PropertyBeanSetBuilder getterMethod(MethodDeclaration getterMethod) {
            targetObject.getterMethod= getterMethod;
            return this;
        }
 
        public PropertyBeanSet build() {
            return targetObject;
        }
 
    }

}
