package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByEmail(String email);
}