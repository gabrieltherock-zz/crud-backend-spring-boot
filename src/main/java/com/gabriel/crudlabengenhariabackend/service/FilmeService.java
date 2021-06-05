package com.gabriel.crudlabengenhariabackend.service;

import com.gabriel.crudlabengenhariabackend.model.Filme;
import com.gabriel.crudlabengenhariabackend.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    FilmeRepository filmeRepository;

    public List<Filme> findAll() {
        return filmeRepository.findAll();
    }

    public Filme getById(Long id) {
        return filmeRepository.getById(id);
    }

    public Filme save(Filme filme) {
        return filmeRepository.save(filme);
    }

    public Filme updateFilme(Filme novofilme) {
        if (!filmeRepository.existsById(novofilme.getId()))
            return null;
        return filmeRepository.save(novofilme);
    }
}
