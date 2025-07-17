package com.abanking.service;

import com.abanking.dtos.AccountBankingRequestDto;
import com.abanking.dtos.AccountBankingResponseDto;

public interface AccountBankingService {

    AccountBankingResponseDto addAccount(AccountBankingRequestDto accountBankingResponseDto);
    AccountBankingResponseDto updateAccount(String id,AccountBankingRequestDto accountBankingRequestDto);
}
