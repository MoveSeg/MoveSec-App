package com.moveseg.app.cadastro.veiculo.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.cadastro.veiculo.app.VeiculoService;
import com.moveseg.app.cadastro.veiculo.app.view.VeiculoFormView;
import com.moveseg.app.cadastro.veiculo.app.view.VeiculoListView;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.cadastro.veiculo.domain.cmd.AtualizarVeiculo;
import com.moveseg.app.cadastro.veiculo.domain.cmd.CriarVeiculo;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/veiculo", produces = APPLICATION_JSON_VALUE)
public class VeiculoController {

    VeiculoService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Veiculo> salvar(@RequestBody CriarVeiculo cmd) throws Exception {
        VeiculoId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<VeiculoListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public VeiculoFormView buscarPorId(@PathVariable @NonNull VeiculoId id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> atualizar(@PathVariable @NonNull VeiculoId id,
            @RequestBody AtualizarVeiculo cmd) throws Exception {

        cmd.id(id);
        Veiculo salvar = service.handle(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable VeiculoId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
