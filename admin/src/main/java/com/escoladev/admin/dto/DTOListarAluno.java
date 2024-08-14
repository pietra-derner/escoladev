package com.escoladev.admin.dto;

import com.escoladev.admin.model.Aluno;
import com.escoladev.admin.model.Materia;

public record DTOListarAluno(Long id, String nome, String email, Materia materia) {
    public DTOListarAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getMateria());
    }
}
