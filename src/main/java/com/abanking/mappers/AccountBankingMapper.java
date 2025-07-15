package com.abanking.mappers;


import com.abanking.entities.AccountBanking;
import com.abanking.dtos.AccountBankingResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountBankingMapper {

    public AccountBankingResponseDto fromAccountBanking(AccountBanking accountBanking){
        AccountBankingResponseDto accountBankingResponseDto = new AccountBankingResponseDto();
        BeanUtils.copyProperties(accountBanking,accountBankingResponseDto);
        return accountBankingResponseDto;
    }
}
