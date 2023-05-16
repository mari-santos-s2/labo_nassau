package br.com.erudio.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.model.Register;
import br.com.erudio.services.RegisterService;

public interface RegisterRepository extends JpaRepository<RegisterService, Long> {

    Optional<Register> findByEmail(String email);
    // métodos adicionais, se necessário

    

    Register save(Register register);
}
