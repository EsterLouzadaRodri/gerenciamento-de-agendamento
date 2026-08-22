package com.agendio.agendamento.controller;

import com.agendio.agendamento.model.Pessoa;
import com.agendio.agendamento.services.PessoaServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoa")
@Tag(name = "Pessoa", description = "Gerenciador de pessoas")
public class PessoaController {

    @Autowired
    private PessoaServices repositoryPessoa;

    //lista de todas as pessoas cadastradas
    @GetMapping("/all")
    @Operation(summary = "Lista de pessoas",
            description = "Mostra em forma de lista todas as pessoas ja cadastradas.")
    List<Pessoa> getPessoa(){
        return repositoryPessoa.getPessoa();
    }

    //add nova pessoa
    @PostMapping("/new")
    @Operation(summary = "Add nova pessoa",
        description = "Adiciona uma nova pessoa.")
    Pessoa newPessoa(@RequestBody Pessoa pessoa){
        repositoryPessoa.addNewPessoa(pessoa);
        return pessoa;
    }
}
