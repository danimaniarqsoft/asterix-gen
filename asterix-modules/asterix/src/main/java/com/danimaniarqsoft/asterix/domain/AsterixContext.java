package com.danimaniarqsoft.asterix.domain;

import com.danimaniarqsoft.asterix.faces.templates.TypeOfComponent;
import com.danimaniarqsoft.asterix.javaparser.core.context.JavaFileContext;

public class AsterixContext {

	private ManagedBeanElement mbTarget;
	private DomainElement domainElement;
	private JavaConstantClassTarget javaConstantClassTarget;
	private FacesComponente facesComponent;
	private TypeOfComponent typeOfComponent;
	private JavaFileContext javaFileContext;
	private String JavaScriptConstant;

	public AsterixContext() {
	}

	public AsterixContext(JavaConstantClassTarget javaConstantClassTarget) {
		this.javaConstantClassTarget = javaConstantClassTarget;
	}

	public AsterixContext(ManagedBeanElement mbTarget, DomainElement modelTarget) {
		this.mbTarget = mbTarget;
		this.domainElement = modelTarget;
	}

	public AsterixContext(ManagedBeanElement mbTarget, DomainElement modelTarget, FacesComponente facesComponent) {
		this(mbTarget, modelTarget);
		this.facesComponent = facesComponent;
	}

	public AsterixContext(DomainElement domainElement) {
		this.domainElement = domainElement;
	}

	public ManagedBeanElement getMbTarget() {
		return mbTarget;
	}

	public void setMbTarget(ManagedBeanElement mbTarget) {
		this.mbTarget = mbTarget;
	}

	public DomainElement getDomainElement() {
		return domainElement;
	}

	public void setDomainElement(DomainElement domainElement) {
		this.domainElement = domainElement;
	}

	public JavaConstantClassTarget getJavaConstantClassTarget() {
		return javaConstantClassTarget;
	}

	public void setJavaConstantClassTarget(JavaConstantClassTarget javaConstantClassTarget) {
		this.javaConstantClassTarget = javaConstantClassTarget;
	}

	public FacesComponente getFacesComponent() {
		return facesComponent;
	}

	public void setFacesComponent(FacesComponente facesComponent) {
		this.facesComponent = facesComponent;
	}

	public TypeOfComponent getTypeOfComponent() {
		return typeOfComponent;
	}

	public void setTypeOfComponent(TypeOfComponent typeOfComponent) {
		this.typeOfComponent = typeOfComponent;
	}

	public JavaFileContext getJavaFileContext() {
		return javaFileContext;
	}

	public void setJavaFileContext(JavaFileContext javaFileContext) {
		this.javaFileContext = javaFileContext;
	}

	public String getJavaScriptConstant() {
		return JavaScriptConstant;
	}

	public void setJavaScriptConstant(String javaScriptConstant) {
		JavaScriptConstant = javaScriptConstant;
	}
}
