package com.accoliteLearning.LMS.repository;

import com.accoliteLearning.LMS.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    // Basic CRUD methods are inherited automatically
}