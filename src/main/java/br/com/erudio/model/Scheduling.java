package br.com.erudio.model;

import java.text.ParseException;
import java.time.LocalDateTime;

public class Scheduling {

    private Long id;
    private User user;
    private LocalDateTime date;
    private String observation;

    public Scheduling(){
        
    }

    public Scheduling(Long id, User user, LocalDateTime date) throws ParseException {
        this.id = id;
        this.user = user;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    
}
