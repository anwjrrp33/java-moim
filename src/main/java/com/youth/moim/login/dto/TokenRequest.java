package com.youth.moim.login.dto;

public class TokenRequest {

    private String memberId;

    private String password;

    public TokenRequest() {
    }

    public TokenRequest(String memberId, String password) {
        this.memberId = memberId;
        this.password = password;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getPassword() {
        return password;
    }
}
