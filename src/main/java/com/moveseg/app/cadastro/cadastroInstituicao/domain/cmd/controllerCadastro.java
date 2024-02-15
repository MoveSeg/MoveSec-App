package com.moveseg.app.cadastro.cadastroInstituicao.domain.cmd;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.cadastro.cadastroInstituicao.domain.Instituto;
import com.moveseg.app.cadastro.cadastroInstituicao.domain.InstitutoId;
import com.moveseg.app.service.InstitutoService;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RequiredArgsConstructor
@RestController
@RequestMapping("/CadastrarInstituto")
public class controllerCadastro{
    
    InstitutoService service;

@PostMapping
public ResponseEntity<Instituto> postMethodName(@RequestBody Instituto instituto) {

    Instituto salvar = service.salvar(instituto);
    return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
}

@GetMapping("/id")
public ResponseEntity<Instituto> buscarPorid(@PathVariable InstitutoId id) {
    Optional<Instituto> optionalInstituto = service.buscarPorIdInstituto(id);

    if(optionalInstituto.isEmpty()){
        return ResponseEntity.notFound().build();
    }


    return ResponseEntity.status(HttpStatus.OK).body(optionalInstituto.get());
}

@PutMapping("id")
public ResponseEntity alterar( @RequestBody Instituto instituto) {
    
    Instituto salvar = service.salvar(instituto);
    
    return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
}

@DeleteMapping
public ResponseEntity<Void> deletar(@PathVariable InstitutoId id){
    service.deletarInstituto(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
}


}