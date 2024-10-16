package com.moveseg.app.viagem.Rota.app;


import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.viagem.Rota.app.view.RotaListView;
import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.app.viagem.Rota.domain.RotaId;
import com.moveseg.app.viagem.Rota.domain.cmd.AtualizarRota;
import com.moveseg.app.viagem.Rota.domain.cmd.CriarRota;
import com.moveseg.app.viagem.Rota.repository.RotaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class RotaService {
    private RotaRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public RotaId handle(@NonNull @Valid CriarRota cmd) {

        Rota rota = Rota.of(cmd.numeroRota(), cmd.enderecos());
        
        repository.save(rota);
        return rota.id();
    }

    public Rota handle(@NonNull @Valid AtualizarRota cmd) {
        Rota rota = repository.findById(requireNonNull(cmd.id()))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Not found any Business with code %s.",
                                        cmd.id().toUUID())));
        rota.atualizar()
                .numeroRota(cmd.numeroRota())
                .endereco(cmd.enderecos())
                .aplicar();
        return repository.save(rota);
    }


    @NonNull
    @Transactional(readOnly = true)
    public List<RotaListView> listarTodos() {
        return repository.findAll().stream().map(RotaListView::of).toList();
    }

    @Transactional(readOnly = true)
    public RotaListView buscarPorId(@NonNull RotaId id) {
        Rota rota = repository.findById(requireNonNull(id))
         .orElseThrow(
            () -> new EntityNotFoundException(
                    format("Not found any Business with code %s.",
                            id.toUUID())));
        return RotaListView.of(rota);
               
    }

    public void deletar(@NonNull RotaId id) {
        repository.deleteById(id);
    }
}