package com.abanking;

import com.abanking.entities.AccountBanking;
import com.abanking.entities.Client;
import com.abanking.entities.TypeAccount;
import com.abanking.repository.AccountBankingRepository;
import com.abanking.repository.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;
import java.util.stream.Stream;

@SpringBootApplication
public class AccountBankingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountBankingServiceApplication.class, args);
	}

    @Bean
    CommandLineRunner start(AccountBankingRepository accountBankingRepository, ClientRepository clientRepository){
		return args -> {
			Stream.of("Andres","Carlos","Julian","Esteban").forEach(c-> {
				Client client = Client.builder()
						.nombre(c)
						.build();
				clientRepository.save(client);
			});

			clientRepository.findAll().forEach(client -> {
				for (int i=0;i<10;i++){
					AccountBanking accountBanking= AccountBanking.builder()
							.id(UUID.randomUUID().toString())
							.typeAccount(Math.random()>0.5 ? TypeAccount.CURRENT_ACCOUNT : TypeAccount.SAVE_ACCOUNT)
							.balance(10000+Math.random()*90000)
							.div("USD")
							.client(client)
							.build();
					accountBankingRepository.save(accountBanking);
				}
			});
		};
	}
}
