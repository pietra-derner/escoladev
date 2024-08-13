package com.escoladev.admin.aluno;

import com.escoladev.admin.endereco.Endereco;
import com.escoladev.admin.instrutor.Materia;
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
