package com.accoliteLearning.LMS.controller;

import com.accoliteLearning.LMS.dto.BorrowRecordDTO;
import com.accoliteLearning.LMS.model.BorrowRecord;
import com.accoliteLearning.LMS.service.BorrowService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    // Issue a book using DTO
    @PostMapping("/issue")
    public ResponseEntity<BorrowRecord> borrowBook(@Valid @RequestBody BorrowRecordDTO request) {
        BorrowRecord record = borrowService.borrowBook(request.getBookId(), request.getMemberId());
        return ResponseEntity.ok(record);
    }

    // Return a book using DTO
    @PostMapping("/return")
    public ResponseEntity<BorrowRecord> returnBook(@Valid @RequestBody BorrowRecordDTO request) {
        BorrowRecord record = borrowService.returnBook(request.getBookId(), request.getMemberId());
        return ResponseEntity.ok(record);
    }

    // Get all borrow history
    @GetMapping
    public ResponseEntity<List<BorrowRecord>> getAllBorrows() {
        return ResponseEntity.ok(borrowService.getAllRecords());
    }
}