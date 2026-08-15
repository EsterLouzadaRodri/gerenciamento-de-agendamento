package com.agendio.agendamento.controller;

import com.agendio.agendamento.model.Agendamento;
import com.agendio.agendamento.services.AgendamentoServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
@Tag(name = "Agendamentos", description = "Rota de agendamentos / EndPoint")
public class AgendamentoController {

    @Autowired
    AgendamentoServices agendRepo;

    //lista dos agendamentos
    @Operation(summary = "", description = "")
    @GetMapping("/all")
    List<Agendamento> getAgendamento(){
        return agendRepo.getAgendamento();
    }

    //add novo agendamento
    @PostMapping("/new")
    Agendamento newAgendamento(@RequestBody Agendamento a){
        agendRepo.addNewAgendamento(a);
        return a;
    }

}
