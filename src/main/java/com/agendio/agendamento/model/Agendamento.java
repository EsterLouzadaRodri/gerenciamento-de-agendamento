package com.agendio.agendamento.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Table(name = "Agendamento")
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "data", nullable = false)
    LocalDate data;

    @Column(name = "horario", nullable = false)
    LocalTime horario;

    @Column(name = "descricao", length = 255)
    String descricao;

    @Enumerated(EnumType.STRING)
    @JdbcTypeCode(SqlTypes.NAMED_ENUM)
    @Column(name = "status", nullable = false, columnDefinition = "status_agendamento")
    StatusAgendamento status = StatusAgendamento.pendente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa1_id", nullable = false)
    Pessoa pessoa1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa2_id", nullable = false)
    Pessoa pessoa2;

}


/*
docker exec -it postgres-db psql -U usuario -d banco
* "POSTGRES_DB=banco",
                "POSTGRES_USER=usuario",
                "POSTGRES_PASSWORD=senha",
                "PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/postgresql/15/bin",
                "GOSU_VERSION=1.19",
                "LANG=en_US.utf8",
                "PG_MAJOR=15",
                "PG_VERSION=15.18-1.pgdg13+1",
                "PGDATA=/var/lib/postgresql/data"
                * */