package com.gabriel.crudlabengenhariabackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FilmeDTO {

    @NotNull(message = "o campo id é obrigatório!")
    private Long id;

    @NotBlank(message = "o campo titulo é obrigatório!")
    private String titulo;

    @NotBlank(message = "o campo diretor é obrigatório!")
    private String diretor;

    @NotBlank(message = "o campo genero é obrigatório!")
    private String genero;

    @NotBlank(message = "o campo ano é obrigatório!")
    private String ano;
}
