package com.youth.moim.member.acceptance;

import com.youth.moim.common.AcceptanceTest;
import com.youth.moim.common.MemberFixture;
import com.youth.moim.member.dto.JoinOrganizerMemberRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberAcceptanceTest extends AcceptanceTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
    }

    @DisplayName("사용자가 주최자로 회원가입을 한다.")
    @Test
    void joinOrganizerMember() {
        ExtractableResponse<Response> response = 주최자_회원가입();

        회원_생성됨(response);
    }

    @DisplayName("사용자가 참여자로 회원가입을 한다.")
    @Test
    void joinParticipantMember() {
        ExtractableResponse<Response> response = 참여자_회원가입();

        회원_생성됨(response);
    }

    public static ExtractableResponse<Response> 주최자_회원가입() {
        JoinOrganizerMemberRequest joinOrganizerMemberRequest = MemberFixture.joinOrganizerMemberRequest;

        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(joinOrganizerMemberRequest)
                .when().post("/member/organizer")
                .then().log().all()
                .extract();
    }

    public static ExtractableResponse<Response> 참여자_회원가입() {
        JoinOrganizerMemberRequest joinOrganizerMemberRequest = MemberFixture.joinOrganizerMemberRequest;

        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(joinOrganizerMemberRequest)
                .when().post("/member/organizer")
                .then().log().all()
                .extract();
    }

    public static void 회원_생성됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }
}
