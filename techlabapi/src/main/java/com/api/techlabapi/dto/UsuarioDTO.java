package com.api.techlabapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class UsuarioDTO {
    @NotEmpty
    @Size(min = 3, max = 100)
    private String nome;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String email;

    @NotEmpty
    @Size(min = 3, max = 100)
    private String matricula;

    @NotEmpty
    @Size(min = 6, max = 20)
    private String senha;

    // getters and setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}