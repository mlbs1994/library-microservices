package com.mlbs.booksapi.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<Void> handleEntityNotFoundException() {
		return ResponseEntity.notFound().build();
	}

}
