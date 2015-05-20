package com.lgfei.mysite.message;

public class ResultMessageVO {

	private String className;
	private String methodName;
	private boolean isError;
    private String message;
    private Object voObj;
    
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getVoObj() {
		return voObj;
	}
	public void setVoObj(Object voObj) {
		this.voObj = voObj;
	}
}
