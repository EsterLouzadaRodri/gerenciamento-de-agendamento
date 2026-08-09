package com.agendio.agendamento.controller;

import com.agendio.agendamento.model.Pessoa;
import com.agendio.agendamento.services.PessoaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    private PessoaServices repositoryPessoa;

    //lista de todas as pessoas cadastradas
    @GetMapping("/all")
    List<Pessoa> getPessoa(){
        return repositoryPessoa.getPessoa();
    }

    //add nova pessoa
    @PostMapping("/new")
    Pessoa newPessoa(@RequestBody Pessoa pessoa){
        repositoryPessoa.addNewPessoa(pessoa);
        return pessoa;
    }
}
