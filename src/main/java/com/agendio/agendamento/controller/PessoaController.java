package com.agendio.agendamento.controller;

import com.agendio.agendamento.model.Pessoa;
import com.agendio.agendamento.repository.PessoaRepository;
import com.agendio.agendamento.services.PessoaServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<Pessoa> allUsers(){
        return repositoryPessoa.findAllUsers();
    }

    //add nova pessoa
    @PostMapping("/new")
    @Operation(summary = "Add nova pessoa",
        description = "Adiciona uma nova pessoa.")
    public ResponseEntity<?> saveUser(@RequestBody Pessoa p){
        try{
            Pessoa savedUser = repositoryPessoa.saveUser(p);
            savedUser.setSenha(null);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(savedUser);
        }catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao encriptar ou salvar o usuário: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Optional<Pessoa> getUser(@PathVariable("id") Long id){
        return repositoryPessoa.findById(id);
    }
}
