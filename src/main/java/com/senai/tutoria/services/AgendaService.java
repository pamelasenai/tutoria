package com.senai.tutoria.services;

import com.senai.tutoria.entities.AgendaEntity;

import java.util.List;

public interface AgendaService extends GenericService<AgendaEntity> {
    List<AgendaEntity> buscarPorAlunoId(Long alunoId);
    List<AgendaEntity> buscarPorTutorId(Long tutorId);
}
