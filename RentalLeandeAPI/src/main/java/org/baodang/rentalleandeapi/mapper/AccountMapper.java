package org.baodang.rentalleandeapi.mapper;

import org.baodang.rentalleandeapi.dto.AccountResponse;
import org.baodang.rentalleandeapi.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public static AccountResponse toResponse(Account account) {
        return new AccountResponse(account.getId(), account.getEmail(), account.getStatus());
    }
}
