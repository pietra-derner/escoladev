package com.escoladev.admin.instrutor;

import com.escoladev.admin.endereco.EnderecoDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DTOCadastrarInstrutor(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank @Email
        String email,
        @NotNull
        Materia materia,
        @NotNull @Valid
        EnderecoDTO enderecoDTO
) {

}
