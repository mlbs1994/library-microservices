package com.mlbs.booksapi.dto;

import java.time.LocalDateTime;

public record CreateBookDTO(
    String title,
    String author,
    Integer inventoryQuantity,
    String isbn,
    LocalDateTime publisherDate,
    String publisher
) {}
