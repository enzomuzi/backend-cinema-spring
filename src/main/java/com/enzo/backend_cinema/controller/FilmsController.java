package com.enzo.backend_cinema.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enzo.backend_cinema.repository.FilmRepository;
import com.enzo.backend_cinema.model.Film;


@RestController
@RequestMapping("/api/films")

public class FilmsController {

    private final FilmRepository filmRepository;

    public FilmsController(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }


//  aqui lista os filmes
    @GetMapping
    public List<Film> list() {
        return filmRepository.findAll();
    }

    // aqui busca pelo id e edita o filme
    @GetMapping("/{id}")
    public ResponseEntity<Film> findById(@PathVariable Long id) {
        return filmRepository.findById(id)
            .map(record -> ResponseEntity.ok().body(record))
            .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Film> update(@PathVariable Long id,
        @RequestBody Film film) {
            return filmRepository.findById(id)
                .map(recordFound -> {
                    recordFound.setName(film.getName());
                    recordFound.setLanguage(film.getLanguage());
                    recordFound.setHours(film.getHours());
                    recordFound.setImg(film.getImg());
                    Film updated = filmRepository.save(recordFound);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    // aqui cria o filme
    @PostMapping
    public ResponseEntity<Film> create(@RequestBody Film film) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmRepository.save(film));
    }
    
    // aqui deleta o filme
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return filmRepository.findById(id)
                .map(recordFound -> {
                    filmRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
        }).orElse(ResponseEntity.notFound().build());
    }   
}
