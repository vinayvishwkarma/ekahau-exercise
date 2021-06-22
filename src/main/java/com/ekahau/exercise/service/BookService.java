package com.ekahau.exercise.service;

import java.util.List;

import com.ekahau.exercise.model.Book;

public interface BookService {

	List<Book> getAllBooks();

	public Book findByBookId(Long id);

	public Book saveBook(Book book);

	public void deleteBook(Long id);

}
