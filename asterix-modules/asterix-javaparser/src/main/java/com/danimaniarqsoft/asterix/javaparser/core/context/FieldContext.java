package com.danimaniarqsoft.asterix.javaparser.core.context;

public class FieldContext extends BodyContext {
    private FieldType fieldType;
    private String importStatement;
    private String propertyType;
    private String propertyName;
	public FieldType getFieldType() {
		return fieldType;
	}
	public void setFieldType(FieldType fieldType) {
		this.fieldType = fieldType;
	}
	public String getImportStatement() {
		return importStatement;
	}
	public void setImportStatement(String importStatement) {
		this.importStatement = importStatement;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
}
