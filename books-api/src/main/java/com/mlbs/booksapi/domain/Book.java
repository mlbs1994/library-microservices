package com.mlbs.booksapi.domain;

import java.time.LocalDateTime;

import com.mlbs.booksapi.dto.CreateBookDTO;
import com.mlbs.booksapi.dto.UpdateBookDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "Book")
@Table(name = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true)
	private String isbn;

	@Column(name = "inventory_quantity")
	private Integer inventoryQuantity;
	
	private String title; 
	private String author; 
	private LocalDateTime publisherDate;
	private String publisher;

	public Book(CreateBookDTO data) {
		this.title = data.title();
		this.author = data.author();
		this.publisherDate = data.publisherDate();
		this.publisher = data.publisher();
		this.isbn = data.isbn();
		this.inventoryQuantity = data.inventoryQuantity();
	}

	public void updateFields(UpdateBookDTO data) {
		if (data.title() != null) this.title = data.title();
		if (data.author() != null) this.author = data.author();
		if (data.publisherDate() != null) this.publisherDate = data.publisherDate();
		if (data.publisher() != null) this.publisher = data.publisher();
		if (data.isbn() != null) this.isbn = data.isbn();
		if (data.inventoryQuantity() != null) this.inventoryQuantity = data.inventoryQuantity();
	}
	
}
