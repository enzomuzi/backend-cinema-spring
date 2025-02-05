package com.enzo.backend_cinema;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.enzo.backend_cinema.model.Film;
import com.enzo.backend_cinema.repository.FilmRepository;

@SpringBootApplication
public class BackendCinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendCinemaApplication.class, args);
	}
@Bean
CommandLineRunner initDatabase(FilmRepository filmRepository) {
	return args -> {
		filmRepository.deleteAll();

		Film f = new Film();
		f.setName("Aviões");
		f.setDescription("Filme de criança");
		f.setHours("20H00");

		filmRepository.save(f);
	};
}
	

}
