package br.com.erudio.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.erudio.model.Scheduling;

public interface SchedulingRepository extends JpaRepository<Scheduling, Long> {
    List<Scheduling> findByDataBetween(LocalDateTime inicio, LocalDateTime fim);
}

