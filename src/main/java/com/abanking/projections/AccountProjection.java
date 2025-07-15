package com.abanking.projections;

import com.abanking.entities.AccountBanking;
import com.abanking.entities.TypeAccount;
import org.springframework.data.rest.core.config.Projection;

@Projection(types= AccountBanking.class, name="p1")

public interface AccountProjection {

    public String getId();
    public TypeAccount getTypeAccount();
    public Double getBalance();

}
