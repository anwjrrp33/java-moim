package com.youth.moim.common;

import com.youth.moim.member.domain.Gender;
import com.youth.moim.member.domain.Member;
import com.youth.moim.member.domain.OrganizerInfo;
import com.youth.moim.member.domain.ParticipantInfo;
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
            "{bcrypt}$2a$10$5Cp6s.Z1SfZ//7WkZmfGkOkuzzOZSNrejd124tvDxn8vOuyAXVbLK",
            "john.doe@example.com",
            "계란",
            "안녕하세요 :)");

    public static final Member organizerInfoMember = Member.of(1L, "John Doe",
            LocalDate.of(1990, 5, 15),
            Gender.MALE,
            "john123",
            "{bcrypt}$2a$10$5Cp6s.Z1SfZ//7WkZmfGkOkuzzOZSNrejd124tvDxn8vOuyAXVbLK",
            "john.doe@example.com",
            new OrganizerInfo("Team A"));
}
