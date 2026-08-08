package com.agendio.agendamento.repository;

import com.agendio.agendamento.model.Pessoa;
import org.springframework.boot.json.JacksonJsonParser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryPessoa extends JpaRepository<Pessoa, Integer> {

}
