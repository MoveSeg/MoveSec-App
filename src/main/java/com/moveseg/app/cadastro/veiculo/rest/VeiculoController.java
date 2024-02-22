package com.moveseg.app.cadastro.veiculo.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.cadastro.veiculo.app.VeiculoService;
import com.moveseg.app.cadastro.veiculo.app.cmd.AtualizarVeiculo;
import com.moveseg.app.cadastro.veiculo.app.cmd.CriarVeiculo;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/veiculo", produces = APPLICATION_JSON_VALUE)
public class VeiculoController {

    private final VeiculoService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> salvar(@RequestBody CriarVeiculo veiculo) throws Exception {
        VeiculoId id = service.handle(veiculo);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<Veiculo> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Veiculo buscarPorId(@PathVariable @NonNull VeiculoId id) {
        return service.buscarPorId(id);
    }

    @Valid
    @PutMapping
    public ResponseEntity<Veiculo> atualizar(@PathVariable @NonNull VeiculoId id,
            @RequestBody AtualizarVeiculo veiculo) throws Exception {
        Veiculo veiculoSalvo = service.atualizarVeiculo(id, veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable VeiculoId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
