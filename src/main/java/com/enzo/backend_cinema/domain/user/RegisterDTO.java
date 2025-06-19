package com.enzo.backend_cinema.domain.user;


public record RegisterDTO(String login, String password, UserRole role) {
}