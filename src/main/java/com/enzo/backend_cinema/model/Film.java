package com.enzo.backend_cinema.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Film {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 200, nullable = false)
    private String language;

    @Column(length = 200, nullable = false)
    private String hours;

    @Column(length= 200, nullable = false)
    private String img;

    // Getters
    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getHours() {
        return hours;
    }

    public String getImg() {
        return img;
    }

    public Long getId() {
        return id;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
