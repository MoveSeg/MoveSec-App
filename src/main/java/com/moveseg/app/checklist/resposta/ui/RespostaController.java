package com.moveseg.app.checklist.resposta.ui;

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

import com.moveseg.app.checklist.resposta.app.RespostaService;
import com.moveseg.app.checklist.resposta.app.view.RespostaFormView;
import com.moveseg.app.checklist.resposta.app.view.RespostaListView;
import com.moveseg.app.checklist.resposta.domain.Resposta;
import com.moveseg.app.checklist.resposta.domain.RespostaId;
import com.moveseg.app.checklist.resposta.domain.cmd.Responder;
import com.moveseg.app.infra.auth.security.services.UserDetailsImpl;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/respostaChecklist", produces = APPLICATION_JSON_VALUE)
public class RespostaController {
    
    RespostaService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Resposta> salvar(@RequestBody Responder cmd, Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        cmd.idUsuario(userDetails.getId());
        RespostaId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest() 
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<RespostaListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public RespostaFormView buscarPorId(@PathVariable @NonNull RespostaId id) {
        return service.buscarPorId(id);
    }
}