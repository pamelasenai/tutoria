package com.senai.tutoria.controllers;

import com.senai.tutoria.entities.AgendaEntity;
import com.senai.tutoria.services.AgendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("agendamentos")
public class AgendaController {
    private final AgendaService service;

    @GetMapping
    public ResponseEntity<List<AgendaEntity>> get() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<AgendaEntity> getPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @GetMapping("aluno-id/{alunoId}")
    public ResponseEntity<List<AgendaEntity>> getPorAlunoId(@PathVariable Long alunoId) {
        return ResponseEntity.ok().body(service.buscarPorAlunoId(alunoId));
    }

    @GetMapping("tutor-id/{tutorId}")
    public ResponseEntity<List<AgendaEntity>> getPorTutorId(@PathVariable Long tutorId) {
        return ResponseEntity.ok().body(service.buscarPorTutorId(tutorId));
    }

    @PostMapping
    public ResponseEntity<AgendaEntity> post(@RequestBody AgendaEntity agenda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(agenda));
    }

    @PutMapping("{id}")
    public ResponseEntity<AgendaEntity> put(@PathVariable Long id, @RequestBody AgendaEntity agenda) {
        return ResponseEntity.ok().body(service.alterar(id, agenda));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
