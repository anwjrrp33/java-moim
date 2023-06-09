package com.youth.moim.login.application;

import com.youth.moim.common.jwt.JwtProvider;
import com.youth.moim.login.dto.TokenRequest;
import com.youth.moim.login.dto.TokenResponse;
import com.youth.moim.member.domain.Member;
import com.youth.moim.member.repository.MemberRepository;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final MemberRepository memberRepository;

    private final JwtProvider jwtProvider;

    private final PasswordEncoder passwordEncoder;

    public LoginService(MemberRepository memberRepository, JwtProvider jwtProvider, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.jwtProvider = jwtProvider;
        this.passwordEncoder = passwordEncoder;
    }

    public TokenResponse login(TokenRequest tokenRequest) {
        Member member = memberRepository.findByMemberId(tokenRequest.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("사용자가 존재하지 않습니다."));
        member.checkPassword(passwordEncoder, tokenRequest.getPassword());
        System.out.println("====================================");
        System.out.println(jwtProvider.createToken(member.getId()));
        return new TokenResponse(jwtProvider.createToken(member.getId()));
    }
}
