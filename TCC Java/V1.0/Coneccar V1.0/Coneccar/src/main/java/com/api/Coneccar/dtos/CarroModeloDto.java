package com.api.Coneccar.dtos;

import jakarta.validation.constraints.NotBlank;

public class CarroModeloDto {

    @NotBlank
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
