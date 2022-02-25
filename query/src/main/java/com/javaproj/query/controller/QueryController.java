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

import com.javaproj.query.model.*;
import com.javaproj.query.repository.TableDataRepository;
import com.javaproj.query.service.QueryService;
   

@Controller
public class QueryController {
	
	@Autowired
	private QueryService queryService;

	@GetMapping("/")
	public String showQuery(Model model) {
		Table table = new Table();
		model.addAttribute("table", table);
		List<TableMetaData> data= queryService.allTableMetaData();
		model.addAttribute("data",data);
		return "index";
		
	}
	
	@PostMapping("/generateQuery")
	public String generateQuery(@ModelAttribute("table") Table table) {
		queryService.generateQuery(table);
		return "result";
	}
}
 