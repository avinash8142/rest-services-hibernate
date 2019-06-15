package com.web.restserviceshibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.restserviceshibernate.model.AfuInfo;
import com.web.restserviceshibernate.service.AfuService;

@RestController
public class AfuController {

	@Autowired
	private AfuService afuService;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping()
	{
		return new ResponseEntity<String>("Success",HttpStatus.OK);
	}
	
	@GetMapping("/afu-info")
	public ResponseEntity<AfuInfo> getAfuInfo()
	{
		return new ResponseEntity<AfuInfo>(afuService.getAfuInfo(),HttpStatus.OK);
		
	}
}
