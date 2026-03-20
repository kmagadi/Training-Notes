package com.training.spring_security.service;

import com.training.spring_security.entity.Account;
import com.training.spring_security.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AccountService {

    private final AccountRepository repo;
    private final AccountSubService subService;
    private final InnerService innerService;

    public AccountService(AccountRepository repo,
                          AccountSubService subService,
                          InnerService innerService) {
        this.repo = repo;
        this.subService = subService;
        this.innerService = innerService;
    }

    // ✅ Q1
    @Transactional
    public void createOrderAndFail() {
        repo.save(new Account(null, "OrderUser", 100));
        throw new RuntimeException("Payment failed");
    }

    // ✅ Normal
    @Transactional
    public Account createAccount(String name, double balance) {
        return repo.save(new Account(null, name, balance));
    }

    // ❌ Q2 fail
    @Transactional
    public void checkedExceptionFail() throws Exception {
        repo.save(new Account(null, "CheckedFail", 100));
        throw new Exception("Checked exception");
    }

    // ✅ Q2 fix
    @Transactional(rollbackFor = Exception.class)
    public void checkedExceptionFix() throws Exception {
        repo.save(new Account(null, "CheckedFix", 100));
        throw new Exception("Checked exception");
    }

    // ✅ Q3
    @Transactional
    public void mainWithSub() {
        repo.save(new Account(null, "MainTx", 100));

        try {
            subService.subMethod();
        } catch (Exception e) {
            System.out.println("Sub failed");
        }
    }

    // ❌ Q4 problem
    @Transactional
    public void outer() {
        inner(); // self-invocation (no proxy)
    }

    @Transactional
    public void inner() {
        repo.save(new Account(null, "InnerFail", 100));
    }

    // ✅ Q4 fix
    public void outerFixed() {
        innerService.inner();
    }

    // ✅ Q5
    @Transactional
    public void multiThreadTest() {
        repo.save(new Account(null, "MainThread", 100));

        new Thread(() -> {
            repo.save(new Account(null, "ChildThread", 200));
        }).start();
    }

    // ❌ Q6 trap
    @Transactional
    public void trap() {
        try {
            repo.save(new Account(null, "Trap", 100));
            throw new RuntimeException("fail");
        } catch (Exception e) {
            // swallowed
        }
    }

    // ✅ Q6 fix
    @Transactional
    public void trapFix() {
        try {
            repo.save(new Account(null, "TrapFix", 100));
            throw new RuntimeException("fail");
        } catch (Exception e) {
            throw e;
        }
    }

    // ✅ Q7
    @Transactional
    public void transfer(Long fromId, Long toId, double amount) {

        Account from = repo.findById(fromId).orElseThrow();
        Account to = repo.findById(toId).orElseThrow();

        from.setBalance(from.getBalance() - amount);
        repo.save(from);

        throw new RuntimeException("Credit failed");

        // unreachable
        // to.setBalance(to.getBalance() + amount);
        // repo.save(to);
    }

    // ✅ Q8
    @Transactional(readOnly = true)
    public void readOnlyTest() {
        repo.save(new Account(null, "ReadOnly", 100));
    }
}