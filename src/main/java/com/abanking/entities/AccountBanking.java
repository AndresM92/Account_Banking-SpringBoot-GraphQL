package com.abanking.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountBanking {

    @Id
    private String id;
    private Date dateCreation;
    private double balance;
    private String div;

    @Enumerated(EnumType.STRING)
    private TypeAccount typeAccount;

}
