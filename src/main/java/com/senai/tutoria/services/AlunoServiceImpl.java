package com.senai.tutoria.services;

import com.senai.tutoria.entities.AlunoEntity;
import com.senai.tutoria.exception.NotFoundException;
import com.senai.tutoria.repositories.AlunoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoServiceImpl implements AlunoService {
    private final AlunoRepository repository;

    @Override
    public AlunoEntity criar(AlunoEntity aluno) {
        if(aluno.getNome() == null || aluno.getNome().isBlank()) {
            throw new RuntimeException("Nome não pode estar em branco.");
        }
        aluno.setId(null);
        return repository.save(aluno);
    }

    @Override
    public List<AlunoEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public AlunoEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Aluno com id " + id + " não encontrado.")
        );
    }

    @Override
    public AlunoEntity alterar(Long id, AlunoEntity aluno) {
        AlunoEntity alunoEntity = buscarPorId(id);
        if(aluno.getNome() == null || aluno.getNome().isBlank()) {
            aluno.setNome(alunoEntity.getNome());
        }
        aluno.setId(id);
        return repository.save(aluno);
    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
