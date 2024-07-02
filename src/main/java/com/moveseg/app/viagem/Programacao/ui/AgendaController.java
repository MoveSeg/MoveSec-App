package com.moveseg.app.viagem.Programacao.ui;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.viagem.Programacao.app.ProgramacaoService;
import com.moveseg.app.viagem.Programacao.domain.Programacao;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/agenda", produces = APPLICATION_JSON_VALUE)
public class AgendaController {

    ProgramacaoService service;

    @GetMapping
    public List<Programacao> listarTodos() {
        return service.agenda();
    }
}
