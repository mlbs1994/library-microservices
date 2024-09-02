package com.mlbs.booksapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mlbs.booksapi.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
