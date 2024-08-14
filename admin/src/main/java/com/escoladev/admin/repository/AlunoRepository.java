package com.escoladev.admin.repository;

import com.escoladev.admin.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository <Aluno, Long> {
}
