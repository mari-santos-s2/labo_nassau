package com.api.techlabapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.techlabapi.model.Agenda;


@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {
    // adicione qualquer método adicional necessário
}