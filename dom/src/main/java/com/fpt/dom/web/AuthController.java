package com.fpt.dom.web;

import com.fpt.dom.application.dto.request.SignUpRequestDto;
import com.fpt.dom.application.dto.response.SignUpResponseDto;
import com.fpt.dom.application.port.in.SignUpUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dom/auth")
public class AuthController {

    private final SignUpUseCase signUpUseCase;

    public AuthController(SignUpUseCase signUpUseCase) {
        this.signUpUseCase = signUpUseCase;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto request) {
        SignUpResponseDto response = signUpUseCase.register(request);
        return ResponseEntity.ok(response);
    }
}
