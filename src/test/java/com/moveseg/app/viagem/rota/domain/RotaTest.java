package com.moveseg.app.viagem.rota.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.viagem.Rota.domain.Numero;
import com.moveseg.app.viagem.Rota.domain.Rota;

public class RotaTest {
    private Numero numeroRota;
    private Endereco endereco;
    private List<Endereco> enderecos;

    private Numero novoNumeroRota;
    private Endereco novoEndereco;
    private List<Endereco> novosEnderecos;

    @BeforeEach
    void initializeof() throws Exception {
        numeroRota = Numero.of("317R");
        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);

        novosEnderecos = new ArrayList<Endereco>();
        novosEnderecos.add(novoEndereco);
    }

    @Test
    void dadoUmaRotaCompletaDeveCriar() throws Exception {
        Rota rota = Rota.of(numeroRota, enderecos);
        assertNotNull(rota);
        assertNotNull(rota.id());
        assertEquals(numeroRota, rota.numeroRota());
        assertEquals(enderecos, rota.enderecos());
    }

    @Test
    void dadoUmaRotaSemNumeroNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Rota.of(null, enderecos);
        });
    }

    @Test
    void dadoUmaRotaSemEnderecoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Rota.of(numeroRota, null);
        });
    }

    @Test
    void dadoUmaRotaInvalidaNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Rota.of(null, null);
        });
    }

    @Test
    void novasInformaçõesCompletasDeveAtulizarEManterNaoNulo() throws Exception {
        novoNumeroRota = Numero.of("17fh4");
        novosEnderecos = new ArrayList<Endereco>();
        novosEnderecos.add(novoEndereco);
        Rota rota = Rota.of(numeroRota, enderecos);
        rota.atualizar()
                .numeroRota(novoNumeroRota)
                .endereco(novosEnderecos)
                .aplicar();

        assertNotNull(rota);
        assertEquals(novoNumeroRota, rota.numeroRota());
        assertEquals(novosEnderecos, rota.enderecos());
    }

    @Test
    void dadoNumeroNuloNaoDeveAtualizar() {
        assertThrows(Exception.class, () -> {
            Rota rota = Rota.of(numeroRota, enderecos);
            rota.atualizar()
                    .endereco(this.novosEnderecos)
                    .aplicar();

        });
    }

    @Test
    void dadoEnderecoNuloDeveCriarVazio() {
        assertThrows(Exception.class, () -> {
            Rota rota = Rota.of(numeroRota, enderecos);
            rota.atualizar()
                    .numeroRota(this.novoNumeroRota)
                    .aplicar();
        });
    }
}