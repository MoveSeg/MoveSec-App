package com.moveseg.app.checklist.GrupoChecklist.ui;

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

import com.moveseg.app.checklist.GrupoChecklist.app.GrupoChecklistService;
import com.moveseg.app.checklist.GrupoChecklist.app.list.GrupoChecklistFormView;
import com.moveseg.app.checklist.GrupoChecklist.app.list.GrupoChecklistListView;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklist;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklistId;
import com.moveseg.app.checklist.GrupoChecklist.domain.cmd.AlterarGrupoChecklist;
import com.moveseg.app.checklist.GrupoChecklist.domain.cmd.CriarGrupoChecklist;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/grupochecklist", produces = APPLICATION_JSON_VALUE)
public class GrupoChecklistController {
    GrupoChecklistService service;
    
    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<GrupoChecklist> salvar(@RequestBody CriarGrupoChecklist cmd) {
        GrupoChecklistId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest() 
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    
    @GetMapping
    public List<GrupoChecklistListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public GrupoChecklistFormView buscarPorId(@PathVariable @NonNull GrupoChecklistId id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GrupoChecklist> alterar(@PathVariable @NonNull GrupoChecklistId id, @RequestBody AlterarGrupoChecklist cmd) {

        cmd.id(id);

        GrupoChecklist salvar = service.handle(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable @NonNull GrupoChecklistId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
