package com.senai.tutoria.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "agendas")
public class AgendaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate data;

    @Column(nullable = false, length = 10)
    private String status;

    @Column(nullable = false, length = 150)
    private String tema;

    private String descricao;

    @ManyToOne
    @JoinColumn(name = "aluno_id", nullable = false)
    private AgendaEntity aluno;

    @ManyToOne
    @JoinColumn(name = "tutor_id", nullable = false)
    private TutorEntity tutor;
}
