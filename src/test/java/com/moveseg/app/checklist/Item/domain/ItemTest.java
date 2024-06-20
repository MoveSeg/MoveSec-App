package com.moveseg.app.checklist.Item.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public final class ItemTest {
    private Descricao descricao;
    private Boolean resposta;
    private Observacao observacao;

    private Descricao novaDescricao;
    private Boolean novaResposta;
    private Observacao novaObservacao;

    @Test
    void itemCompletoDeveSalvar() throws Exception {
        descricao = Descricao.of("Tudo pronto?");
        resposta = true;
        observacao = Observacao.of("Observe...");
        Item item = Item.from(descricao, resposta, observacao);
        assertEquals(descricao, item.descricao());
        assertEquals(true, item.resposta());
        assertEquals(observacao, item.observacao());
    }

    @Test
    void dadoUmItemSemDescricaoNaoDeveCriar() throws Exception {
        resposta = true;
        observacao = Observacao.of("Observe...");
        assertThrows(Exception.class, () -> {
            Item.from(null, resposta, observacao);
        });
    }

    @Test
    void dadoUmItemSemRespostaNaoDeveCriar() throws Exception {
        descricao = Descricao.of("Tudo pronto?");
        observacao = Observacao.of("Observe...");
        assertThrows(Exception.class, () -> {
            Item.from(descricao, null, observacao);
        });
    }
    @Test
    void dadoUmItemSemObservacaoNaoDeveCriar() throws Exception {
        descricao = Descricao.of("Tudo pronto?");
        resposta = true;
        assertThrows(Exception.class, () -> {
            Item.from(descricao, resposta, null);
        });
    }

    @Test
    void dadoUmItemIncorretoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Item.from(null, null, null);
        });
    }

    @Test
    void itemCompletoDeveAtualizar() throws Exception {
        descricao = Descricao.of("Tudo pronto?");
        resposta = true;
        observacao = Observacao.of("Observe...");

        novaDescricao = Descricao.of("Tudo quebrado?");
        novaResposta = false;
        novaObservacao = Observacao.of("Observando...");
        Item item = Item.from(descricao, resposta, observacao);
        item.atualizar()
            .descricao(novaDescricao)
            .resposta(novaResposta)
            .observacao(novaObservacao).aplicar();
        assertNotNull(item.id());
        assertEquals(novaDescricao, item.descricao());
        assertEquals(false, item.resposta());
        assertEquals(novaObservacao, item.observacao());
    }

    @Test
    void dadoUmaDescricaoNulaNaoDeveAtualizar() throws Exception {
        descricao = Descricao.of("Tudo pronto?");
        resposta = true;
        observacao = Observacao.of("Observe...");

        novaResposta = false;
        novaObservacao = Observacao.of("Observando...");
        Item item = Item.from(descricao, resposta, observacao);
        assertThrows(Exception.class, () -> {
            item.atualizar()
            .resposta(novaResposta)
            .observacao(novaObservacao).aplicar();
        });
    }

    @Test
    void dadoUmaRespostaNulaNaoDeveAtualizar() throws Exception {
        descricao = Descricao.of("Tudo pronto?");
        resposta = true;
        observacao = Observacao.of("Observe...");

        novaDescricao = Descricao.of("Tudo quebrado?");
        novaObservacao = Observacao.of("Observando...");
        Item item = Item.from(descricao, resposta, observacao);
        assertThrows(Exception.class, () -> {
            item.atualizar()
            .descricao(novaDescricao)
            .observacao(novaObservacao).aplicar();
        });
    }

    @Test
    void dadoUmaObservacaoNulaNaoDeveAtualizar() throws Exception {
        descricao = Descricao.of("Tudo pronto?");
        resposta = true;
        observacao = Observacao.of("Observe...");

        novaDescricao = Descricao.of("Tudo quebrado?");
        novaResposta = false;
        novaObservacao = Observacao.of("Observando...");
        Item item = Item.from(descricao, resposta, observacao);
        assertThrows(Exception.class, () -> {
            item.atualizar()
            .descricao(novaDescricao)
            .resposta(novaResposta).aplicar();
        });
    }
}