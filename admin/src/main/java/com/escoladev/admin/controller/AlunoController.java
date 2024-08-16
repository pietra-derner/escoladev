package com.escoladev.admin.controller;

import com.escoladev.admin.dto.DTOAlteracaoAluno;
import com.escoladev.admin.dto.DTOCadastroAluno;
import com.escoladev.admin.dto.DTOListarAluno;
import com.escoladev.admin.model.Aluno;
import com.escoladev.admin.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid DTOCadastroAluno dados){
        repository.save(new Aluno(dados));
    }

    @GetMapping
    public Page<DTOListarAluno> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DTOListarAluno::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DTOAlteracaoAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizaInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
