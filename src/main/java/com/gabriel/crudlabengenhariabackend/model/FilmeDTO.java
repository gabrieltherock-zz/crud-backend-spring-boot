package com.gabriel.crudlabengenhariabackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDTO {

    private Long id;

    private String titulo;
    private String diretor;
    private String genero;
    private String ano;
}
