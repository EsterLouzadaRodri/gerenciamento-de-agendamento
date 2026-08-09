package com.agendio.agendamento.controller;

import com.agendio.agendamento.model.Agendamento;
import com.agendio.agendamento.services.AgendamentoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    AgendamentoServices agendRepo;

    //lista dos agendamentos
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
