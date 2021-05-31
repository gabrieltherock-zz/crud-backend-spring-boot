package com.gabriel.crudlabengenhariabackend;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudLabengenhariaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudLabengenhariaBackendApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
