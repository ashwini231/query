package com.javaproj.query.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.javaproj.query.model.*;

@Repository
public interface TableDataRepository extends JpaRepository<TableMetaData, String>{
	@Query(value = "SELECT column_name, data_type from INFORMATION_SCHEMA.COLUMNS where table_name ='employee'", nativeQuery = true)
    List<TableMetaData> findAllData();
}
