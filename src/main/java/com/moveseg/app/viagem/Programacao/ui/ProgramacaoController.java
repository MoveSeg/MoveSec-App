package com.moveseg.app.viagem.Programacao.ui;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.viagem.Programacao.app.ProgramacaoService;
import com.moveseg.app.viagem.Programacao.app.view.ProgramacaoFormView;
import com.moveseg.app.viagem.Programacao.app.view.ProgramacaoListView;
import com.moveseg.app.viagem.Programacao.domain.Programacao;
import com.moveseg.app.viagem.Programacao.domain.ProgramacaoId;
import com.moveseg.app.viagem.Programacao.domain.cmd.CriarProgramacao;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/programacao", produces = APPLICATION_JSON_VALUE)
public class ProgramacaoController {

    ProgramacaoService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Programacao> salvar(@RequestBody CriarProgramacao cmd) {
        ProgramacaoId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<ProgramacaoListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/pessoas/{id}")
    public List<ProgramacaoListView> listarPorIdDePessoas(@PathVariable @NonNull String id, @RequestParam("dataInicio") @NonNull LocalDate dataInicio, @RequestParam("dataFim") @NonNull LocalDate dataFim) {
        return service.buscarPorIdDePessoas(id, dataInicio, dataFim);
    }

    @GetMapping("/{id}")
    public ProgramacaoFormView buscarPorId(@PathVariable @NonNull ProgramacaoId id) {
        return service.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable @NonNull ProgramacaoId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}