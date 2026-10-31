package org.baodang.rentalleandeapi.controller;

import org.baodang.rentalleandeapi.dto.AccountResponse;
import org.baodang.rentalleandeapi.dto.LoginRequest;
import org.baodang.rentalleandeapi.service.AccountService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:5173")
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

    @PostMapping("/login")
    public AccountResponse Login(@RequestBody LoginRequest request){
        String email = request.email();
        String password = request.password();
        System.out.println("da vo ham "+email+" " +password);
        return accountService.isLogin(email,password);
    }
}
