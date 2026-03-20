package com.training.spring_security.service;

import com.training.spring_security.entity.Account;
import com.training.spring_security.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InnerService {

    private final AccountRepository repo;

    public InnerService(AccountRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public void inner() {
        repo.save(new Account(null, "InnerSuccess", 100));
    }
}