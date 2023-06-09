package com.youth.moim.member.common;

import com.youth.moim.member.domain.Gender;
import com.youth.moim.member.dto.JoinOrganizerMemberRequest;
import com.youth.moim.member.dto.JoinParticipantMemberRequest;

import java.time.LocalDate;

public class MemberFixture {

    public static final JoinOrganizerMemberRequest joinOrganizerMemberRequest = new JoinOrganizerMemberRequest(
            "John Doe",
            LocalDate.of(1990, 5, 15),
            Gender.MALE,
            "john123",
            "pass123",
            "john.doe@example.com",
            "Team A"
    );

    public static final JoinParticipantMemberRequest joinParticipantMemberRequest = new JoinParticipantMemberRequest(
            "John Doe",
            LocalDate.of(1990, 5, 15),
            Gender.MALE,
            "john123",
            "pass123",
            "john.doe@example.com",
            "계란",
            "안녕하세요 :)");
}
