package com.enzo.backend_cinema.repository;

import com.enzo.backend_cinema.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User,String> {
   UserDetails findByLogin(String login);
}