package com.senai.tutoria.services;

import com.senai.tutoria.entities.AgendaEntity;
import com.senai.tutoria.entities.MaterialEntity;
import com.senai.tutoria.exception.NotFoundException;
import com.senai.tutoria.repositories.MaterialRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class MaterialServiceImpl implements MaterialService {
    private final AgendaService agendaService;
    private final MaterialRepository repository;

    @Override
    public MaterialEntity criar(MaterialEntity material) {
        material.setId(null);

        if(
                material.getCaminhoArquivo() == null ||
                        material.getCaminhoArquivo().isBlank() ||
                        !ehUrl(material.getCaminhoArquivo())
        ) {
            throw new RuntimeException("Caminho do arquivo é invalido.");
        }
        AgendaEntity agenda = agendaService.buscarPorId(material.getAgenda().getId());
        material.setAgenda(agenda);

        return repository.save(material);
    }

    @Override
    public List<MaterialEntity> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public MaterialEntity buscarPorId(Long id) {
        return repository.findById(id).orElseThrow(
                () -> new NotFoundException("Material com id " + id + " não encontrado.")
        );
    }

    @Override
    public MaterialEntity alterar(Long id, MaterialEntity material) {
        material.setId(id);
        buscarPorId(id);

        if(
                material.getCaminhoArquivo() == null ||
                material.getCaminhoArquivo().isBlank() ||
                !ehUrl(material.getCaminhoArquivo())
        ) {
            throw new RuntimeException("Caminho do arquivo é invalido.");
        }

        AgendaEntity agenda = agendaService.buscarPorId(material.getAgenda().getId());
        material.setAgenda(agenda);

        return repository.save(material);
    }

    @Override
    public void excluir(Long id) {
        buscarPorId(id);
        repository.deleteById(id);
    }

    private boolean ehUrl(String url) {
        String regex = "^(http(s)?:\\/\\/)(www\\.)(\\w*)(\\..*)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        return matcher.matches();
    }
}
