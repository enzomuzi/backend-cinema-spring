package com.enzo.backend_cinema.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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



    @GetMapping
    public List<Film> list() {
        return filmRepository.findAll();
    }


    @PostMapping
    public ResponseEntity<Film> create(@RequestBody Film film) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmRepository.save(film));
    }
    
     
}
