package com.senai.tutoria.repositories;

import com.senai.tutoria.entities.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {
}
