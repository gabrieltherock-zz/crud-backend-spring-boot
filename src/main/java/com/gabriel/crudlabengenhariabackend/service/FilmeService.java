package com.gabriel.crudlabengenhariabackend.service;

import com.gabriel.crudlabengenhariabackend.exception.ObjectNotFoundException;
import com.gabriel.crudlabengenhariabackend.model.Filme;
import com.gabriel.crudlabengenhariabackend.model.FilmeDTO;
import com.gabriel.crudlabengenhariabackend.repository.FilmeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    @Autowired
    ModelMapper mapper;

    public List<FilmeDTO> findAll(String titulo) {
        List<Filme> filmes;

        if (titulo.isEmpty()) {
            filmes = filmeRepository.findAll();
        } else {
            filmes = filmeRepository.findAllByTituloContains(titulo);
        }
        return filmes.stream()
                .map(this::mapToFilmeDTO)
                .collect(Collectors.toList());
    }

    public FilmeDTO getById(Long id) {
        Optional<Filme> filme = filmeRepository.findById(id);
        return mapToFilmeDTO(filme.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!")));
    }

    public FilmeDTO save(FilmeDTO filmeDTO) {
        Filme filme = filmeRepository.save(mapToFilme(filmeDTO));
        return mapToFilmeDTO(filme);
    }

    public FilmeDTO updateFilme(Long id, FilmeDTO novofilme) {
        getById(id);
        Filme filme = mapToFilme(novofilme);
        filme.setId(id);
        filme = filmeRepository.save(filme);
        return mapToFilmeDTO(filme);
    }

    public void deleteFilme(Long id) {
        getById(id);
        filmeRepository.deleteById(id);
    }

    public void deleteAll() {
        filmeRepository.deleteAll();
    }

    public FilmeDTO mapToFilmeDTO(Filme filme) {
        return mapper.map(filme, FilmeDTO.class);
    }

    public Filme mapToFilme(FilmeDTO filmeDTO) {
        return mapper.map(filmeDTO, Filme.class);
    }
}
