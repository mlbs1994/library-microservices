package com.mlbs.booksapi.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.mlbs.booksapi.dto.CreateBookDTO;
import com.mlbs.booksapi.dto.ReadBookDTO;
import com.mlbs.booksapi.dto.UpdateBookDTO;
import com.mlbs.booksapi.services.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping
	public ResponseEntity<Page<ReadBookDTO>> list(@PageableDefault(size = 10, sort = "title") Pageable pagination) {
		return ResponseEntity.ok(service.list(pagination));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ReadBookDTO> get(@PathVariable Integer id) {
		return ResponseEntity.ok(service.read(id)); 
	}
	
	@PostMapping
	public ResponseEntity<ReadBookDTO> create(@RequestBody CreateBookDTO data, UriComponentsBuilder uriComponentsBuilder) {
		ReadBookDTO createdBookDTO = service.create(data);
		URI uri = uriComponentsBuilder.path("/books/{id}").buildAndExpand(createdBookDTO.id()).toUri();
		return ResponseEntity.created(uri).body(createdBookDTO);
	}
	
	@PutMapping
	public ResponseEntity<ReadBookDTO> update(@RequestBody UpdateBookDTO data) {
		ReadBookDTO updatedBookDTO = service.update(data);
		return ResponseEntity.ok(updatedBookDTO);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		System.out.println("test");
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
