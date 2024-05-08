package com.moveseg.app.cadastro.Instituto.ui;

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

import com.moveseg.app.cadastro.Instituto.app.InstitutoService;
import com.moveseg.app.cadastro.Instituto.app.view.InstitutoFormView;
import com.moveseg.app.cadastro.Instituto.app.view.InstitutoListView;
import com.moveseg.app.cadastro.Instituto.domain.Instituto;
import com.moveseg.app.cadastro.Instituto.domain.InstitutoId;
import com.moveseg.app.cadastro.Instituto.domain.cmd.AlterarInstituto;
import com.moveseg.app.cadastro.Instituto.domain.cmd.CriarInstituto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/instituto", produces = APPLICATION_JSON_VALUE)
public class InstitutoController {

    InstitutoService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Instituto> salvar(@RequestBody CriarInstituto cmd) {
        InstitutoId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<InstitutoListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public InstitutoFormView buscarPorId(@PathVariable @NonNull InstitutoId id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instituto> alterar(@PathVariable @NonNull InstitutoId id, @RequestBody AlterarInstituto cmd) {

        cmd.id(id);

        Instituto salvar = service.handle(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @DeleteMapping
    public ResponseEntity<Void> deletar(@PathVariable @NonNull InstitutoId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}