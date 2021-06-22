package com.ekahau.exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekahau.exercise.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
