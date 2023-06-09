package com.youth.moim.login.ui;

import com.youth.moim.login.application.LoginService;
import com.youth.moim.login.dto.TokenRequest;
import com.youth.moim.login.dto.TokenResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody TokenRequest tokenRequest) {
        TokenResponse response = loginService.login(tokenRequest);
        return ResponseEntity.ok().body(response);
    }
}
