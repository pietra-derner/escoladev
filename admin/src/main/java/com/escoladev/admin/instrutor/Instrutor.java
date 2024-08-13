package com.escoladev.admin.instrutor;

import com.escoladev.admin.endereco.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Instrutor")
@Table(name = "instrutores")
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

    public Instrutor(DTOCadastrarInstrutor instrutor){
        this.nome = instrutor.nome();
        this.email = instrutor.email();
        this.materia = instrutor.materia();
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
