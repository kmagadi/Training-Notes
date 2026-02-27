package com.accoliteLearning.LMS.service;

import com.accoliteLearning.LMS.model.Member;
import com.accoliteLearning.LMS.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    // Renamed from addBook for clarity
    public void addMember(Member newMember) {
        memberRepository.save(newMember);
    }

    public boolean containsID(Integer id) {
        return memberRepository.existsById(id);
    }

    public void removeMemberById(Integer id) {
        memberRepository.deleteById(id);
    }

    public Member getSpecMember(Integer id) {
        return memberRepository.findById(id).orElse(null);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}