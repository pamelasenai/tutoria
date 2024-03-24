package com.senai.tutoria.controllers;

import com.senai.tutoria.entities.AlunoEntity;
import com.senai.tutoria.services.AlunoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("alunos")
public class AlunoController {
    private final AlunoService service;

    @GetMapping
    public ResponseEntity<List<AlunoEntity>> get() {
        return ResponseEntity.ok().body(service.buscarTodos());
    }

    @GetMapping("{id}")
    public ResponseEntity<AlunoEntity> getPorId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AlunoEntity> post(@RequestBody AlunoEntity aluno) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(aluno));
    }

    @PutMapping("{id}")
    public ResponseEntity<AlunoEntity> put(@PathVariable Long id, @RequestBody AlunoEntity aluno) {
        return ResponseEntity.ok().body(service.alterar(id, aluno));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
