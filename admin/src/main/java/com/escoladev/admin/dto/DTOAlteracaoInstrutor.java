package com.escoladev.admin.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DTOAlteracaoInstrutor(
        @NotNull
        Long id,
        String nome,
        String email,
        @Valid
        EnderecoDTO endereco) {

}