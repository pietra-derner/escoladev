package com.escoladev.admin.dto;

import com.escoladev.admin.model.Materia;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOCadastroAluno(
        @NotBlank
        String nome,
        @NotBlank
        String dataNascimento,
        @NotBlank
        String email,
        @NotNull
        Materia materia,
        @NotNull @Valid
        EnderecoDTO endereco
) {
}
