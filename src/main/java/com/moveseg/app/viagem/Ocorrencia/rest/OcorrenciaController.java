package com.moveseg.app.viagem.Ocorrencia.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.viagem.Ocorrencia.app.OcorrenciaService;
import com.moveseg.app.viagem.Ocorrencia.app.view.OcorrenciaFormView;
import com.moveseg.app.viagem.Ocorrencia.app.view.OcorrenciaListView;
import com.moveseg.app.viagem.Ocorrencia.domain.Ocorrencia;
import com.moveseg.app.viagem.Ocorrencia.domain.OcorrenciaId;
import com.moveseg.app.viagem.Ocorrencia.domain.cmd.CriarOcorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/ocorrencia", produces = APPLICATION_JSON_VALUE)
public class OcorrenciaController {

    private final OcorrenciaService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Ocorrencia> salvar(@RequestBody CriarOcorrencia cmd) throws Exception {
        OcorrenciaId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<OcorrenciaListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public OcorrenciaFormView buscarPorId(@PathVariable @NonNull OcorrenciaId id) {
        return service.buscarPorId(id);
    }
}
