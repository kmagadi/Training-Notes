package com.training.spring_security.service;

import com.training.spring_security.entity.Account;
import com.training.spring_security.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountSubService {

    private final AccountRepository repo;

    public AccountSubService(AccountRepository repo) {
        this.repo = repo;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void subMethod() {
        repo.save(new Account(null, "SubTx", 200));
        throw new RuntimeException("Sub failed");
    }
}