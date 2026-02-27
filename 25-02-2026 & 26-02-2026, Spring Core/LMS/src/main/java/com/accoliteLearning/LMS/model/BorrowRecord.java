package com.accoliteLearning.LMS.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "borrow_record")
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne // This links to the Book entity
    @JoinColumn(name = "book_id")
    private Book book; // This MUST be the Book object, not String

    private Integer memberId;
    private LocalDateTime borrowTime;
    private LocalDateTime returnTime;

    public void setBook(Book book) {
    }
}