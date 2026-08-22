package com.agendio.agendamento.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Table(name = "pessoa")
@Getter
@Setter
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "idade", nullable = false)
    private int idade;

    @Column(name = "email", unique = true, nullable = false, length = 255)
    private String email;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;



}
