package com.escoladev.admin.dto;

import com.escoladev.admin.model.Materia;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DTOAlteracaoAluno(
        @NotNull
        Long id,
        String nome,
        String email,
        Materia materia,
        @Valid
        EnderecoDTO endereco) {

}