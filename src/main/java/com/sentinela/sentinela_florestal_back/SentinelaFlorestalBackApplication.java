package com.sentinela.sentinela_florestal_back;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SentinelaFlorestalBackApplication {

	public static void main(String[] args) {
		// Carrega variáveis do arquivo .env
		try {
			Dotenv dotenv = Dotenv.configure()
					.ignoreIfMissing()
					.load();
			
			// Define as variáveis de ambiente do sistema
			dotenv.entries().forEach(entry -> {
				if (System.getenv(entry.getKey()) == null) {
					System.setProperty(entry.getKey(), entry.getValue());
				}
			});
		} catch (Exception e) {
			System.err.println("Aviso: Erro ao carregar arquivo .env: " + e.getMessage());
			System.err.println("A aplicação continuará usando variáveis de ambiente do sistema.");
		}
		
		SpringApplication.run(SentinelaFlorestalBackApplication.class, args);
	}

}
