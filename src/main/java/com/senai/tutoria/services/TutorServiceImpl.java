package com.senai.tutoria.services;

import com.senai.tutoria.entities.TutorEntity;
import com.senai.tutoria.exception.NotFoundException;
import com.senai.tutoria.repositories.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TutorServiceImpl implements TutorService {
    private final TutorRepository repository;

    @Override
    public TutorEntity criar(TutorEntity tutor) {
        if(tutor.getNome() == null || tutor.getNome().isBlank()) {
            throw new RuntimeException("Nome não pode estar em branco.");
        }
        if(tutor.getEspecialidade() == null || tutor.getEspecialidade().isBlank()) {
            throw new RuntimeException("Especialidade não pode estar em branco.");
        }
        tutor.setId(null);
        return repository.save(tutor);
    }

    @Override
    public List<TutorEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public TutorEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Tutor com id " + id + " não encontrado.")
        );
    }

    @Override
    public TutorEntity alterar(Long id, TutorEntity tutor) {
        TutorEntity tutorEntity = buscarPorId(id);
        if(tutor.getNome() == null || tutor.getNome().isBlank()) {
            tutor.setNome(tutorEntity.getNome());
        }
        if(tutor.getEspecialidade() == null || tutor.getEspecialidade().isBlank()) {
            tutor.setEspecialidade(tutorEntity.getEspecialidade());
        }
        tutor.setId(id);
        return repository.save(tutor);
    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }
}
