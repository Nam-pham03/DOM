package com.fpt.dom.application.usecase;

import com.fpt.dom.application.dto.request.SignUpRequestDto;
import com.fpt.dom.application.dto.response.SignUpResponseDto;
import com.fpt.dom.application.port.in.SignUpUseCase;
import com.fpt.dom.application.port.out.AccountRepositoryPort;
import com.fpt.dom.domain.entity.Account;
import com.fpt.dom.domain.exception.InvalidInputException;
import com.fpt.dom.domain.exception.TermsNotAcceptedException;
import com.fpt.dom.domain.exception.UserAlreadyExistsException;
import com.fpt.dom.utils.SecurityUtils;
import com.fpt.dom.validation.Validation;
import org.springframework.stereotype.Service;

@Service
public class SignUpUseCaseImpl implements SignUpUseCase {


    private final AccountRepositoryPort accountRepository;

    public SignUpUseCaseImpl(AccountRepositoryPort accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public SignUpResponseDto register(SignUpRequestDto request) {

        if (accountRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException("Email already exists!");
        }

        if(!Validation.checkPhone(request.getPhone()) ) {
            throw new InvalidInputException("Phone must have 10 number!");
        }

        if(!Validation.checkEmail(request.getEmail())) {
            throw new InvalidInputException("Invalid format in email!");
        }

        if( !Validation.checkPassword(request.getPassword())) {
            throw new InvalidInputException("Password must have less 6 digits");
        }

        if(!request.isAgreeTerms()) {

            throw new TermsNotAcceptedException("You must accept the terms and conditions to register.");
        }


        String hashedPass = SecurityUtils.hashMd5(request.getPassword());



        Account account = new Account();
        account.setFirstName(request.getFirstName());
        account.setLastName(request.getLastName());
        account.setEmail(request.getEmail());
        account.setFeId(request.getFeId());
        account.setPhone(request.getPhone());
        account.setAddress(request.getAddress());
        account.setGender((request.getGender() == 1) ? "male" : "female");
        account.setDob(request.getDob());
        account.setPassword(hashedPass);
        account.setRole("Student");




        Account savedAccount = accountRepository.save(account);


        return new SignUpResponseDto("Registration successful!", savedAccount.getAccountId());
    }


}
