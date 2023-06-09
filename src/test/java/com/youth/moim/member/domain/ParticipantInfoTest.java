package com.youth.moim.member.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class ParticipantInfoTest {

    @DisplayName("참여자 정보를 생성한다.")
    @Test
    void participantInfo() {
        assertThatCode(() -> new ParticipantInfo("계란", "안녕하세요 :)"))
                .doesNotThrowAnyException();
    }
}