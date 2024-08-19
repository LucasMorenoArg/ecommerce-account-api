package com.ecommerceaccountapi.service;

import com.ecommerceaccountapi.entity.Account;
import com.ecommerceaccountapi.repository.AccountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@RequiredArgsConstructor
@Service
public class AccountService {

    private @NonNull AccountRepository accountRepository;

    public Iterable<Account> getAll() {
        return accountRepository.findAll();
    }

    public Optional<Account> byId(Long id) {
        return accountRepository.findById(id);
    }

    public Account save(Account account) {
        return accountRepository.save(account);}

    public boolean delete(Long id){

        if (accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return true;

        } else return false;
    }

}
