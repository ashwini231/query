package com.javaproj.query.model;

public class Table {
	private String tableName="employee";
	private String fieldName;
	private String resultQuery;
	public boolean flag;
	
	public String getTableName() {
		return tableName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public String getResultQuery() {
		return resultQuery;
	}
	public void setTableName(String tableName) {
		this.tableName=tableName;
	}
	public void setFieldName(String fieldName) {
		this.fieldName=fieldName;
	}
	public void setResultQuery(String resultQuery) {
		this.resultQuery=resultQuery;
	}
}
