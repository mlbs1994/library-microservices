package com.mlbs.booksapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mlbs.booksapi.domain.Book;
import com.mlbs.booksapi.dto.CreateBookDTO;
import com.mlbs.booksapi.dto.ReadBookDTO;
import com.mlbs.booksapi.dto.UpdateBookDTO;
import com.mlbs.booksapi.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository repository;
	
	public ReadBookDTO create(CreateBookDTO data) {
		return new ReadBookDTO(repository.save(new Book(data)));
	}
	
	public ReadBookDTO read(Integer id) {
		return new ReadBookDTO(repository.getReferenceById(id));
	}
	
	public Page<ReadBookDTO> list(Pageable pagination) {
		return repository.findAll(pagination).map(ReadBookDTO::new);
	}
	
	public void update(UpdateBookDTO data) {
		Book book = repository.getReferenceById(data.id());
		book.updateFields(data);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	
}
