package com.abanking.service.impl;

import com.abanking.dtos.AccountBankingRequestDto;
import com.abanking.dtos.AccountBankingResponseDto;
import com.abanking.entities.AccountBanking;
import com.abanking.mappers.AccountBankingMapper;
import com.abanking.repository.AccountBankingRepository;
import com.abanking.service.AccountBankingService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountBankingServiceImpl implements AccountBankingService {
    private final AccountBankingRepository accountBankingRepository;
    private final AccountBankingMapper accountBankingMapper;

    public AccountBankingServiceImpl(AccountBankingRepository accountBankingRepository, AccountBankingMapper accountBankingMapper) {
        this.accountBankingRepository = accountBankingRepository;
        this.accountBankingMapper = accountBankingMapper;
    }

    @Override
    public AccountBankingResponseDto addAccount(AccountBankingRequestDto accountBankingRequestDto) {
        AccountBanking accountBanking = AccountBanking.builder()
                .id(UUID.randomUUID().toString())
                .dateCreation(new Date())
                .balance(accountBankingRequestDto.getBalance())
                .div(accountBankingRequestDto.getDiv())
                .typeAccount(accountBankingRequestDto.getTypeAccount())
                .build();

        AccountBanking accountBankingBBDD = accountBankingRepository.save(accountBanking);
        AccountBankingResponseDto accountBankingResponseDto= accountBankingMapper.fromAccountBanking(accountBankingBBDD);
        return null;
    }
}
