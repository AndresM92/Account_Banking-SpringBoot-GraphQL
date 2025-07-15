package com.abanking.dtos;


import com.abanking.entities.TypeAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountBankingRequestDto {

    private double balance;
    private String div;
    private TypeAccount typeAccount;

}
