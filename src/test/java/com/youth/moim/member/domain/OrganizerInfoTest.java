package com.youth.moim.member.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;

class OrganizerInfoTest {

    @DisplayName("주최자 정보를 생성한다.")
    @Test
    void organizerInfo() {
        assertThatCode(() -> new OrganizerInfo("Team A"))
                .doesNotThrowAnyException();
    }
}