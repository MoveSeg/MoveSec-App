package com.moveseg.app.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.cadastroInstituicao.domain.InstitutoId;
import com.moveseg.app.cadastro.cadastroInstituicao.domain.Instituto.InstitutoBuilder;
import com.moveseg.app.cadastro.cadastroInstituicao.domain.Instituto;
import com.moveseg.app.repository.InstitutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitutoService {
    

    private InstitutoRepository repository;

    public Instituto salvar(Instituto instituto){
        return repository.save(instituto);
    }   public Optional<Instituto> buscarPorIdInstituto(InstitutoId id){
        return repository.findById(id);
    }
    
    public void deletarInstituto(InstitutoId id){
         
        repository.deleteById(id);

    }
}
