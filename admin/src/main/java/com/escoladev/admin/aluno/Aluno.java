package com.escoladev.admin.aluno;

import com.escoladev.admin.endereco.Endereco;
import com.escoladev.admin.instrutor.Materia;
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
}
