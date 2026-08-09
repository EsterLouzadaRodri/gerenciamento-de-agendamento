package com.agendio.agendamento.services;


import com.agendio.agendamento.model.Agendamento;
import com.agendio.agendamento.model.Pessoa;
import com.agendio.agendamento.repository.AgendamentoRepository;
import com.agendio.agendamento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoServices {

    @Autowired
    AgendamentoRepository query;

    @Autowired
    PessoaRepository pessoaRepo;

    //lista de agendamento
    public List<Agendamento> getAgendamento(){return query.findAll();}

    //add
    public Agendamento addNewAgendamento(Agendamento a){
        Pessoa pessoa1 = pessoaRepo.findById(a.getPessoa1().getId())
                .orElseThrow(() -> new RuntimeException("Pessoa1 nao encontrada"));
        Pessoa pessoa2 = pessoaRepo.findById(a.getPessoa2().getId())
                .orElseThrow(() -> new RuntimeException("Pessoa2 nao encontrada"));

        a.setPessoa1(pessoa1);
        a.setPessoa2(pessoa2);

        return query.save(a);
    }

}
