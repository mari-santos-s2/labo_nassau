package br.com.erudio.controller;

import java.net.URI;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.model.Scheduling;
import br.com.erudio.services.SchedulingService;

@RestController
@RequestMapping("/Schedulings")

public class SchedulingController {

    private final SchedulingService schedulingService;

    public SchedulingController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    @PostMapping
    public ResponseEntity<Scheduling> criarScheduling(@RequestBody Scheduling Scheduling) {
        Scheduling novoScheduling = schedulingService.criarScheduling(Scheduling);
        return ResponseEntity.created(URI.create("/Schedulings/" + novoScheduling.getId())).body(novoScheduling);
    }

    // outros métodos adicionais, se necessário
}

