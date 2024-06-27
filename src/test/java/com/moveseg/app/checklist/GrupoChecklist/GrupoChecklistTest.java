package com.moveseg.app.checklist.GrupoChecklist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.Nome;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklist;

public final class GrupoChecklistTest {
    private Nome nome;
    private List<Checklist> checklists;
    private Checklist checklist;

    private Nome novoNome;
    private List<Checklist> novosChecklists;
    private Checklist novoChecklist;

    @Test
    void GrupoChecklistCompletoDeveSalvar() throws Exception {
        nome = Nome.of("Motorista");
        checklists = new ArrayList<Checklist>();
        checklists.add(checklist);
        GrupoChecklist grupoChecklist = GrupoChecklist.from(nome, checklists);
        assertEquals(nome, grupoChecklist.nome());
        assertEquals(checklists, grupoChecklist.checklists());
    }
    @Test
    void dadoUmGrupoChecklistSemNomeNaoDeveCriar() throws Exception {
        checklists = new ArrayList<Checklist>();
        checklists.add(checklist);
        assertThrows(Exception.class, () -> {
            GrupoChecklist.from(null, checklists);
        });
    }

    @Test
    void dadoUmGrupoChecklistSemCheckilistsNaoDeveCriar() throws Exception {
        nome = Nome.of("Motorista");
        assertThrows(Exception.class, () -> {
            GrupoChecklist.from(nome, null);
        });
    }

    @Test
    void dadoUmGrupoChecklistIncorretoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            GrupoChecklist.from(null, null);
        });
    }

    @Test
    void GrupoChecklistCompletoDeveAtualizar() throws Exception {
        nome = Nome.of("Motorista");
        checklists = new ArrayList<Checklist>();
        checklists.add(checklist);

        novoNome = Nome.of("Onibus");
        novosChecklists  = new ArrayList<Checklist>();
        novosChecklists.add(novoChecklist);
        GrupoChecklist grupoChecklist = GrupoChecklist.from(nome, novosChecklists);
        grupoChecklist.atualizar()
        .nome(novoNome)
        .checklist(novosChecklists).aplicar();
        assertNotNull(grupoChecklist.id());
        assertEquals(novoNome, grupoChecklist.nome());
        assertEquals(novosChecklists, grupoChecklist.checklists());
    }

    @Test
    void dadoUmNomeNuloNaoDeveAtualizar() throws Exception {
        nome = Nome.of("Motorista");
        checklists = new ArrayList<Checklist>();
        checklists.add(checklist);

        novosChecklists  = new ArrayList<Checklist>();
        novosChecklists.add(novoChecklist);
        GrupoChecklist grupoChecklist = GrupoChecklist.from(nome, checklists);
        assertThrows(Exception.class, () -> {
            grupoChecklist.atualizar()
            .checklist(novosChecklists).aplicar();
        });
    }

    @Test
    void dadoUmChecklistNuloNaoDeveAtualizar() throws Exception {
        nome = Nome.of("Motorista");
        checklists = new ArrayList<Checklist>();
        checklists.add(checklist);

        novoNome = Nome.of("Onibus");
        GrupoChecklist grupoChecklist = GrupoChecklist.from(nome, checklists);
        assertThrows(Exception.class, () -> {
            grupoChecklist.atualizar()
            .nome(novoNome).aplicar();
        });
    }
}
