package com.escoladev.admin.model;

import com.escoladev.admin.dto.DTOAlteracaoInstrutor;
import com.escoladev.admin.dto.DTOCadastroInstrutor;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Instrutor")
@Table(name = "instrutor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Instrutor {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;

    @Enumerated(EnumType.STRING)
    private Materia materia;

    @Embedded
    private Endereco endereco;

    public Instrutor(DTOCadastroInstrutor instrutor){
        this.nome = instrutor.nome();
        this.email = instrutor.email();
        this.materia = instrutor.materia();
        this.endereco = new Endereco(instrutor.endereco());
    }

    public void atualizaInformacoes(DTOAlteracaoInstrutor instrutor){
        if (instrutor.nome() != null){
            this.nome = instrutor.nome();
        }
        if (instrutor.email() != null){
            this.email = instrutor.email();
        }
        if (instrutor.endereco() != null){
            this.endereco.atualizaInformacoes(instrutor.endereco());
        }
    }
}
