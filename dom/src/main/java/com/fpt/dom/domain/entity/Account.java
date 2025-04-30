package com.fpt.dom.domain.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Document(collection = "Accounts")
public class Account {
    @Id
    private String accountId;

    private String firstName;
    private String lastName;

    @Indexed(unique = true)
    private String email;

    private String feId;
    private String phone;
    private String address;
    private String gender;
    private String dob;
    private String password;
    private String role;
}
