package com.piuna.CartaoVacinaOnline;

import com.piuna.CartaoVacinaOnline.repository.VacinaRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CartaoVacinaOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartaoVacinaOnlineApplication.class, args);
	}

	@Bean
	ApplicationRunner init(VacinaRepository repository) {
		return args -> {
//			repository.findAll().forEach(System.out::println);
		};
	}
}
