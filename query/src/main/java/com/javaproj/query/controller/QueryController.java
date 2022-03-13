package com.javaproj.query.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaproj.query.datasource.DataSourceConfig;
import com.javaproj.query.model.*;
import com.javaproj.query.repository.TableDataRepository;
import com.javaproj.query.service.QueryService;
   

@Controller
public class QueryController {
	
	@Autowired
	private QueryService queryService;
	
	@GetMapping("/")
	public String home(Model model){
		Database database = new Database();
		model.addAttribute("database", database);
		return "home";
	}

	@PostMapping("/tableName")
	public String showTables(@ModelAttribute("database") Database database,Model model) {
		DataSourceConfig config= new DataSourceConfig();
		config.getDataSource();
		Table table = new Table();
		model.addAttribute("table", table);
		List<Tables> tables= queryService.allTables(database);
		model.addAttribute("tables",tables);
		return "main";
	}
	
	@PostMapping("/select")
	public String select( @ModelAttribute("table") Table table, Model model) {
		List<TableMetaData> data= queryService.allTableMetaData(table);
		model.addAttribute("data",data);
		return "index";
	}
	
	@PostMapping("/generateQuery")
	public String generateQuery(@ModelAttribute("table") Table table) {
		queryService.generateQuery(table);
		return "result";
	}

}
 