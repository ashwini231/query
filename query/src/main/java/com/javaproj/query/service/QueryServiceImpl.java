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
	
	public void generateQuery(Table table){
		String sql="select "+table.getFieldName()+" from "+table.getTableName()+";";
		table.setResultQuery(sql);
		
	}
	
	public List<TableMetaData> allTableMetaData(){
		return tabledataRepository.findAllData();
	}
}
