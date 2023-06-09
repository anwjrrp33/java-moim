package com.youth.moim.member.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

class MemberTest {

    @DisplayName("주최자를 생성한다.")
    @Test
    void joinMemberOrganizer() {
        assertThatCode(() -> Member.of(
                "John Doe",
                LocalDate.of(1990, 5, 15),
                Gender.MALE,
                "john123",
                "pass123",
                "john.doe@example.com",
                new OrganizerInfo("Team A")))
                .doesNotThrowAnyException();
    }

    @DisplayName("참여자를 생성한다.")
    void joinMemberParticipant() {
        assertThatCode(() -> Member.of(
                "John Doe",
                LocalDate.of(1990, 5, 15),
                Gender.MALE,
                "john123",
                "pass123",
                "john.doe@example.com",
                new ParticipantInfo("계란", "안녕하세요 :)")))
                .doesNotThrowAnyException();
    }
}