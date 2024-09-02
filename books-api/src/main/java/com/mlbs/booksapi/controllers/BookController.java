package com.mlbs.booksapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
	
	@GetMapping
	public ResponseEntity<Page<ReadBookDTO>> list(@PageableDefault(size = 5, sort = "title") Pageable pagination) {
		return ResponseEntity.ok(service.list(pagination));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReadBookDTO> get(@PathVariable Integer id) {
		return ResponseEntity.ok(service.read(id)); 
	}
	

}
