package com.accoliteLearning.LMS.controller;

import com.accoliteLearning.LMS.model.Member;
import com.accoliteLearning.LMS.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memService;

    @GetMapping
    public List<Member> getAllMembers() {
        return memService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getSpecMember(@PathVariable Integer id) {
        return memService.getSpecMember(id);
    }

    @PostMapping
    public boolean addMember(@RequestBody Member newMember) {
        memService.addMember(newMember);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean removeMember(@PathVariable Integer id) {
        if (memService.containsID(id)) {
            memService.removeMemberById(id);
            return true;
        }
        return false;
    }
}