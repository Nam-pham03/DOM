package com.fpt.dom.application.dto.request;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class SignUpRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String feId;
    private String phone;
    private String address;
    private Integer gender;
    private String dob;
    private String password;
    private boolean agreeTerms;
}
