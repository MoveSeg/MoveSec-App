package com.moveseg.app.cadastro.veiculo.rest;



import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moveseg.app.cadastro.veiculo.dominio.Veiculo;
import com.moveseg.app.cadastro.veiculo.dominio.VeiculoId;
import com.moveseg.app.cadastro.veiculo.dominio.service.VeiculoService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;



@RequiredArgsConstructor
@RestController
@RequestMapping("/veiculo")

public class VeiculoController {
    
    private final VeiculoService service;

    @PostMapping
    public ResponseEntity<Veiculo> salvar(@RequestBody Veiculo veiculo){
     Veiculo veiculoSalvo = service.salvar(veiculo);
     return ResponseEntity.status(HttpStatus.CREATED).body(veiculoSalvo);
    }
    
    @GetMapping
    public ResponseEntity<List<Veiculo>> listarTodos() {
        List<Veiculo> veiculo = service.listarTodos();
        return ResponseEntity.status(HttpStatus.OK).body(veiculo);
       }

    @GetMapping("/{id}")
    public ResponseEntity<Veiculo> buscarPorId(@PathVariable VeiculoId id) {
       Optional<Veiculo> optVeiculo = service.buscarPorId(id);

       if(optVeiculo.isEmpty()){
        return ResponseEntity.notFound().build();
       }
        return ResponseEntity.status(HttpStatus.OK).body(optVeiculo.get());
       }

    @PutMapping
    public ResponseEntity<Veiculo> alterar(@RequestBody Veiculo veiculo) {
        Veiculo veiculoSalvo = service.salvar(veiculo);
        return ResponseEntity.status(HttpStatus.OK).body(veiculoSalvo);
       }
    

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable String id) {
       service.deletar(id);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
          }
   
}
