package com.mlbs.booksapi.dto;


import java.time.LocalDateTime;

import com.mlbs.booksapi.domain.Book;

public record ReadBookDTO(
	Integer id,
    String title,
    String author,
    Integer inventoryQuantity,
    String isbn,
    LocalDateTime publisherDate,
    String publisher
) {

	public ReadBookDTO(Book book) {
		this(
	            book.getId(),
	            book.getTitle(),
	            book.getAuthor(),
	            book.getInventoryQuantity(),
	            book.getIsbn(),
	            book.getPublisherDate(),
	            book.getPublisher()
	        );
	}

}
