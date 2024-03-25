package com.senai.tutoria.repositories;

import com.senai.tutoria.entities.TutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
}
