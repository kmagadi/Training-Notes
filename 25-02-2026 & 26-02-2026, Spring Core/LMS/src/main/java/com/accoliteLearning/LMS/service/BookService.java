package com.accoliteLearning.LMS.service;

import com.accoliteLearning.LMS.model.Book;
import com.accoliteLearning.LMS.repository.BookRepository; // Import your repo
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void addBook(Book newBook) {
        // .save() is a built-in JPA method for both Create and Update
        bookRepository.save(newBook);
    }

    public Book getSpecBook(Integer id) {
        // .findById() returns an Optional in case the ID doesn't exist
        return bookRepository.findById(id).orElse(null);
    }

    public List<Book> getAllBooks() {
        // .findAll() retrieves all rows from the H2 'book' table
        return bookRepository.findAll();
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}