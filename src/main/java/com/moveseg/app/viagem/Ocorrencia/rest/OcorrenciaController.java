package com.moveseg.app.viagem.Ocorrencia.rest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.viagem.Ocorrencia.app.OcorrenciaService;
import com.moveseg.app.viagem.Ocorrencia.domain.OcorrenciaId;
import com.moveseg.app.viagem.Ocorrencia.domain.cmd.CriarOcorrencia;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/ocorrencia", produces = APPLICATION_JSON_VALUE)
public class OcorrenciaController {

    private final OcorrenciaService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> salvar(@RequestBody CriarOcorrencia cmd) throws Exception {
        OcorrenciaId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }
}
