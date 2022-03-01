package com.javaproj.query.model;

public class Table {
	private String tableName;
	private String fieldName;
	private String aliasName;
	private String columnName;
	private String operator;
	private String value;
	private String resultQuery;
	private String orderColumn;
	private String orderValue;
	public boolean flag;
	
	public String getTableName() {
		return tableName;
	}
	public String getFieldName() {
		return fieldName;
	}
	public String getAliasName() {
		return aliasName;
	}
	public String getColumnName() {
		return columnName;
	}
	public String getOperator() {
		return operator;
	}
	public String getValue() {
		return value;
	}
	public String getOrderColumn() {
		return orderColumn;
	}
	public String getOrderValue() {
		return orderValue;
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
	public void setAliasName(String aliasName) {
		this.aliasName=aliasName;
	}
	public void setColumnName(String columnName) {
		this.columnName=columnName;
	}
	public void setOperator(String operator) {
		this.operator=operator;
	}
	public void setValue(String value) {
		this.value=value;
	}
	public void setOrderColumn(String orderColumn) {
		this.orderColumn=orderColumn;
	}
	public void setOrderValue(String orderValue) {
		this.orderValue=orderValue;
	}
	public void setResultQuery(String resultQuery) {
		this.resultQuery=resultQuery;
	}
	public void setFlag(boolean flag){
		this.flag=flag;
		
	}
	public boolean getFlag(){
		return flag;
	}
}
