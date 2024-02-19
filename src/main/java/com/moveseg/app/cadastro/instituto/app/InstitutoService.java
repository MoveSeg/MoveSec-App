package com.moveseg.app.cadastro.instituto.app;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.instituto.domain.Instituto;
import com.moveseg.app.cadastro.instituto.domain.InstitutoId;
import com.moveseg.app.cadastro.instituto.domain.cmd.AlterarInstituto;
import com.moveseg.app.cadastro.instituto.domain.cmd.CriarInstituto;
import com.moveseg.app.cadastro.instituto.repository.InstitutoRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class InstitutoService {

    private InstitutoRepository repository;

    public Instituto handle(CriarInstituto cmd) throws Exception {

        Instituto instituto = Instituto.builder()
                .nome(cmd.nome())
                .endereco(cmd.endereco())
                .responsavel(cmd.responsavel())
                .telefone(cmd.telefone())
                .email(cmd.email())
                .build();

        return repository.save(instituto);
    }

    public Instituto handle(AlterarInstituto cmd) throws Exception {

        Instituto instituto = repository.findById(cmd.id()).get();

        instituto.atualizar()
                .nome(cmd.nome())
                .endereco(cmd.endereco())
                .responsavel(cmd.responsavel())
                .telefone(cmd.telefone())
                .email(cmd.email())
                .aplicar();

        return repository.save(instituto);
    }

    public Optional<Instituto> buscarPorId(InstitutoId id) {
        return repository.findById(id);
    }

    public void deletar(InstitutoId id) {

        repository.deleteById(id);

    }
}
