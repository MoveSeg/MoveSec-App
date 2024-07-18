package com.moveseg.app.checklist.Item.ui;

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

import com.moveseg.app.checklist.Item.app.ItemService;
import com.moveseg.app.checklist.Item.app.view.ItemFormView;
import com.moveseg.app.checklist.Item.app.view.ItemListView;
import com.moveseg.app.checklist.Item.domain.Item;
import com.moveseg.app.checklist.Item.domain.ItemId;
import com.moveseg.app.checklist.Item.domain.cmd.AlterarItem;
import com.moveseg.app.checklist.Item.domain.cmd.CriarItem;

import lombok.AllArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/item", produces = APPLICATION_JSON_VALUE)
public class ItemController {
    
    ItemService service;

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> salvar(@RequestBody CriarItem cmd) {
        ItemId id = service.handle(cmd);

        return ResponseEntity.created(fromCurrentRequest() 
                .path("/").path(id.toUUID()).build().toUri())
                .build();
    }

    @GetMapping
    public List<ItemListView> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public ItemFormView buscarPorId(@PathVariable @NonNull ItemId id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Item> alterar(@PathVariable @NonNull ItemId id, @RequestBody AlterarItem cmd) {

        cmd.id(id);

        Item salvar = service.handle(cmd);
        return ResponseEntity.status(HttpStatus.CREATED).body(salvar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable @NonNull ItemId id) {
        service.deletar(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
