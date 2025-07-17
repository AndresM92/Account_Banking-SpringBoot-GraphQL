package com.abanking.controllers;

import com.abanking.dtos.AccountBankingRequestDto;
import com.abanking.dtos.AccountBankingResponseDto;
import com.abanking.entities.AccountBanking;
import com.abanking.entities.Client;
import com.abanking.repository.AccountBankingRepository;
import com.abanking.repository.ClientRepository;
import com.abanking.service.AccountBankingService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountBankingGraphQLController {

    private final AccountBankingRepository accountBankingRepository;
    private final AccountBankingService accountBankingService;
    private final ClientRepository clientRepository;

    public AccountBankingGraphQLController(AccountBankingRepository accountBankingRepository, AccountBankingService accountBankingService, ClientRepository clientRepository) {
        this.accountBankingRepository = accountBankingRepository;
        this.accountBankingService = accountBankingService;
        this.clientRepository = clientRepository;
    }

    @QueryMapping
    public List<AccountBanking> listAccounts(){
        return accountBankingRepository.findAll();
    }

    @QueryMapping
    public AccountBanking accountBankingById(@Argument String id){
        List<AccountBanking> accounts= accountBankingRepository.findAll();

        for(AccountBanking account:accounts){

            if(account.getId().trim().equals(id.trim())){
                System.out.println("Found Account");
                return account;
            }
        }
        throw new RuntimeException("Account["+ id + "] no found");
    }

    @MutationMapping
    public AccountBankingResponseDto addAccount(@Argument AccountBankingRequestDto accountBanking){
        return accountBankingService.addAccount(accountBanking);
    }

    @MutationMapping
    public AccountBankingResponseDto updateAccount(@Argument String id,@Argument AccountBankingRequestDto accountBanking){
        return accountBankingService.updateAccount(id,accountBanking);
    }

    @MutationMapping
    public void deleteAccount(@Argument String id){
        accountBankingRepository.deleteById(id);
    }

    @QueryMapping
    public List<Client> listClients(){
        return clientRepository.findAll();
    }

}
