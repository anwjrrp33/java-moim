package com.youth.moim.member.application;

import com.youth.moim.member.domain.Member;
import com.youth.moim.member.dto.JoinOrganizerMemberRequest;
import com.youth.moim.member.dto.JoinOrganizerMemberResponse;
import com.youth.moim.member.dto.JoinParticipantMemberRequest;
import com.youth.moim.member.dto.JoinParticipantMemberResponse;
import com.youth.moim.member.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final PasswordEncoder passwordEncoder;

    public MemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public JoinOrganizerMemberResponse joinOrganizerMember(JoinOrganizerMemberRequest joinOrganizerMemberRequest) {
        Member member = memberRepository.save(joinOrganizerMemberRequest.toMember(passwordEncoder));
        return new JoinOrganizerMemberResponse(
                member.getId(),
                member.getName(),
                member.getBirthDate(),
                member.getGender(),
                member.getMemberId(),
                member.getEmail(),
                member.getTeam());
    }


    public JoinParticipantMemberResponse joinParticipantMember(JoinParticipantMemberRequest joinParticipantMemberRequest) {
        Member member = memberRepository.save(joinParticipantMemberRequest.toMember(passwordEncoder));
        return new JoinParticipantMemberResponse(
                member.getId(),
                member.getName(),
                member.getBirthDate(),
                member.getGender(),
                member.getMemberId(),
                member.getEmail(),
                member.getFoodAllergy(),
                member.getInfo());
    }
}
