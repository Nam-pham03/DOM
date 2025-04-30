package com.fpt.dom.infrastructure.persistence;

import com.fpt.dom.application.port.out.AccountRepositoryPort;
import com.fpt.dom.domain.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MongoAccountRepository extends MongoRepository<Account, String>, AccountRepositoryPort {
    Optional<Account> findByEmail(String email);
}
