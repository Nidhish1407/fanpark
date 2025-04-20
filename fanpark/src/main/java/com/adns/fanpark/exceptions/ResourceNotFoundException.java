package com.adns.fanpark.exceptions;


public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private Long fieldId;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Long fieldId) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, fieldId));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldId = fieldId;
	}
	
	
	String getResourceName() {
		return resourceName;
	}

	void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	String getFieldName() {
		return fieldName;
	}

	void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	Long getFieldId() {
		return fieldId;
	}

	void setFieldId(Long fieldId) {
		this.fieldId = fieldId;
	}

}
