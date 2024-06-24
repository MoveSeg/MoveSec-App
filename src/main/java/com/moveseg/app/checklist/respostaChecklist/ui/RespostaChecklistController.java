package com.moveseg.app.checklist.respostaChecklist.ui;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.checklist.respostaChecklist.app.RespostaChecklistService;
import com.moveseg.app.checklist.respostaChecklist.app.view.RespostaChecklistFormView;
import com.moveseg.app.checklist.respostaChecklist.app.view.RespostaChecklistListView;
import com.moveseg.app.checklist.respostaChecklist.domain.RespostaChecklist;
import com.moveseg.app.checklist.respostaChecklist.domain.RespostaChecklistId;
import com.moveseg.app.checklist.respostaChecklist.domain.cmd.CriarRespostaChecklist;
import com.moveseg.app.infra.auth.security.services.UserDetailsImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/respostaChecklist", produces = APPLICATION_JSON_VALUE)
public class RespostaChecklistController {
    
    RespostaChecklistService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<RespostaChecklist> salvar(@RequestBody CriarRespostaChecklist cmd, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        cmd.idUsuario(userDetails.getId());
        RespostaChecklistId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest() 
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<RespostaChecklistListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public RespostaChecklistFormView buscarPorId(@PathVariable @NonNull RespostaChecklistId id) {
        return service.buscarPorId(id);
    }
}