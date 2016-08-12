package com.danimaniarqsoft.asterix.javaparser.core.context;

import java.util.List;

import com.danimaniarqsoft.asterix.javaparser.factory.Param;
import com.danimaniarqsoft.asterix.javaparser.factory.TypeOfMethod;

public class MethodContext extends BodyContext {
    private TypeOfMethod typeOfMethod;
    private String methodName;
    private List<Param> methodParam;
    private String returnType;
    private boolean returnTypeIsList;
    
	public TypeOfMethod getTypeOfMethod() {
		return typeOfMethod;
	}
	public void setTypeOfMethod(TypeOfMethod typeOfMethod) {
		this.typeOfMethod = typeOfMethod;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public List<Param> getMethodParam() {
		return methodParam;
	}
	public void setMethodParam(List<Param> methodParam) {
		this.methodParam = methodParam;
	}
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}
	public boolean isReturnTypeIsList() {
		return returnTypeIsList;
	}
	public void setReturnTypeIsList(boolean returnTypeIsList) {
		this.returnTypeIsList = returnTypeIsList;
	}
}
