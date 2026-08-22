package com.agendio.agendamento.services;

import com.agendio.agendamento.model.Pessoa;
import com.agendio.agendamento.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServices {

    private final PessoaRepository repo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public PessoaServices(PessoaRepository repo, PasswordEncoder passwordEncoder) {
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Pessoa> findAllUsers(){
        try{
            return repo.findAll();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return List.of(null);
    }

    public Pessoa saveUser(Pessoa p){
        String senhaEncoder = passwordEncoder.encode(p.getSenha());
        p.setSenha(senhaEncoder);
        return repo.save(p);
    }

    public Optional<Pessoa> findById(long id){
        return repo.findById(id);
    }
}
