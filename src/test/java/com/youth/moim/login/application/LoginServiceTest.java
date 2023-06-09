package com.youth.moim.login.application;

import com.youth.moim.common.MemberFixture;
import com.youth.moim.common.TokenFixture;
import com.youth.moim.common.jwt.JwtProvider;
import com.youth.moim.login.dto.TokenRequest;
import com.youth.moim.login.dto.TokenResponse;
import com.youth.moim.member.domain.Member;
import com.youth.moim.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LoginServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtProvider jwtProvider;

    @InjectMocks
    private LoginService loginService;

    @DisplayName("사용자가 로그인을 한다.")
    @Test
    void login() {
        TokenRequest tokenRequest = TokenFixture.tokenRequest;
        Member member = MemberFixture.organizerInfoMember;
        when(passwordEncoder.matches(any(), any())).thenReturn(true);
        when(memberRepository.findByMemberId(any())).thenReturn(Optional.of(member));
        when(jwtProvider.createToken(member.getId())).thenReturn("ASDDASFJDSALFJ");

        TokenResponse result = loginService.login(tokenRequest);

        assertThat(result.getToken()).isNotEmpty();
    }
}