package com.escoladev.admin.model;

import com.escoladev.admin.dto.DTOCadastrarAluno;
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

    public Aluno(DTOCadastrarAluno aluno) {
        this.nome = aluno.nome();
        this.dataNascimento = aluno.dataNascimento();
        this.email = aluno.email();
        this.materia = aluno.materia();
        this.endereco = new Endereco(aluno.enderecoDTO());
    }
}
