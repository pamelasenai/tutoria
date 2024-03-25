package com.senai.tutoria.services;

import com.senai.tutoria.entities.AgendaEntity;
import com.senai.tutoria.entities.AlunoEntity;
import com.senai.tutoria.entities.TutorEntity;
import com.senai.tutoria.exception.NotFoundException;
import com.senai.tutoria.repositories.AgendaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AgendaServiceImpl implements AgendaService {
    private final AlunoService alunoService;
    private final TutorService tutorService;
    private final AgendaRepository repository;

    @Override
    public AgendaEntity criar(AgendaEntity agenda) {
        agenda.setId(null);
        if(agenda.getTema() == null || agenda.getTema().isBlank()) {
            throw new RuntimeException("Tema não pode estar em branco.");
        }
        if(agenda.getStatus() == null || agenda.getStatus().isBlank()){
            agenda.setStatus("AGENDADO");
        }

        TutorEntity tutor = tutorService.buscarPorId(agenda.getTutor().getId());
        agenda.setTutor(tutor);

        AlunoEntity aluno = alunoService.buscarPorId(agenda.getAluno().getId());
        agenda.setAluno(aluno);

        return repository.save(agenda);
    }

    @Override
    public List<AgendaEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public AgendaEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Agenda com id " + id + " não encontrada.")
        );
    }

    @Override
    public List<AgendaEntity> buscarPorAlunoId(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return repository.findByAlunoIdOrderByData(alunoId);
    }

    @Override
    public List<AgendaEntity> buscarPorTutorId(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return repository.findByTutorIdOrderByData(tutorId);
    }

    @Override
    public List<AgendaEntity> buscarProximosPorAlunoId(Long alunoId) {
        alunoService.buscarPorId(alunoId);
        return repository.findByAlunoIdAndDataGreaterThanOrderByData(alunoId, dataFormatada());
    }

    @Override
    public List<AgendaEntity> buscarProximosPorTutorId(Long tutorId) {
        tutorService.buscarPorId(tutorId);
        return repository.findByTutorIdAndDataGreaterThanOrderByData(tutorId, dataFormatada());
    }

    @Override
    public AgendaEntity alterar(Long id, AgendaEntity agenda) {
        AgendaEntity agendaEntity = buscarPorId(id);
        agenda.setId(id);

        if(agenda.getTema() == null || agenda.getTema().isBlank()) {
            agenda.setTema(agendaEntity.getTema());
        }
        if(agenda.getStatus() == null || agenda.getStatus().isBlank()){
            agenda.setStatus(agendaEntity.getStatus());
        }
        if(agenda.getDescricao() == null || agenda.getDescricao().isBlank()){
            agenda.setDescricao(agendaEntity.getDescricao());
        }

        TutorEntity tutor = tutorService.buscarPorId(agenda.getTutor().getId());
        agenda.setTutor(tutor);

        AlunoEntity aluno = alunoService.buscarPorId(agenda.getAluno().getId());
        agenda.setAluno(aluno);

        return repository.save(agenda);
    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

    private LocalDate dataFormatada() {
        LocalDate dataAtual = LocalDate.now();
        LocalDate data = dataAtual.minusDays(1);
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(data.format(formatador));
    }
}
