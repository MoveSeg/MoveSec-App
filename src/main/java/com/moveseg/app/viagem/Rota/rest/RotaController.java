package com.moveseg.app.viagem.Rota.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.viagem.Rota.app.RotaService;
import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.app.viagem.Rota.domain.RotaId;
import com.moveseg.app.viagem.Rota.domain.cmd.AtualizarRota;
import com.moveseg.app.viagem.Rota.domain.cmd.CriarRota;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/rota", produces = APPLICATION_JSON_VALUE)
public class RotaController {

    private final RotaService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Rota> salvar(@RequestBody CriarRota cmd) throws Exception {
        RotaId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<Rota> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Rota buscarPorId(@PathVariable @NonNull RotaId id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rota> alterar(@PathVariable @NonNull RotaId id, @RequestBody AtualizarRota cmd) {

        cmd.id(id);

        Rota salvar = service.handle(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable @NonNull RotaId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}