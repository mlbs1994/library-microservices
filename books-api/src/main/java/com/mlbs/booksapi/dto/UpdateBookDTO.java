package com.mlbs.booksapi.dto;

import java.time.LocalDateTime;

public record UpdateBookDTO(
	Integer id,
    String title,
    String author,
    Integer inventoryQuantity,
    String isbn,
    LocalDateTime publisherDate,
    String publisher
) {}
