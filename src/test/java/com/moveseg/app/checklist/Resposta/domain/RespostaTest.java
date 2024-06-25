package com.moveseg.app.checklist.Resposta.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.checklist.Checklist.domain.ChecklistId;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklistId;
import com.moveseg.app.checklist.Item.domain.ItemId;
import com.moveseg.app.checklist.resposta.domain.Resposta;
import com.moveseg.app.checklist.resposta.domain.Resposta.RespostaBuilder;
import com.moveseg.parent.infra.domain.DomainObjectId;

public final class RespostaTest {
    private RespostaBuilder builder;
    private GrupoChecklistId grupoChecklist;
    private ChecklistId checklist;
    private ItemId item;
    private Long idUsuario;
    private Boolean resposta;
    private LocalDate data;

    @BeforeEach
    void initializeBuilder() throws Exception {
        grupoChecklist = DomainObjectId.randomId(GrupoChecklistId.class);
        checklist = DomainObjectId.randomId(ChecklistId.class);
        item = DomainObjectId.randomId(ItemId.class);
        resposta = true;
        idUsuario = 0L;
        data = LocalDate.now();
        this.builder = Resposta.builder()
        .grupoChecklist(grupoChecklist)
        .checklist(checklist)
        .item(item)
        .IdUsuario(idUsuario)
        .resposta(resposta)
        .data(data);
    }

    @Test
    void dadoUmaRespostaCompletaDeveCriar() throws Exception {
        Resposta respostaChecklist = this.builder.build();
        assertNotNull(respostaChecklist);
        assertNotNull(respostaChecklist.id());
        assertNotNull(respostaChecklist.grupoChecklist());
        assertNotNull(respostaChecklist.checklist());
        assertNotNull(respostaChecklist.item());
        assertEquals(resposta, respostaChecklist.resposta());
        assertEquals(data, respostaChecklist.data());
    }

    @Test
    void dadoUmaRespostaSemIdGrupoChecklistNaoDeveCriar() {

        builder.grupoChecklist(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmaRespostaSemIdChecklistNaoDeveCriar() {

        builder.checklist(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmaRespostaSemIdItemNaoDeveCriar() {

        builder.item(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmaRespostaSemRespostaNaoDeveCriar() {

        builder.resposta(null);
        assertThrows(Exception.class, () -> builder.build());
    }
}