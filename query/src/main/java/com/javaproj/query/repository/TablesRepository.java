package com.javaproj.query.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.javaproj.query.model.*;

@Repository
public interface TablesRepository extends JpaRepository<Tables, String>{
	
	@Query(value = "SELECT table_name FROM information_schema.tables WHERE table_schema= ?1",nativeQuery = true )
	List<Tables> findAllTables(String dbname);
}
