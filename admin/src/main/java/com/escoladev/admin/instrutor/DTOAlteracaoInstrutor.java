package com.escoladev.admin.instrutor;

import com.escoladev.admin.endereco.EnderecoDTO;
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