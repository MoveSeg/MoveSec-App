package com.moveseg.app.checklist.Checklist.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.moveseg.app.checklist.Item.domain.Item;

public final class ChecklistTest {
    private Nome nome;
    private List<Item> itens;
    private Item item;

    private Nome novoNome;
    private List<Item> novosItens;
    private Item novoItem;

    @Test
    void ChecklistCompletoDeveSalvar() throws Exception {
        nome = Nome.of("Checar onibus");
        itens = new ArrayList<Item>();
        itens.add(item);
        Checklist checklist = Checklist.from(nome, itens);
        assertEquals(nome, checklist.nome());
        assertEquals(itens, checklist.itens());
    }
    @Test
    void dadoUmChecklistSemNomeNaoDeveCriar() throws Exception {
        itens = new ArrayList<Item>();
        itens.add(item);
        assertThrows(Exception.class, () -> {
            Checklist.from(null, itens);
        });
    }

    @Test
    void dadoUmChecklistSemObservacaoNaoDeveCriar() throws Exception {
        nome = Nome.of("Checar onibus");
        assertThrows(Exception.class, () -> {
            Checklist.from(nome, null);
        });
    }

    @Test
    void dadoUmChecklistIncorretoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Checklist.from(null, null);
        });
    }

    @Test
    void ChecklistCompletoDeveAtualizar() throws Exception {
        nome = Nome.of("Checar onibus");
        itens = new ArrayList<Item>();
        itens.add(item);

        novoNome = Nome.of("Checar onibus");
        novosItens  = new ArrayList<Item>();
        novosItens.add(novoItem);
        Checklist checklist = Checklist.from(nome, itens);
        checklist.atualizar()
        .nome(novoNome)
        .itens(novoItem).aplicar();
        assertNotNull(checklist.id());
        assertEquals(novoNome, checklist.nome());
        assertEquals(novosItens, checklist.itens());
    }

    @Test
    void dadoUmNomeNuloNaoDeveAtualizar() throws Exception {
        nome = Nome.of("Checar onibus");
        itens = new ArrayList<Item>();
        itens.add(item);

        novosItens = new ArrayList<Item>();
        novosItens.add(novoItem);
        Checklist checklist = Checklist.from(nome, itens);
        assertThrows(Exception.class, () -> {
            checklist.atualizar()
            .itens(novoItem).aplicar();
        });
    }

    @Test
    void dadoUmItemNuloNaoDeveAtualizar() throws Exception {
        nome = Nome.of("Checar onibus");
        itens = new ArrayList<Item>();
        itens.add(item);

        novoNome = Nome.of("Checar onibus");
        Checklist checklist = Checklist.from(nome, itens);
        assertThrows(Exception.class, () -> {
            checklist.atualizar()
            .nome(novoNome).aplicar();
        });
    }
}