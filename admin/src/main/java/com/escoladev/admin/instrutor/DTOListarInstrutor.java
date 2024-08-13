package com.escoladev.admin.instrutor;

public record DTOListarInstrutor(Long id, String nome, String email, Materia materia) {
    public DTOListarInstrutor(Instrutor instrutor){
        this(instrutor.getId(), instrutor.getNome(), instrutor.getEmail(), instrutor.getMateria());
    }
}
