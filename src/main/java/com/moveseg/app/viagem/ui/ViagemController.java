package com.moveseg.app.viagem.ui;

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

import com.moveseg.app.viagem.app.ViagemService;
import com.moveseg.app.viagem.domain.Viagem;
import com.moveseg.app.viagem.domain.ViagemId;
import com.moveseg.app.viagem.domain.cmd.AlterarViagem;
import com.moveseg.app.viagem.domain.cmd.CriarViagem;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/viagem", produces = APPLICATION_JSON_VALUE)
public class ViagemController {
    ViagemService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Viagem> salvar(@RequestBody CriarViagem cmd) {
        ViagemId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<Viagem> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Viagem buscarPorId(@PathVariable @NonNull ViagemId id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viagem> alterar(@PathVariable @NonNull ViagemId id, @RequestBody AlterarViagem cmd) {

        cmd.id(id);

        Viagem salvar = service.handle(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable @NonNull ViagemId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
