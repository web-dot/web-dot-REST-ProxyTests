package com.estore.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estore.service.PrimaryService;

@RestController
@RequestMapping("/api")
public class EstorePrimaryEndpoint {

	
	@Autowired
	PrimaryService fileDownloadService;
	
	@PostMapping("/saveProduct/{name}")
	public void saveProduct(@PathVariable String name) {
		System.err.println(name);
	}
	
	
}
