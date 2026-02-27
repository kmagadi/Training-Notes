package com.accoliteLearning.LMS.controller;

import com.accoliteLearning.LMS.dto.BookDTO;
import com.accoliteLearning.LMS.model.Book;
import com.accoliteLearning.LMS.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired private BookService bookService;

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody BookDTO bookDto) {
        Book book = new Book();
        book.setBookName(bookDto.getBookName());
        book.setGenre(bookDto.getGenre());
        book.setAuthor(bookDto.getAuthor());

        bookService.addBook(book);
        return ResponseEntity.ok("Book added successfully!");
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }
}