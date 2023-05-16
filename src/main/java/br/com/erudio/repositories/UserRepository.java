package br.com.erudio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.erudio.model.User;

public interface UserRepository extends JpaRepository<User, Long>{}
