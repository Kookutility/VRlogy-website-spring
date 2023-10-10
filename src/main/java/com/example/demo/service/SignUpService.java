package com.example.demo.service;

import com.example.demo.domain.MemberInfo;
import com.example.demo.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class SignUpService {

    private final MemberRepository memberRepository;

    public SignUpService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public boolean isUsernameAlreadyTaken(String username) {
        return memberRepository.countByUsername(username) > 0;
    }

    public void signUp(MemberInfo member) {
        // no password encoding
        memberRepository.save(member);
    }
}