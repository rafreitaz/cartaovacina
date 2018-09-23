package com.piuna.CartaoVacinaOnline;

import com.piuna.CartaoVacinaOnline.domain.Vacina;
import com.piuna.CartaoVacinaOnline.repository.VacinaRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class CartaoVacinaOnlineApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartaoVacinaOnlineApplication.class, args);
	}

	@Bean
	ApplicationRunner init(VacinaRepository repository) {
		return args -> {
			Stream.of("BCG", "Hepatite B", "Pentavalente", "Poliomielite", "Meningocócica C",
					"Tríplice Viral", "Febre Amarela").forEach(name -> {
				Vacina vacina = new Vacina();
				vacina.setNome(name);
				repository.save(vacina);
			});
			repository.findAll().forEach(System.out::println);
		};
	}
}
