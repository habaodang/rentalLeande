package org.baodang.rentalleandeapi.service;

import org.baodang.rentalleandeapi.dto.AccountResponse;
import org.baodang.rentalleandeapi.entity.Account;
import org.baodang.rentalleandeapi.mapper.AccountMapper;
import org.baodang.rentalleandeapi.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse getAccount(Long id){
        Account account=accountRepository.findById(id).orElseThrow(()->new ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Không tìm thấy bât kỳ account nào"
        ));

        return AccountMapper.toResponse(account);
    }

    public AccountResponse isLogin (String email,String hashPassword){
        Account account=accountRepository.findByEmailAndPasswordHash(email,hashPassword)
                .orElseThrow(()->new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Tài Khoản không hợp lệ"
                ));
        return AccountMapper.toResponse(account);
    }
}
