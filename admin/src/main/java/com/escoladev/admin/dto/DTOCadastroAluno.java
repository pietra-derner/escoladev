package com.escoladev.admin.dto;

import com.escoladev.admin.model.Endereco;
import com.escoladev.admin.model.Materia;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOCadastroAluno(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String dataNascimento,
        @NotBlank
        String email,
        @NotBlank
        Materia materia,
        @NotNull @Valid
        Endereco endereco
) {
}
