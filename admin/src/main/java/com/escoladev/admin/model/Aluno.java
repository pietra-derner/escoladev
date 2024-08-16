package com.escoladev.admin.model;

import com.escoladev.admin.dto.DTOAlteracaoAluno;
import com.escoladev.admin.dto.DTOCadastroAluno;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Aluno")
@Table(name = "aluno")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dataNascimento;
    private String email;

    @Enumerated(EnumType.STRING)
    private Materia materia;

    @Embedded
    private Endereco endereco;


    public Aluno(DTOCadastroAluno aluno) {
        this.nome = aluno.nome();
        this.dataNascimento = aluno.dataNascimento();
        this.email = aluno.email();
        this.materia = aluno.materia();
        this.endereco = new Endereco(aluno.endereco());
    }

    public void atualizaInformacoes(DTOAlteracaoAluno aluno){
        if (aluno.nome() != null){
            this.nome = aluno.nome();
        }
        if (aluno.email() != null){
            this.email = aluno.email();
        }
        if (aluno.endereco() != null){
            this.endereco.atualizaInformacoes(aluno.endereco());
        }
    }
}
