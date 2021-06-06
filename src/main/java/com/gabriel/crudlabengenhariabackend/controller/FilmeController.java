package com.gabriel.crudlabengenhariabackend.controller;

import com.gabriel.crudlabengenhariabackend.model.FilmeDTO;
import com.gabriel.crudlabengenhariabackend.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @PostMapping("/filmes/create")
    public ResponseEntity<FilmeDTO> postFilme(@Valid @RequestBody FilmeDTO filme) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.save(filme));
    }

    @GetMapping("/filmes")
    public ResponseEntity<List<FilmeDTO>> getFilmes() {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.findAll());
    }

    @GetMapping("/filmes/{id}")
    public ResponseEntity<FilmeDTO> getFilmePorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getById(id));
    }

    @PutMapping("/filmes/update")
    public ResponseEntity<FilmeDTO> updateFilme(@Valid @RequestBody FilmeDTO filme) {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.updateFilme(filme));
    }
}
