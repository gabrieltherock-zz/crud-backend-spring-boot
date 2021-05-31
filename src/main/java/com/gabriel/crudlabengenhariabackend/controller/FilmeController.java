package com.gabriel.crudlabengenhariabackend.controller;

import com.gabriel.crudlabengenhariabackend.model.Filme;
import com.gabriel.crudlabengenhariabackend.model.FilmeDTO;
import com.gabriel.crudlabengenhariabackend.service.FilmeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @Autowired
    ModelMapper mapper;

    @PostMapping("/filmes/create")
    public ResponseEntity<FilmeDTO> postFilme(@Valid @RequestBody Filme filme) {
        FilmeDTO filmeDTO = mapper.map(filmeService.save(filme), FilmeDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeDTO);
    }

    @GetMapping("/filmes")
    public List<FilmeDTO> getFilmes() {
        List<Filme> filmes = filmeService.findAll();
        return filmes.stream()
                .map(c -> mapper.map(c, FilmeDTO.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/filmes/{id}")
    public FilmeDTO getFilmePorId(@PathVariable Long id) {
        Filme filme = filmeService.getById(id);
        return mapper.map(filme, FilmeDTO.class);
    }
}
