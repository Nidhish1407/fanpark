package com.adns.fanpark.exceptions;


public class ResourceNotFoundException extends RuntimeException{
	
	private String resourceName;
	private String fieldName;
	private Integer fieldId;
	
	public ResourceNotFoundException(String resourceName, String fieldName, Integer id) {
		super(String.format("%s not found with %s : %s", resourceName, fieldName, id));
		this.resourceName = resourceName;
		this.fieldName = fieldName;
		this.fieldId = id;
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

	Integer getFieldId() {
		return fieldId;
	}

	void setFieldId(Integer fieldId) {
		this.fieldId = fieldId;
	}

}
