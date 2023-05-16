package br.com.erudio.services;

import java.util.Optional;

import br.com.erudio.model.Register;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"matricula"})})
public interface RegisterService{
    
    Register cadastrar(Register register);
    
    Optional<Register> buscarPorEmail(String email);
    
    Optional<Register> buscarPorEmailESenha(String email, String senha);

    Object getPassword();
    
}