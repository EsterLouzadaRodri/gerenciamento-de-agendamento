package com.agendio.agendamento.services;

import com.agendio.agendamento.model.Pessoa;
import com.agendio.agendamento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaServices {

    @Autowired
    private PessoaRepository query;

    public List<Pessoa> getPessoa(){
        return query.findAll();
    }

    public Pessoa addNewPessoa(Pessoa p){
        query.save(p);
        return p;
    }
}
