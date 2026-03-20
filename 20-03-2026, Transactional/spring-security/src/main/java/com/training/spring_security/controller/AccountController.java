package com.training.spring_security.controller;

import com.training.spring_security.entity.Account;
import com.training.spring_security.service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @PostMapping
    public Account create(@RequestParam String name,
                          @RequestParam double balance) {
        return service.createAccount(name, balance);
    }

    @PostMapping("/fail")
    public String q1() {
        service.createOrderAndFail();
        return "fail";
    }

    @PostMapping("/q2/fail")
    public String q2Fail() throws Exception {
        service.checkedExceptionFail();
        return "done";
    }

    @PostMapping("/q2/fix")
    public String q2Fix() throws Exception {
        service.checkedExceptionFix();
        return "done";
    }

    @PostMapping("/q3")
    public String q3() {
        service.mainWithSub();
        return "done";
    }

    @PostMapping("/q4/problem")
    public String q4Problem() {
        service.outer();
        return "done";
    }

    @PostMapping("/q4/fix")
    public String q4Fix() {
        service.outerFixed();
        return "done";
    }

    @PostMapping("/q5")
    public String q5() {
        service.multiThreadTest();
        return "done";
    }

    @PostMapping("/q6/fail")
    public String q6Fail() {
        service.trap();
        return "done";
    }

    @PostMapping("/q6/fix")
    public String q6Fix() {
        service.trapFix();
        return "done";
    }

    @PostMapping("/q7")
    public String q7(@RequestParam Long from,
                     @RequestParam Long to,
                     @RequestParam double amount) {
        service.transfer(from, to, amount);
        return "done";
    }

    @PostMapping("/q8")
    public String q8() {
        service.readOnlyTest();
        return "done";
    }
}