package com.gabriel.crudlabengenhariabackend.repository;

import com.gabriel.crudlabengenhariabackend.model.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    List<Filme> findAllByTituloContains(String titulo);
}
