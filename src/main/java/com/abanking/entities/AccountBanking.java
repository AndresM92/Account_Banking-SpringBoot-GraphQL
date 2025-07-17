package com.abanking.entities;

import jakarta.persistence.*;
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

    @ManyToOne
    private Client client;

}
