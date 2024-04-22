package com.moveseg.app.viagem.ausencias.ui;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.viagem.ausencias.app.AusenciaService;
import com.moveseg.app.viagem.ausencias.domain.Ausencia;
import com.moveseg.app.viagem.ausencias.domain.AusenciaId;
import com.moveseg.app.viagem.ausencias.domain.cmd.RegistrarAusencia;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/ausencia", produces = APPLICATION_JSON_VALUE)
public class AusenciaController {

    AusenciaService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Ausencia> salvar(@RequestBody RegistrarAusencia cmd) throws Exception {
        AusenciaId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<Ausencia> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Ausencia buscarPorId(@PathVariable @NonNull AusenciaId id) {
        return service.buscarPorId(id);
    }

    
}

