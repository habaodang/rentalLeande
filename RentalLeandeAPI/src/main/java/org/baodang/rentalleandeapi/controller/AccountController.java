package org.baodang.rentalleandeapi.controller;

import org.baodang.rentalleandeapi.dto.AccountResponse;
import org.baodang.rentalleandeapi.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/getacc")
    public AccountResponse getAccount() {
        System.out.println("called api............");
        return accountService.getAccount(1L);
    }
}
