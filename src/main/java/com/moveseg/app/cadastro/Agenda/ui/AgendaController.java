package com.moveseg.app.cadastro.Agenda.ui;

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

import com.moveseg.app.cadastro.Agenda.app.AgendaService;
import com.moveseg.app.cadastro.Agenda.domain.Agenda;
import com.moveseg.app.cadastro.Agenda.domain.AgendaId;
import com.moveseg.app.cadastro.Agenda.domain.cmd.CriarAgenda;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/agenda", produces = APPLICATION_JSON_VALUE)
public class AgendaController {

    AgendaService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Agenda> salvar(@RequestBody CriarAgenda cmd) {
        AgendaId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<Agenda> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Agenda buscarPorId(@PathVariable @NonNull AgendaId id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable @NonNull AgendaId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}