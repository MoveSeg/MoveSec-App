package com.moveseg.app.cadastro.instituto.ui;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.cadastro.instituto.app.InstitutoService;
import com.moveseg.app.cadastro.instituto.domain.Instituto;
import com.moveseg.app.cadastro.instituto.domain.InstitutoId;
import com.moveseg.app.cadastro.instituto.domain.cmd.AlterarInstituto;
import com.moveseg.app.cadastro.instituto.domain.cmd.CriarInstituto;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RequiredArgsConstructor
@RestController
@RequestMapping("/instituto")
public class InstitutoController {

    InstitutoService service;

    @PostMapping
    public ResponseEntity<Instituto> salvar(@RequestBody CriarInstituto cmd) throws Exception {

        Instituto salvar = service.handle(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instituto> buscarPorId(@PathVariable InstitutoId id) {
        Optional<Instituto> instituto = service.buscarPorId(id);

        if (instituto.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.OK).body(instituto.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instituto> alterar(@PathVariable InstitutoId id, @RequestBody AlterarInstituto cmd) throws Exception {
        
        cmd.id(id);
        
        Instituto salvar = service.handle(cmd);

        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable InstitutoId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}