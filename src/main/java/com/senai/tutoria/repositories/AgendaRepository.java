package com.senai.tutoria.repositories;

import com.senai.tutoria.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
    List<AgendaEntity> findByAlunoIdOrderByData(Long alunoId);
    List<AgendaEntity> findByTutorIdOrderByData(Long tutorId);
    List<AgendaEntity> findByAlunoIdAndDataGreaterThanOrderByData(Long alunoId, LocalDate data);
    List<AgendaEntity> findByTutorIdAndDataGreaterThanOrderByData(Long alunoId, LocalDate data);
}
