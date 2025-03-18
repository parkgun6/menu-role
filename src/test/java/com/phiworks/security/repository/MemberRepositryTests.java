package com.phiworks.security.repository;

import com.phiworks.security.entity.Member;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
@Log4j2
public class MemberRepositryTests {

    @Autowired
    MemberRepository repository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Test
    public void insertMember() {
        Member member = Member.builder()
                .email("admin123@test.com")
                .password(passwordEncoder.encode("admin123"))
                .name("홍길동")
                .build();
        repository.save(member);
    }
}
