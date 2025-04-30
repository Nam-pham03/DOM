package com.fpt.dom.application.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class SignUpResponseDto {
    private String message;
    private String accountId;
}
