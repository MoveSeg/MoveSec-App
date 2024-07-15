package com.moveseg.app.cadastro.Motorista.ui;

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

import com.moveseg.app.cadastro.Motorista.app.MotoristaService;
import com.moveseg.app.cadastro.Motorista.app.view.MotoristaFormView;
import com.moveseg.app.cadastro.Motorista.app.view.MotoristaListView;
import com.moveseg.app.cadastro.Motorista.domain.Motorista;
import com.moveseg.app.cadastro.Motorista.domain.MotoristaId;
import com.moveseg.app.cadastro.Motorista.domain.cmd.AlterarMotorista;
import com.moveseg.app.cadastro.Motorista.domain.cmd.CriarMotorista;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/Motorista", produces =APPLICATION_JSON_VALUE)
public class MotoristaController {
    private final MotoristaService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> salvar(@RequestBody CriarMotorista cmd) throws Exception {
    
        MotoristaId  id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest()
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<MotoristaListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public MotoristaFormView buscarPorId(@PathVariable @NonNull MotoristaId id) {
        return service.buscarPorId(id);
    }
   
    @PutMapping("/{id}")
    public ResponseEntity<Motorista> alterar(@PathVariable @NonNull MotoristaId id, @RequestBody AlterarMotorista cmd){
                cmd.id(id);

                Motorista salvar = service.handle(cmd);
                return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable MotoristaId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
