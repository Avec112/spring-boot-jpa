package no.avec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories
public class H22RestApplication {

	public static void main(String[] args) {
		SpringApplication.run(H22RestApplication.class, args);
	}
}
