package com.moveseg.app.checklist.Checklist.ui;

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

import com.moveseg.app.checklist.Checklist.app.ChecklistService;
import com.moveseg.app.checklist.Checklist.app.view.ChecklistFormView;
import com.moveseg.app.checklist.Checklist.app.view.ChecklistListView;
import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.ChecklistId;
import com.moveseg.app.checklist.Checklist.domain.cmd.AlterarChecklist;
import com.moveseg.app.checklist.Checklist.domain.cmd.CriarChecklist;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/checklist", produces = APPLICATION_JSON_VALUE)
public class ChecklistController {
     
    ChecklistService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Checklist> salvar(@RequestBody CriarChecklist cmd) {
        ChecklistId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest() 
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }


    @GetMapping
    public List<ChecklistListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ChecklistFormView buscarPorId(@PathVariable @NonNull ChecklistId id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Checklist> alterar(@PathVariable @NonNull ChecklistId id, @RequestBody AlterarChecklist cmd) {

        cmd.id(id);

        Checklist salvar = service.handle(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable @NonNull ChecklistId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
