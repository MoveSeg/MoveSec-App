package com.moveseg.app.viagem.app;

import static jakarta.persistence.LockModeType.PESSIMISTIC_READ;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;

import java.util.List;

import org.springframework.data.jpa.repository.Lock;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.cadastro.Aluno.repository.AlunoRepository;
import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;
import com.moveseg.app.cadastro.Motorista.repository.MotoristaRepository;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.cadastro.veiculo.repository.VeiculoRepository;
import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.app.viagem.Rota.domain.RotaId;
import com.moveseg.app.viagem.Rota.repository.RotaRepository;
import com.moveseg.app.viagem.app.view.ViagemFormView;
import com.moveseg.app.viagem.app.view.ViagemListView;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.domain.ViagemId;
import com.moveseg.app.viagem.domain.cmd.AlterarViagem;
import com.moveseg.app.viagem.domain.cmd.CriarViagem;
import com.moveseg.app.viagem.repository.ViagemRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@Service
@Transactional(propagation = REQUIRES_NEW)
@AllArgsConstructor
public class ViagemService {
        private ViagemRepository repository;
        private RotaRepository rotaRepository;
        private VeiculoRepository veiculoRepository;
        private MotoristaRepository motoristaRepository;
        private AlunoRepository alunoRepository;
  
        @NonNull
        @Lock(PESSIMISTIC_READ)
        public ViagemId handle(@NonNull @Valid CriarViagem cmd)  {
                List<Aluno> alunos = alunoRepository.findAllById(cmd.alunos().stream().map(AlunoId::new).toList());
                Rota rota = rotaRepository.findById((RotaId) cmd.rota()).get();
                Motorista motorista = motoristaRepository.findById((MotoristaId) cmd.motorista()).get();
                Veiculo veiculo = veiculoRepository.findById((VeiculoId) cmd.veiculo()).get();

                Viagem viagem = Viagem.builder()
                                .alunos(alunos)
                                .motorista(motorista)
                                .rota(rota)
                                .veiculo(veiculo)
                                .data(cmd.data())
                                .build();

                repository.save(viagem); 
                return viagem.id();
        }

        public Viagem handle(@NonNull @Valid AlterarViagem cmd) {
                List<Aluno> alunos = alunoRepository.findAllById(cmd.alunos().stream().map(AlunoId::new).toList());
                Rota rota = rotaRepository.findById((RotaId) cmd.rota()).get();
                Motorista motorista = motoristaRepository.findById((MotoristaId) cmd.motorista()).get();
                Veiculo veiculo = veiculoRepository.findById((VeiculoId) cmd.veiculo()).get();

                Viagem viagem = repository.findById(requireNonNull(cmd.id()))
                                .orElseThrow(
                                                () -> new EntityNotFoundException(
                                                                format("Not found any Business with code %s.",
                                                                                cmd.id().toUUID())));
                viagem.atualizar()
                                .alunos(alunos)
                                .motorista(motorista)
                                .rota(rota)
                                .veiculo(veiculo)
                                .data(cmd.data())
                                .aplicar();
                return repository.save(viagem);
        }

        @NonNull
        @Transactional(readOnly = true)
        public List<ViagemListView> listarTodos() {
                return repository.findAll().stream().map(ViagemListView::of).toList();
        }

        @Transactional(readOnly = true)
        public ViagemFormView buscarPorId(@NonNull ViagemId id) {
                return ViagemFormView.of(repository.findById(requireNonNull(id))
                                .orElseThrow(
                                                () -> new EntityNotFoundException(
                                                                format("Not found any Business with code %s.",
                                                                                id.toUUID()))));
        }

        public void deletar(@NonNull ViagemId id) {
                repository.deleteById(id);
        }

}