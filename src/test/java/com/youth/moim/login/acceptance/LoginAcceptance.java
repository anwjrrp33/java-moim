package com.youth.moim.login.acceptance;

import com.youth.moim.common.AcceptanceTest;
import com.youth.moim.common.TokenFixture;
import com.youth.moim.login.dto.TokenRequest;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static com.youth.moim.member.acceptance.MemberAcceptanceTest.주최자_회원가입;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginAcceptance extends AcceptanceTest {

    @BeforeEach
    public void setUp() {
        super.setUp();
        주최자_회원가입();
    }

    @DisplayName("사용자가 로그인을 한다.")
    @Test
    void login() {
        ExtractableResponse<Response> response = 사용자_로그인();

        토큰_생성됨(response);
    }

    public static ExtractableResponse<Response> 사용자_로그인() {
        TokenRequest tokenRequest = TokenFixture.tokenRequest;

        return RestAssured
                .given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(tokenRequest)
                .when().post("/login")
                .then().log().all()
                .extract();
    }

    public static void 토큰_생성됨(ExtractableResponse<Response> response) {
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.jsonPath().get("token").toString()).isNotEmpty();
    }
}
