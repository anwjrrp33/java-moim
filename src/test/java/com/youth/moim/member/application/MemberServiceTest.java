package com.youth.moim.member.application;

import com.youth.moim.common.MemberFixture;
import com.youth.moim.member.domain.Member;
import com.youth.moim.member.dto.JoinOrganizerMemberRequest;
import com.youth.moim.member.dto.JoinOrganizerMemberResponse;
import com.youth.moim.member.dto.JoinParticipantMemberRequest;
import com.youth.moim.member.dto.JoinParticipantMemberResponse;
import com.youth.moim.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private MemberService memberService;

    @DisplayName("사용자가 주최자로 회원가입을 한다.")
    @Test
    void joinOrganizerMember() {
        JoinOrganizerMemberRequest joinOrganizerMemberRequest = MemberFixture.joinOrganizerMemberRequest;
        Member member = joinOrganizerMemberRequest.toMember(passwordEncoder);
        when(memberRepository.save(any())).thenReturn(member);

        JoinOrganizerMemberResponse result = memberService.joinOrganizerMember(joinOrganizerMemberRequest);

        assertAll(
                () -> assertThat(result.getName()).isEqualTo(joinOrganizerMemberRequest.getName()),
                () -> assertThat(result.getMemberId()).isEqualTo(joinOrganizerMemberRequest.getMemberId()),
                () -> assertThat(result.getEmail()).isEqualTo(joinOrganizerMemberRequest.getEmail()),
                () -> assertThat(result.getTeamName()).isEqualTo(joinOrganizerMemberRequest.getTeamName())
        );
    }

    @DisplayName("사용자가 참여자로 회원가입을 한다.")
    @Test
    void joinParticipantMember() {
        JoinParticipantMemberRequest joinParticipantMemberRequest = MemberFixture.joinParticipantMemberRequest;
        Member member = joinParticipantMemberRequest.toMember(passwordEncoder);
        when(memberRepository.save(any())).thenReturn(member);

        JoinParticipantMemberResponse result = memberService.joinParticipantMember(joinParticipantMemberRequest);

        assertAll(
                () -> assertThat(result.getName()).isEqualTo(joinParticipantMemberRequest.getName()),
                () -> assertThat(result.getMemberId()).isEqualTo(joinParticipantMemberRequest.getMemberId()),
                () -> assertThat(result.getEmail()).isEqualTo(joinParticipantMemberRequest.getEmail()),
                () -> assertThat(result.getFoodAllergy()).isEqualTo(joinParticipantMemberRequest.getFoodAllergy()),
                () -> assertThat(result.getInfo()).isEqualTo(joinParticipantMemberRequest.getInfo())
        );
    }
}