package com.danimaniarqsoft.asterix.javaparser.factory;

public class Param {
	private String varType;
	private String varName;

	public Param(String varType, String varName) {
		this.varType = varType;
		this.varName = varName;
	}

	public String getVarType() {
		return varType;
	}

	public void setVarType(String varType) {
		this.varType = varType;
	}

	public String getVarName() {
		return varName;
	}

	public void setVarName(String varName) {
		this.varName = varName;
	}
}
