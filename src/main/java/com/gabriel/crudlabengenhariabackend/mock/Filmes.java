package com.gabriel.crudlabengenhariabackend.mock;

import com.gabriel.crudlabengenhariabackend.model.Filme;
import com.gabriel.crudlabengenhariabackend.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class Filmes {

    @Autowired
    FilmeRepository repository;

//    @PostConstruct
    public void adicionarFilmes() {
        Filme filme1 = new Filme();
        filme1.setTitulo("Teste 1");
        filme1.setAno("2021");
        filme1.setDiretor("Gabriel");
        filme1.setGenero("Comédia");

        Filme filme2 = new Filme();
        filme2.setTitulo("Teste 2");
        filme2.setAno("2021");
        filme2.setDiretor("Gabriel");
        filme2.setGenero("Comédia");

        Filme filme3 = new Filme();
        filme3.setTitulo("Teste 3");
        filme3.setAno("2021");
        filme3.setDiretor("Gabriel");
        filme3.setGenero("Comédia");

        repository.saveAll(Arrays.asList(filme1, filme2, filme3));
    }
}
