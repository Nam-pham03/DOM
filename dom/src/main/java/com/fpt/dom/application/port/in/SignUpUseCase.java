package com.fpt.dom.application.port.in;

import com.fpt.dom.application.dto.request.SignUpRequestDto;
import com.fpt.dom.application.dto.response.SignUpResponseDto;

public interface SignUpUseCase {
    SignUpResponseDto register(SignUpRequestDto request);
}
