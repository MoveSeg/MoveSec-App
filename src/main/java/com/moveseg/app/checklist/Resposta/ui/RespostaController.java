package com.moveseg.app.checklist.Resposta.ui;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.checklist.Resposta.app.RespostaService;
import com.moveseg.app.checklist.Resposta.app.view.RespostaListView;
import com.moveseg.app.checklist.Resposta.domain.Resposta;
import com.moveseg.app.checklist.Resposta.domain.RespostaId;
import com.moveseg.app.checklist.Resposta.domain.cmd.Responder;
import com.moveseg.app.infra.auth.security.services.UserDetailsImpl;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/resposta", produces = APPLICATION_JSON_VALUE)
public class RespostaController {
    private RespostaService service;

    @PostMapping()
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
}
