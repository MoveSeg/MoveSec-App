package com.moveseg.app.cadastro.responsavel.rest;

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

import com.moveseg.app.cadastro.responsavel.app.ResponsavelService;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.responsavel.domain.ResponsavelId;
import com.moveseg.app.cadastro.responsavel.domain.cmd.AtualizarResponsavel;
import com.moveseg.app.cadastro.responsavel.domain.cmd.CriarResponsavel;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/responsavel", produces = APPLICATION_JSON_VALUE)
public class ResponsavelController {

    private final ResponsavelService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> salvar(@RequestBody CriarResponsavel responsavel) throws Exception {
        ResponsavelId id = service.handle(responsavel);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<Responsavel> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Responsavel buscarPorId(@PathVariable @NonNull ResponsavelId id) {
        return service.buscarPorId(id);
    }

    @Valid
    @PutMapping
    public ResponseEntity<Responsavel> atualizar(@PathVariable @NonNull ResponsavelId id,
            @RequestBody AtualizarResponsavel responsavel) throws Exception {
        Responsavel responsavelSalvo = service.atualizarResponsavel(id, responsavel);
        return ResponseEntity.status(HttpStatus.OK).body(responsavelSalvo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable ResponsavelId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
