package com.moveseg.app.cadastro.Monitor.ui;

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

import com.moveseg.app.cadastro.Monitor.app.MonitorService;
import com.moveseg.app.cadastro.Monitor.app.view.MonitorFormView;
import com.moveseg.app.cadastro.Monitor.app.view.MonitorListView;
import com.moveseg.app.cadastro.Monitor.domain.Monitor;
import com.moveseg.app.cadastro.Monitor.domain.MonitorId;
import com.moveseg.app.cadastro.Monitor.domain.cmd.AtualizarMonitor;
import com.moveseg.app.cadastro.Monitor.domain.cmd.CriarMonitor;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/monitor", produces = APPLICATION_JSON_VALUE)
public class MonitorController {

    private final MonitorService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> salvar(@RequestBody CriarMonitor monitor) throws Exception {
        MonitorId id = service.handle(monitor);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<MonitorListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public MonitorFormView buscarPorId(@PathVariable @NonNull MonitorId id) {
        return service.buscarPorId(id);
    }

    @Valid
    @PutMapping
    public ResponseEntity<Monitor> atualizar(@PathVariable @NonNull MonitorId id,
            @RequestBody AtualizarMonitor monitor) throws Exception {
        Monitor monitorSalvo = service.atualizarMonitor(id, monitor);
        return ResponseEntity.status(HttpStatus.OK).body(monitorSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable MonitorId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
