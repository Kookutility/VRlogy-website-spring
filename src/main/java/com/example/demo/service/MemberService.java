package com.example.demo.service;

import com.example.demo.domain.MemberInfo;
import com.example.demo.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    @Transactional
    public boolean updateName(String username, String newName) {
        MemberInfo member = memberRepository.findByUsername(username);
        if (member != null) {
            member.setName(newName);
            memberRepository.save(member);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updateEmail(String currentUsername, String newEmail) {
        MemberInfo member = memberRepository.findByUsername(currentUsername);
        if (member != null) {
            member.setUsername(newEmail);
            memberRepository.save(member);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updatePassword(String username, String newPassword) {
        MemberInfo member = memberRepository.findByUsername(username);
        if (member != null) {
            member.setPassword(newPassword); // 비밀번호 암호화 로직 추가 필요
            memberRepository.save(member);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updatePhoneNumber(String username, String newPhoneNumber) {
        MemberInfo member = memberRepository.findByUsername(username);
        if (member != null) {
            member.setPhoneNumber(newPhoneNumber);
            memberRepository.save(member);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updateAddress(String username, String newAddress) {
        MemberInfo member = memberRepository.findByUsername(username);
        if (member != null) {
            member.setAddress(newAddress);
            memberRepository.save(member);
            return true;
        }
        return false;
    }

    @Transactional
    public boolean updatePostcode(String username, String newPostcode) {
        MemberInfo member = memberRepository.findByUsername(username);
        if (member != null) {
            member.setPostcode(newPostcode);
            memberRepository.save(member);
            return true;
        }
        return false;
    }
    public MemberInfo getMemberInfoByUsername(String username) {
        return memberRepository.findByUsername(username);
    }

}

