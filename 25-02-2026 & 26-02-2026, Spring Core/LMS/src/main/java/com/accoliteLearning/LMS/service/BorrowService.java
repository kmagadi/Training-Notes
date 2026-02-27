package com.accoliteLearning.LMS.service;

import com.accoliteLearning.LMS.model.Book;
import com.accoliteLearning.LMS.model.BorrowRecord;
import com.accoliteLearning.LMS.repository.BookRepository;
import com.accoliteLearning.LMS.repository.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    @Autowired
    private BookRepository bookRepository;

    public BorrowRecord borrowBook(Integer bookId, Integer memberId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found with ID: " + bookId));

        BorrowRecord record = new BorrowRecord();

        record.setBook(book);
        record.setMemberId(memberId);
        record.setBorrowTime(LocalDateTime.now());
        record.setReturnTime(null);

        return borrowRepository.save(record);
    }

    public BorrowRecord returnBook(Integer bookId, Integer memberId) {
        List<BorrowRecord> records = borrowRepository.findAll();

        BorrowRecord activeRecord = records.stream()
                .filter(r -> r.getBook() != null && r.getBook().getId().equals(bookId)
                        && r.getMemberId().equals(memberId)
                        && r.getReturnTime() == null)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No active borrow record found"));

        activeRecord.setReturnTime(LocalDateTime.now());
        return borrowRepository.save(activeRecord);
    }

    public List<BorrowRecord> getAllRecords() {
        return borrowRepository.findAll();
    }
}