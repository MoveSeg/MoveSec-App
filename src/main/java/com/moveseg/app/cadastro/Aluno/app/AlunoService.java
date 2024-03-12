package com.moveseg.app.cadastro.Aluno.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.cadastro.Aluno.domain.cmd.AlterarAluno;
import com.moveseg.app.cadastro.Aluno.domain.cmd.CriarAluno;
import com.moveseg.app.cadastro.Aluno.repository.AlunoRepository;
import com.moveseg.app.viagem.cmd.CriarViagem;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class AlunoService {
        private AlunoRepository repository;

        @NonNull
        @Lock(PESSIMISTIC_READ)
        public AlunoId handle(@NonNull @Valid CriarAluno cmd) {

                Aluno aluno = Aluno.builder()
                                .nome(cmd.nome())
                                .endereco(cmd.endereco())
                                .responsavel(cmd.responsavel())
                                .telefone(cmd.telefone())
                                .email(cmd.email())
                                .build();

                repository.save(aluno);

                return aluno.id();
        }

        public Aluno handle(@NonNull @Valid AlterarAluno cmd) {
                Aluno aluno = repository.findById(requireNonNull(cmd.id()))
                                .orElseThrow(
                                                () -> new EntityNotFoundException(
                                                                format("Not found any Business with code %s.",
                                                                                cmd.id().toUUID())));
                aluno.atualizar()
                                .nome(cmd.nome())
                                .responsavel(cmd.responsavel())
                                .carteirinha(cmd.carteirinha())
                                .telefone(cmd.telefone())
                                .email(cmd.email())
                                .endereco(cmd.endereco())
                                .genero(cmd.genero())
                                .cpf(cmd.cpf())
                                .aplicar();
                return repository.save(aluno);
        }

        @NonNull

        @Transactional(readOnly = true)
        public List<Aluno> listarTodos() {
                return repository.findAll();
        }

        @Transactional(readOnly = true)
        public Aluno buscarPorId(@NonNull AlunoId id) {
                return repository.findById(requireNonNull(id))
                                .orElseThrow(
                                                () -> new EntityNotFoundException(
                                                                format("Not found any Business with code %s.",
                                                                                id.toUUID())));
        }

        public void deletar(@NonNull AlunoId id) {
                repository.deleteById(id);
        }

}