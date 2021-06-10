package com.gabriel.crudlabengenhariabackend.service;

import com.gabriel.crudlabengenhariabackend.model.Filme;
import com.gabriel.crudlabengenhariabackend.model.FilmeDTO;
import com.gabriel.crudlabengenhariabackend.repository.FilmeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    ModelMapper mapper;

    public List<FilmeDTO> findAll() {
        List<Filme> filmes = filmeRepository.findAll();
        return filmes.stream()
                .map(this::mapToFilmeDTO)
                .collect(Collectors.toList());
    }

    public FilmeDTO getById(Long id) {
        Filme filme = filmeRepository.getById(id);
        return mapToFilmeDTO(filme);
    }

    public FilmeDTO save(FilmeDTO filmeDTO) {
        Filme filme = filmeRepository.save(mapToFilme(filmeDTO));
        return mapToFilmeDTO(filme);
    }

    public FilmeDTO updateFilme(Long id, FilmeDTO novofilme) {
        Filme filme = mapToFilme(novofilme);
        filme.setId(id);
        filme = filmeRepository.save(filme);
        return mapToFilmeDTO(filme);
    }

    public void deleteFilme(Long id) {
        filmeRepository.deleteById(id);
    }

    public FilmeDTO mapToFilmeDTO(Filme filme) {
        return mapper.map(filme, FilmeDTO.class);
    }

    public Filme mapToFilme(FilmeDTO filmeDTO) {
        return mapper.map(filmeDTO, Filme.class);
    }

    public boolean existe(Long id) {
        return filmeRepository.existsById(id);
    }
}
