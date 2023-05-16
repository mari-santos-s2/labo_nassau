package br.com.erudio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "O nome é obrigatório")
    private String name;
    
    @NotBlank(message = "A matrícula é obrigatória")
    private String registration;
    
    @Email(message = "O email deve ser válido")
    @NotBlank(message = "O email é obrigatório")
    private String email;
    
    @NotBlank(message = "A senha é obrigatória")
    private String password;
    
    @NotBlank(message = "A confirmação de senha é obrigatória")
    private String confirmPassword;

    public Register(){

    }

    public Register(@NotBlank(message = "O nome é obrigatório") String name,
            @NotBlank(message = "A matrícula é obrigatória") String registration,
            @Email(message = "O email deve ser válido") @NotBlank(message = "O email é obrigatório") String email,
            @NotBlank(message = "A senha é obrigatória") String password,
            @NotBlank(message = "A confirmação de senha é obrigatória") String confirmPassword) {
        this.name = name;
        this.registration = registration;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
    
}

