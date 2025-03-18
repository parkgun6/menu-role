package com.phiworks.security.service;

import com.phiworks.security.entity.Member;
import com.phiworks.security.dto.MemberDTO;
import com.phiworks.security.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername........");
        log.info(username+" : username........");

        Optional<Member> result = memberRepository.findByEmail(username);
        if (result.isEmpty()) throw new UsernameNotFoundException("Check Email....");

        Member member = result.get();
        Set<GrantedAuthority> authorities = member.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getAuthority()))
                .collect(Collectors.toSet());

        MemberDTO memberDTO = new MemberDTO(
                member.getEmail(),
                member.getPassword(),
                authorities
        );

        memberDTO.setName(member.getName());
        log.info(memberDTO.toString());

        return memberDTO;
    }
}
