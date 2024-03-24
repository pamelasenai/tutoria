package com.senai.tutoria.repositories;

import com.senai.tutoria.entities.AgendaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<AgendaEntity, Long> {
}
