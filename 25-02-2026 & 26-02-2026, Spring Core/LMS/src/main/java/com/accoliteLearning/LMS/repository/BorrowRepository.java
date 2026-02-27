package com.accoliteLearning.LMS.repository;

import com.accoliteLearning.LMS.model.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<BorrowRecord, Integer> {}