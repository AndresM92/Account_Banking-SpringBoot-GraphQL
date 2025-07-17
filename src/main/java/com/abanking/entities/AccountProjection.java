package com.abanking.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(types= AccountBanking.class, name="p1")
public interface AccountProjection {

    public String getId();
    public TypeAccount getTypeAccount();
    public Double getBalance();

}
