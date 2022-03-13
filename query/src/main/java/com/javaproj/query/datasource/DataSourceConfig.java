package com.javaproj.query.datasource;

import javax.sql.DataSource;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.lang.String;
import com.javaproj.query.model.Database;

@Configuration
public class DataSourceConfig {
	@Bean
    public DataSource getDataSource() {
		//String ip="jdbc:mysql://"+database.getUrl()+"/"+database.getDbname();
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();      
        dataSourceBuilder.url("jdbc:mysql://localhost:3306/ashwini");
        dataSourceBuilder.username("root");
        dataSourceBuilder.password("chinu@ash23@");
        return dataSourceBuilder.build();
    }
}
