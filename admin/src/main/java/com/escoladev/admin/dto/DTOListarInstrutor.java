package com.escoladev.admin.dto;

import com.escoladev.admin.model.Instrutor;
import com.escoladev.admin.model.Materia;

public record DTOListarInstrutor(Long id, String nome, String email, Materia materia) {
    public DTOListarInstrutor(Instrutor instrutor){
        this(instrutor.getId(), instrutor.getNome(), instrutor.getEmail(), instrutor.getMateria());
    }
}
