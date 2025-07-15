package com.abanking.repository;


import com.abanking.entities.AccountBanking;
import com.abanking.entities.TypeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import java.util.List;

@RepositoryRestResource

public interface AccountBankingRepository extends JpaRepository<AccountBanking,String> {

    @RestResource(path = "/byType")
    List<AccountBanking> findByTypeAccount(@Param("t") TypeAccount typeAccount);


}
