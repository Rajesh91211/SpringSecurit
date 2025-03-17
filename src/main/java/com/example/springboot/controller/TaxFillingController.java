package com.example.springboot.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/tax")
@EnableMethodSecurity(prePostEnabled = true)
public class TaxFillingController {

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	private String createtaxFile()
	{
		return "Tax filling is regist";
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping
	@PreAuthorize("hasRole('ADMIN')") //only admin can access this method
	public List<String> getAlltaxs()
	{
		List<String> all = new ArrayList<>(Arrays.asList("Raj","Ram","Rahul"));
		return all;
	}
	
}
