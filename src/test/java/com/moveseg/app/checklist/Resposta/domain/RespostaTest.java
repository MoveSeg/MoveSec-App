package com.moveseg.app.checklist.Resposta.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.checklist.Checklist.domain.Checklist;
import com.moveseg.app.checklist.Checklist.domain.Nome;
import com.moveseg.app.checklist.GrupoChecklist.domain.GrupoChecklist;
import com.moveseg.app.checklist.Item.domain.Descricao;
import com.moveseg.app.checklist.Item.domain.Item;
import com.moveseg.app.checklist.Item.domain.Observacao;
import com.moveseg.app.checklist.Resposta.domain.Resposta.RespostaBuilder;

public final class RespostaTest {
    private RespostaBuilder builder;
    private Nome nome;
    private Descricao descricao;
    private Observacao observacao;
    private Long idUsuario;
    private Boolean resposta;
    private LocalDate data;
    private Item item;
    private Checklist checklist;
    private GrupoChecklist grupoChecklist;
    private List<Item> itens = new ArrayList<Item>();
    private List<Checklist> checklists = new ArrayList<Checklist>();

    @BeforeEach
    void initializeBuilder() throws Exception {
        nome = Nome.of("Checar onibus");
        descricao = Descricao.of("Tudo pronto?");
        observacao = Observacao.of("Observe...");
        idUsuario = 0L;
        resposta = true;
        data = LocalDate.now();
        item = Item.from(descricao, resposta, observacao);
        itens.add(item);
        checklist = Checklist.from(nome, itens);
        checklists.add(checklist);
        grupoChecklist = GrupoChecklist.from(nome, checklists);
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
    void dadoUmaRespostaSemGrupoChecklistNaoDeveCriar() {

        builder.grupoChecklist(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmaRespostaSemChecklistNaoDeveCriar() {

        builder.checklist(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmaRespostaSemItemNaoDeveCriar() {

        builder.item(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmaRespostaSemRespostaNaoDeveCriar() {

        builder.resposta(null);
        assertThrows(Exception.class, () -> builder.build());
    }
}