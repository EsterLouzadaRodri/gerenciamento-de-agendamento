package com.agendio.agendamento.services;


import com.agendio.agendamento.model.Agendamento;
import com.agendio.agendamento.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoServices {

    @Autowired
    AgendamentoRepository query;

    //lista de agendamento
    public List<Agendamento> getAgendamento(){return query.findAll();}


}
