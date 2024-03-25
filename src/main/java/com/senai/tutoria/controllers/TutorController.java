package com.senai.tutoria.controllers;

import com.senai.tutoria.entities.TutorEntity;
import com.senai.tutoria.services.TutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("tutores")
public class TutorController {
    private final TutorService service;

    @GetMapping
    public ResponseEntity<List<TutorEntity>> get() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<TutorEntity> getPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<TutorEntity> post(@RequestBody TutorEntity tutor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(tutor));
    }

    @PutMapping("{id}")
    public ResponseEntity<TutorEntity> put(@PathVariable Long id, @RequestBody TutorEntity tutor) {
        return ResponseEntity.ok().body(service.alterar(id, tutor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
