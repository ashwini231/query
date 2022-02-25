package com.javaproj.query.service;

import java.util.List;

import com.javaproj.query.model.*;

public interface QueryService {
	void generateQuery(Table table);
	 List<TableMetaData> allTableMetaData();
}
