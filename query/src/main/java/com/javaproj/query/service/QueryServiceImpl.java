package com.javaproj.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproj.query.model.*;
import com.javaproj.query.repository.TableDataRepository;

@Service
public class QueryServiceImpl implements QueryService{
	@Autowired
	private TableDataRepository tabledataRepository ;
	
	public String getFinalField(Table table){
		String str="";
		String[] arr1 = table.getFieldName().split(",",-2);
		String[] arr2 = table.getAliasName().split(",",-2);
		//System.out.println(arr1.length);
		//System.out.println(arr2.length);
		for(int i=arr2.length; i<arr1.length;i++){
			arr2[i]="";
		}
		for(int i=0;i<arr1.length;i++){
				str+=arr1[i];
				if(!(arr2[i].isEmpty())){
					str+=" as " + arr2[i];
				}
				if(i<arr1.length - 1){
					str+=", ";
				}	
			}
		
		return str;
	}
	public String getWhereCondition(Table table){
		String str;
		if (table.getValue().matches("^[0-9]*$")){
			str=table.getValue();	
		}
		else{
			str="'"+table.getValue()+"'";
		}
		if(table.getColumnName() != ""){
			return " where "+table.getColumnName()+table.getOperator()+str;
		}
		else{
			return "";
		}
	}
	public String getOrderBy(Table table){
		if(table.getOrderColumn() !=""){
			return " order by "+table.getOrderColumn()+" "+table.getOrderValue();
		}
		else{
			return "";
		}
	}
	public void generateQuery(Table table){
		String sql="select "+getFinalField(table)+" from "+table.getTableName()+getWhereCondition(table)+getOrderBy(table)+";";
		table.setResultQuery(sql);
		System.out.println(table.getColumnName());
	}
	
	public List<TableMetaData> allTableMetaData(Table table){
		return tabledataRepository.findAllData(table.getTableName());
	}
}
