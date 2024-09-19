package com.ecommerceaccountapi.controller;

import com.ecommerceaccountapi.entity.Account;
import com.ecommerceaccountapi.service.AccountService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.List;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
@Setter
@RestController
@RequestMapping("/Account")
public class AccountController {

    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping()
    public Iterable<Account> getAll(){

        Iterable<Account> lista = null;

        try {

            lista = accountService.getAll();

        }catch (NullPointerException n){
            n.printStackTrace();
        }
        return lista;
    }
    @GetMapping("/byId/{id}")
    public Account getId(@PathVariable Long id){
        return accountService.byId(id).get();
    }
    @PostMapping("/create")
    public Account createAccount (@RequestBody Account account){
        System.out.println(account);
        return accountService.save(account);
    }
    @DeleteMapping("/deleteId/{id}")
    public boolean deteleId(@PathVariable Long id){
        return accountService.delete(id);
    }
}
