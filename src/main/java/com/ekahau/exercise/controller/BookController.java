package com.ekahau.exercise.controller;

import static org.springframework.http.ResponseEntity.status;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ekahau.exercise.model.Book;
import com.ekahau.exercise.service.BookService;

@RestController
@RequestMapping("api/v1/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping
	public ResponseEntity<List<Book>> listBooks() {
		return status(HttpStatus.OK).body(bookService.getAllBooks());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> findByBookId(@PathVariable Long id) {
		return status(HttpStatus.OK).body(bookService.findByBookId(id));
	}

	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		return status(HttpStatus.CREATED).body(bookService.saveBook(book));
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Long id) {
		bookService.deleteBook(id);
		return status(HttpStatus.OK).body("book " + id+ " deleted");

	}

}
