package com.moveseg.app.cadastro.veiculo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.cmd.AtualizarVeiculo;
import com.moveseg.app.cmd.CriarVeiculo;
import com.moveseg.app.service.VeiculoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/veiculo")

public class VeiculoController {

   private final VeiculoService service;

   @Valid
   @PostMapping
   public ResponseEntity<Veiculo> salvar(@RequestBody CriarVeiculo veiculo) throws Exception {
      Veiculo veiculoSalvo = service.salvar(veiculo);
      return ResponseEntity.status(HttpStatus.CREATED).body(veiculoSalvo);
   }

   @GetMapping
   public ResponseEntity<List<Veiculo>> listarTodos() {
      List<Veiculo> veiculo = service.listarTodos();
      return ResponseEntity.status(HttpStatus.OK).body(veiculo);
   }

   @GetMapping("/{id}")
   public ResponseEntity<Veiculo> buscarPorId(@PathVariable VeiculoId id) {
      Optional<Veiculo> optVeiculo = service.buscarPorId(id);

      if (optVeiculo.isEmpty()) {
         return ResponseEntity.notFound().build();
      }
      return ResponseEntity.status(HttpStatus.OK).body(optVeiculo.get());
   }

   @Valid
   @PutMapping
   public ResponseEntity<Veiculo> atualizar(@PathVariable VeiculoId id,@RequestBody AtualizarVeiculo veiculo) {
      Veiculo veiculoSalvo = service.atualizarVeiculo(id, veiculo);
      return ResponseEntity.status(HttpStatus.OK).body(veiculoSalvo);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deletar(@PathVariable VeiculoId id) {
      service.deletar(id);
      return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
   }

}
