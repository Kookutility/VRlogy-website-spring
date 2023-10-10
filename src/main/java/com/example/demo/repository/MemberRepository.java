package com.example.demo.repository;

import com.example.demo.domain.MemberInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberInfo, Integer> {

    MemberInfo findByUsername(String username);
    int countByUsername(String username);
}
