package com.gabriel.crudlabengenhariabackend.controller;

import com.gabriel.crudlabengenhariabackend.model.FilmeDTO;
import com.gabriel.crudlabengenhariabackend.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
public class FilmeController {

    @Autowired
    FilmeService filmeService;

    @GetMapping("/filmes")
    public ResponseEntity<List<FilmeDTO>> getFilmes() {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.findAll());
    }

    @GetMapping("/filmes/{id}")
    public ResponseEntity<FilmeDTO> getFilmePorId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.getById(id));
    }

    @PostMapping("/filmes")
    public ResponseEntity<FilmeDTO> postFilme(@Valid @RequestBody FilmeDTO filme) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.save(filme));
    }

    @PutMapping("/filmes/{id}")
    public ResponseEntity<FilmeDTO> updateFilme(@PathVariable Long id,
                                                @Valid @RequestBody FilmeDTO filme) {
        return ResponseEntity.status(HttpStatus.OK).body(filmeService.updateFilme(id, filme));
    }

    @DeleteMapping("/filmes/{id}")
    public ResponseEntity<String> deleteFilmePorId(@PathVariable Long id) {
        filmeService.deleteFilme(id);
        return ResponseEntity.status(HttpStatus.OK).body("");
    }

    @DeleteMapping("/filmes")
    public ResponseEntity<String> deleteFilmes() {
        filmeService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
