package com.javaproj.query.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tabledata")
public class TableMetaData {
	
	@Id
	@Column(name="column_name")
	public String column_name;
	
	@Column(name="data_type")
	public String data_type;
	
	public String getColumnName(){
		return column_name;
	}
	public void setColumnName(String column_name){
		this.column_name=column_name;
	}
}

