package com.danimaniarqsoft.asterix.javaparser.core.context;

import java.io.File;

public class BeanContext {
	public File getJavaFilePath() {
		return javaFilePath;
	}
	public void setJavaFilePath(File javaFilePath) {
		this.javaFilePath = javaFilePath;
	}
	public String getImportDeclaration() {
		return importDeclaration;
	}
	public void setImportDeclaration(String importDeclaration) {
		this.importDeclaration = importDeclaration;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getBeanInvocationFormat() {
		return beanInvocationFormat;
	}
	public void setBeanInvocationFormat(String beanInvocationFormat) {
		this.beanInvocationFormat = beanInvocationFormat;
	}
	public String getJavaType() {
		return javaType;
	}
	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}
	protected File javaFilePath;
	protected String importDeclaration;
	protected String fileName;
	protected String beanInvocationFormat;
	protected String javaType;
}
