package com.ekahau.exercise.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.ekahau.exercise.model.Book;
import com.ekahau.exercise.repository.BookRepository;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceImplTest {

	@InjectMocks
	private BookServiceImpl bookService;

	@Mock
	private BookRepository bookRepo;

	@Test
	public void testFindBookById() {
		Book book = new Book();
		book.setId(1000000l);
		book.setTitle("Test Book");
		book.setAuthor("Test author");
		book.setYear(1989);

		when(bookRepo.findById(book.getId())).thenReturn(Optional.of(book));

		Book foundBook = bookService.findByBookId(1000000l);

		assertEquals(book.getId(), foundBook.getId());
		assertEquals(book, foundBook);
	}
	
	@Test
	public void testFindAllBooks() {
		
		Book book1 = new Book("Test 1", "test author 1", 1978);
		Book book2 = new Book("Test 2", "test author 2", 1988);
		Book book3 = new Book("Test 3", "test author 3", 1992);
		Book book4 = new Book("Test 4", "test author 4", 1990);
		
		List<Book> books = Arrays.asList(book1, book2, book3, book4);
		

		when(bookRepo.findAll()).thenReturn(books);

		List<Book> actualBooks = bookService.getAllBooks();

		assertEquals(4, actualBooks.size());
		assertEquals(books, actualBooks);
	}
	
	@Test
	public void testCreateBook() {
		Book book = new Book();
		book.setTitle("Test Book");
		book.setAuthor("Test author");
		book.setYear(1989);

		when(bookRepo.save(book)).thenReturn(book);

		Book createdBook = bookService.saveBook(book);

		assertEquals(book.getId(), createdBook.getId());
		assertEquals(book, createdBook);
	}
	
	
}
