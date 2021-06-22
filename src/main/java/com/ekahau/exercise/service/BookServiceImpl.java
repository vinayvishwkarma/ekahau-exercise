package com.ekahau.exercise.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekahau.exercise.exception.BookNotFoundExcpetion;
import com.ekahau.exercise.model.Book;
import com.ekahau.exercise.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book findByBookId(Long id) {
		return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundExcpetion(Long.toString(id)));
	}

	@Override
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}

}
