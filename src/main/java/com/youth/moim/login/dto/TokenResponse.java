package com.youth.moim.login.dto;

public class TokenResponse {

    private String token;

    public TokenResponse() {
    }

    public TokenResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
