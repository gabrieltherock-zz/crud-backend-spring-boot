package com.gabriel.crudlabengenhariabackend.controller;

import com.gabriel.crudlabengenhariabackend.model.Filme;
import com.gabriel.crudlabengenhariabackend.model.FilmeDTO;
import com.gabriel.crudlabengenhariabackend.service.FilmeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @Autowired
    ModelMapper mapper;

    @GetMapping("/filmes")
    public List<FilmeDTO> getFilmes() {
        List<Filme> filmes = filmeService.findAll();
        return filmes.stream()
                .map(c -> mapper.map(c, FilmeDTO.class))
                .collect(Collectors.toList());
    }
}
