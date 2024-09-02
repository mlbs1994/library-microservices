package com.mlbs.booksapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mlbs.booksapi.dto.ReadBookDTO;
import com.mlbs.booksapi.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<ReadBookDTO> get(@PathVariable Integer id) {
		return ResponseEntity.ok(service.read(id)); 
	}

}
