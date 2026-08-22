package com.agendio.agendamento.controller;

import com.agendio.agendamento.model.Agendamento;
import com.agendio.agendamento.services.AgendamentoServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
@Tag(name = "Agendamentos", description = "Gerenciador de agendamentos")
public class AgendamentoController {

    @Autowired
    AgendamentoServices agendRepo;

    //lista dos agendamentos
    @GetMapping("/all")
    @Operation(summary = "Lista de agendamentos",
            description = "Mostra em forma de lista todos os agendamentos cadastrados.")
    List<Agendamento> getAgendamento(){
        return agendRepo.getAgendamento();
    }

    //add novo agendamento
    @PostMapping("/new")
    @Operation(summary = "Add novo agendamento",
            description = "Adiciona um novo agendamento.")
    Agendamento newAgendamento(@RequestBody Agendamento a){
        agendRepo.addNewAgendamento(a);
        return a;
    }

}
