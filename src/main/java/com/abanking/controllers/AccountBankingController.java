package com.abanking.controllers;


import com.abanking.dtos.AccountBankingRequestDto;
import com.abanking.dtos.AccountBankingResponseDto;
import com.abanking.entities.AccountBanking;
import com.abanking.repository.AccountBankingRepository;
import com.abanking.service.AccountBankingService;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/")
public class AccountBankingController {
    private final AccountBankingRepository accountBankingRepository;
    private final AccountBankingService accountBankingService;

    public AccountBankingController(AccountBankingRepository accountBankingRepository, AccountBankingService accountBankingService) {
        this.accountBankingRepository = accountBankingRepository;
        this.accountBankingService = accountBankingService;
    }

    @GetMapping("/accounts")
    public List<AccountBanking> listAccountBanking(){
        return accountBankingRepository.findAll();
    }

    @GetMapping("/accounts/{id}")
    public AccountBanking getAccountBanking(@PathVariable String id){
        return accountBankingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException(String.format("Account %s no found")));
    }

    @PostMapping("/Account")
    public AccountBankingResponseDto saveAccount(@RequestBody AccountBankingRequestDto accountBankingRequestDto){
        return accountBankingService.addAccount(accountBankingRequestDto);
    }

    @PutMapping("/accounts/{id}")
    public AccountBanking updateAccount(@PathVariable String id, @RequestBody AccountBanking accountBanking ){
        AccountBanking accountBankingBBDD=accountBankingRepository.findById(id).orElseThrow();
        accountBankingBBDD.setBalance(accountBanking.getBalance());
        accountBankingBBDD.setDateCreation(new Date());
        accountBankingBBDD.setTypeAccount(accountBanking.getTypeAccount());
        accountBankingBBDD.setDiv(accountBanking.getDiv());
        return accountBankingRepository.save(accountBankingBBDD);
    }

    @DeleteMapping("/accounts/{id}")
    public void deleteAccount(@PathVariable String id){
        accountBankingRepository.deleteById(id);
    }
}
