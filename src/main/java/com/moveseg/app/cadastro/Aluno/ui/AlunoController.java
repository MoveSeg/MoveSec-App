package com.moveseg.app.cadastro.Aluno.ui;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.cadastro.Aluno.app.AlunoService;
import com.moveseg.app.cadastro.Aluno.app.view.AlunoFormView;
import com.moveseg.app.cadastro.Aluno.app.view.AlunoListView;
import com.moveseg.app.cadastro.Aluno.domain.Aluno;
import com.moveseg.app.cadastro.Aluno.domain.AlunoId;
import com.moveseg.app.cadastro.Aluno.domain.cmd.AlterarAluno;
import com.moveseg.app.cadastro.Aluno.domain.cmd.CriarAluno;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping(path = "/api/aluno", produces = APPLICATION_JSON_VALUE)
public class AlunoController {
    AlunoService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Aluno> salvar(@RequestBody CriarAluno cmd) {
        AlunoId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<AlunoListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public AlunoFormView buscarPorId(@PathVariable @NonNull AlunoId id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> alterar(@PathVariable @NonNull AlunoId id, @RequestBody AlterarAluno cmd) {

        cmd.id(id);

        Aluno salvar = service.handle(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable @NonNull AlunoId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}