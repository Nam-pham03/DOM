package com.fpt.dom.application.port.out;

import com.fpt.dom.domain.entity.Account;

import java.util.Optional;

public interface AccountRepositoryPort {
    Optional<Account> findByEmail(String email);
    Account save(Account account);
}
