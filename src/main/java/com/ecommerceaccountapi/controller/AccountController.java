package com.ecommerceaccountapi.controller;

import com.ecommerceaccountapi.entity.Account;
import com.ecommerceaccountapi.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Account")
public class AccountController {

    private final AccountService accountService;

    @GetMapping()
    public Iterable<Account> getAll(){
        return accountService.getAll();
    }
    @GetMapping("/byId/{id}")
    public Account getId(@PathVariable Long id){
        return accountService.byId(id).get();
    }
    @PostMapping("/create")
    public Account createAccount (@RequestBody Account account){
        return accountService.save(account);
    }
    @DeleteMapping("/deleteId/{id}")
    public boolean deteleId(@PathVariable Long id){
        return accountService.delete(id);
    }





}
