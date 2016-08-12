package com.danimaniarqsoft.asterix.domain;

import com.danimaniarqsoft.asterix.faces.templates.TypeOfComponent;


public class FacesComponente {
    private TypeOfComponent typeOfComponent;
    private String id;
    private String modelSelected;
    private String modelList;
	public TypeOfComponent getTypeOfComponent() {
		return typeOfComponent;
	}
	public void setTypeOfComponent(TypeOfComponent typeOfComponent) {
		this.typeOfComponent = typeOfComponent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getModelSelected() {
		return modelSelected;
	}
	public void setModelSelected(String modelSelected) {
		this.modelSelected = modelSelected;
	}
	public String getModelList() {
		return modelList;
	}
	public void setModelList(String modelList) {
		this.modelList = modelList;
	}
}
