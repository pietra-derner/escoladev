package com.escoladev.admin.dto;

import com.escoladev.admin.model.Materia;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOCadastrarAluno(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String dataNascimento,
        @NotBlank @Email
        String email,
        @NotNull
        Materia materia,
        @NotNull @Valid
        EnderecoDTO enderecoDTO
) {

}
