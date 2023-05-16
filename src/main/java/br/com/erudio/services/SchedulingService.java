package br.com.erudio.services;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.erudio.model.Scheduling;
import br.com.erudio.repositories.SchedulingRepository;

@Service
public class SchedulingService {

    private final SchedulingRepository schedulingRepository;

    public SchedulingService(SchedulingRepository schedulingRepository) {
        this.schedulingRepository = schedulingRepository;
    }

    public Scheduling criarScheduling(Scheduling scheduling) {
        return schedulingRepository.save(scheduling);
    }

    public List<LocalDateTime> diasDisponiveis(LocalDateTime inicio, LocalDateTime fim) {
        List<Scheduling> agendamentos = schedulingRepository.findByDataBetween(inicio, fim);
        Set<LocalDate> datasAgendadas = agendamentos.stream().map(a -> a.getDate().toLocalDate()).collect(Collectors.toSet());
        List<LocalDateTime> diasDisponiveis = new ArrayList<>();
        LocalDateTime dataAtual = inicio;
        while (dataAtual.isBefore(fim)) {
            if (!datasAgendadas.contains(dataAtual.toLocalDate())) {
                diasDisponiveis.add(dataAtual);
            }
            dataAtual = dataAtual.plusDays(1);
        }
        return diasDisponiveis;
    }

    public List<Scheduling> agendamentosParaData(LocalDateTime data) {
        LocalDateTime inicio = data.with(LocalTime.MIN);
        LocalDateTime fim = data.with(LocalTime.MAX);
        return schedulingRepository.findByDataBetween(inicio, fim);
    }
    // outros métodos adicionais, se necessário
}
