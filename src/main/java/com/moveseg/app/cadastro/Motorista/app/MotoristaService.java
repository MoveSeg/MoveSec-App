package com.moveseg.app.cadastro.Motorista.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.Motorista.app.view.MotoristaFormView;
import com.moveseg.app.cadastro.Motorista.app.view.MotoristaListView;
import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;
import com.moveseg.app.cadastro.Motorista.domain.cmd.AlterarMotorista;
import com.moveseg.app.cadastro.Motorista.domain.cmd.CriarMotorista;
import com.moveseg.app.cadastro.Motorista.repository.MotoristaRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class MotoristaService {
        private MotoristaRepository repository;

        @NonNull
        @Lock(PESSIMISTIC_READ)
        public MotoristaId handle(@NonNull @Valid CriarMotorista cmd) throws Exception {
                Motorista motorista = Motorista.builder()
                                .nome(cmd.nome())
                                .nascimento(cmd.nascimento())
                                .email(cmd.email())
                                .telefone(cmd.telefone())
                                .endereco(cmd.endereco())
                                .genero(cmd.genero())
                                .cpf(cmd.cpf())
                                .build();

                repository.save(motorista);
                return motorista.id();
        }

        public Motorista alterarMotorista(@NonNull @Valid AlterarMotorista cmd) throws Exception {
                Motorista motorista = repository.findById(requireNonNull(cmd.id()))
                                .orElseThrow(
                                                () -> new EntityNotFoundException(
                                                                format("Not found any Business with code %s.",
                                                                                cmd.id().toUUID())));
                motorista.atualizar()
                                .nome(cmd.nome())
                                .nascimento(cmd.nascimento())
                                .email(cmd.email())
                                .telefone(cmd.telefone())
                                .endereco(cmd.endereco())
                                .genero(cmd.genero())
                                .cpf(cmd.cpf())
                                .aplicar();
                return repository.save(motorista);
        }

        @NonNull
        @Transactional(readOnly = true)
        public List<MotoristaListView> listarTodos() {
                return repository.findAll().stream().map(MotoristaListView::of).toList();
        }

        @Transactional(readOnly = true)
        public MotoristaFormView buscarPorId(@NonNull MotoristaId id) {
                return MotoristaFormView.of(repository.findById(requireNonNull(id))
                                .orElseThrow(
                                                () -> new EntityNotFoundException(
                                                                format("Not found any Business with code %s.",
                                                                                id.toUUID()))));
        }

        public void deletar(@NonNull MotoristaId id) {
                repository.deleteById(id);
        }
}
