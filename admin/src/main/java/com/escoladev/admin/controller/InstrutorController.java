package com.escoladev.admin.controller;

import com.escoladev.admin.dto.DTOAlteracaoInstrutor;
import com.escoladev.admin.dto.DTOCadastroInstrutor;
import com.escoladev.admin.dto.DTOListarInstrutor;
import com.escoladev.admin.model.Instrutor;
import com.escoladev.admin.repository.InstrutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @Transactional
    public void cadastra(@RequestBody @Valid DTOCadastroInstrutor dados){
        repository.save(new Instrutor(dados));
    }

    @GetMapping
    public Page<DTOListarInstrutor> listar(Pageable paginacao){
        return repository.findAll(paginacao).map(DTOListarInstrutor::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DTOAlteracaoInstrutor dados){
        var instrutor = repository.getReferenceById(dados.id());
        instrutor.atualizaInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }
}
