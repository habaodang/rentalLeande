package org.baodang.rentalleandeapi.service;

import org.baodang.rentalleandeapi.dto.AccountResponse;
import org.baodang.rentalleandeapi.entity.Account;
import org.baodang.rentalleandeapi.mapper.AccountMapper;
import org.baodang.rentalleandeapi.repository.AccountRepository;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse getAccount(Long id){
        Account account=accountRepository.findById(id).orElseThrow();

        return AccountMapper.toResponse(account);
    }
}
