package com.abanking.dtos;

import com.abanking.entities.TypeAccount;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class AccountBankingResponseDto {

    private String id;
    private Date dateCreation;
    private double balance;
    private String div;
    private TypeAccount typeAccount;

}
