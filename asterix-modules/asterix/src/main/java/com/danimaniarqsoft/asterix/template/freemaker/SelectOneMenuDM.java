package com.danimaniarqsoft.asterix.template.freemaker;

public class SelectOneMenuDM {
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getComponentId() {
		return componentId;
	}
	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getSelectItems() {
		return selectItems;
	}
	public void setSelectItems(String selectItems) {
		this.selectItems = selectItems;
	}
	private String componentName;
	private String componentId;
	private String value;
	private String selectItems;
}
