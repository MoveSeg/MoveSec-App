package com.moveseg.app.cadastro.veiculo.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.veiculo.app.view.VeiculoFormView;
import com.moveseg.app.cadastro.veiculo.app.view.VeiculoListView;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.cadastro.veiculo.domain.cmd.AtualizarVeiculo;
import com.moveseg.app.cadastro.veiculo.domain.cmd.CriarVeiculo;
import com.moveseg.app.cadastro.veiculo.repository.VeiculoRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class VeiculoService {

    private VeiculoRepository repository;

    @NonNull
    @Lock(PESSIMISTIC_READ)
    public VeiculoId handle(@NonNull @Valid CriarVeiculo cmd)  {
        Veiculo veiculo = Veiculo.builder()
                .placa(cmd.placa())
                .numeroDaFrota(cmd.numeroDaFrota())
                .chassi(cmd.chassi())
                .renavam(cmd.renavam())
                .anoModelo(cmd.anoModelo())
                .marca(cmd.marca())
                .modelo(cmd.modelo())
                .corPredominante(cmd.corPredominante())
                .capacidadeDePassageiros(cmd.capacidadeDePassageiros())
                .build();

        repository.save(veiculo);
        return veiculo.id();
    }

    public Veiculo handle(@NonNull @Valid AtualizarVeiculo cmd) {
        Veiculo veiculo = repository.findById(requireNonNull(cmd.id()))
                .orElseThrow(
                        () -> new EntityNotFoundException(
                                format("Não encontrado",
                                        cmd.id().toUUID())));

        veiculo.update()
                .placa(cmd.placa())
                .numeroDaFrota(cmd.numeroDaFrota())
                .chassi(cmd.chassi())
                .renavam(cmd.renavam())
                .anoModelo(cmd.anoModelo())
                .marca(cmd.marca())
                .modelo(cmd.modelo())
                .corPredominante(cmd.corPredominante())
                .capacidadeDePassageiros(cmd.capacidadeDePassageiros())
                .apply();
        return repository.save(veiculo);
    }

    @NonNull
    @Transactional(readOnly = true)
    public List<VeiculoListView> listarTodos() {
        return repository.findAll().stream().map(VeiculoListView::of).toList();
    }

    @Transactional(readOnly = true)
    public VeiculoFormView buscarPorId(@NonNull VeiculoId id) {
        return VeiculoFormView.of(repository.findById(requireNonNull(id))
                .orElseThrow(
                        () -> new EntityNotFoundException(format("Not found any Business with code %s.",
                                id.toUUID()))));
    }

    public void deletar(@NonNull VeiculoId id) {
        repository.deleteById(id);
    }

}
