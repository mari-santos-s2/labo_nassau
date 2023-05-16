package br.com.erudio.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;


    @Column(nullable = false, length = 80)
    private String name;

    @jakarta.persistence.Id
    @GeneratedValue
    @Column(nullable = false, length = 100)
    private Long registration;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 6)
    private String gender;

    public User() {

    }

    public User(String name, Long registration, String email, String gender) {
        this.name = name;
        this.registration = registration;
        this.email = email;
        this.gender = gender;
    }

    public String getFullName() {
        return name;
    }

    public void setFullName(String name) {
        this.name = name;
    }

    public Long getRegistration() {
        return registration;
    }

    public void setRegistration(Long registration) {
        this.registration = registration;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    

}
