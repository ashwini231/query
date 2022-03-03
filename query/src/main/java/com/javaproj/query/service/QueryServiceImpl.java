package com.javaproj.query.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaproj.query.model.*;
import com.javaproj.query.repository.*;

@Service
public class QueryServiceImpl implements QueryService{
	@Autowired
	private TableDataRepository tabledataRepository ;
	@Autowired
	private TablesRepository tablesRepository ;
	
	public boolean validateAliasName(String name){
		if(name.matches("[a-zA-Z0-9_]+")){
			return true;
		}
		return false;
	}
	public String getFinalField(Table table){
		String str="";
		String[] arr1 = table.getFieldName().split(",",-2);
		String[] arr2 = table.getAliasName().split(",",-2);

		List<TableMetaData> data= allTableMetaData(table);
		for(int i = 0; i < data.size(); i++){
			for(int j=0;j<arr1.length;j++){
				if(data.get(i).getColumnName().equals( arr1[j])){
					str+=arr1[j];
					if(!(arr2[i].isEmpty()) && validateAliasName(arr2[i])){
						str+=" as "+arr2[i];
					}
					if(j<arr1.length -1){
						str+=", ";
					}
					break;
				}
			}
		}
		return str;
	}
	public String getWhereCondition(Table table){
		String str="";
		String[] arr1 = table.getColumnName().split(",",-2);
		String[] arr2 = table.getOperator().split(",",-2);
		String[] arr3 = table.getValue().split(",",-2);
		String[] arr4 = table.getLogicaloperator().split(",",-2);

		if(!(arr1[0].isEmpty())){
			str+=" where "+arr1[0]+arr2[0]+arr3[0];
			for(int i=0;i<arr4.length;i++){
				if(!(arr4[i].isEmpty())){
					str+=arr4[i] + arr1[i+1]+arr2[i+1]+arr3[i+1];
				}	
			}
		}		
		return str;
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
		
	}
	public void testQuery(Table table){
		
	}
	public List<TableMetaData> allTableMetaData(Table table){
		return tabledataRepository.findAllData(table.getTableName());
	}
	public List<Tables> allTables(Database database){
		return tablesRepository.findAllTables(database.getDbname());
	}
}
