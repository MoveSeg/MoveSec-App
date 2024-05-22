package com.moveseg.app.viagem.rota.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.viagem.Rota.domain.Numero;
import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class RotaTest {
    private Numero numeroRota;
    private Endereco endereco;
    private VeiculoId veiculo;
    private List<Endereco> enderecos;

    private Numero novoNumeroRota;
    private Endereco novoEndereco;
    private List<Endereco> novosEnderecos;
    private VeiculoId novoVeiculo;

    @BeforeEach
    void initializeof() throws Exception {
        veiculo = DomainObjectId.randomId(VeiculoId.class);
        numeroRota = Numero.of("317R");

        enderecos = new ArrayList<Endereco>();
        enderecos.add(endereco);

        novosEnderecos = new ArrayList<Endereco>();
        novosEnderecos.add(novoEndereco);
    }

    @Test
    void dadoUmaRotaCompletaDeveCriar() throws Exception {
        Rota rota = Rota.of(numeroRota, veiculo, enderecos);
        assertNotNull(rota);
        assertNotNull(rota.id());
        assertNotNull(rota.veiculo());
        assertEquals(numeroRota, rota.numeroRota());
        assertEquals(enderecos, rota.enderecos());
    }

    @Test
    void dadoUmaRotaSemNumeroNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Rota.of(null, veiculo, enderecos);
        });
    }

    @Test
    void dadoUmaRotaSemEnderecoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Rota.of(numeroRota, veiculo, null);
        });
    }

    @Test
    void dadoUmaRotaSemVeiculoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Rota.of(numeroRota, null, enderecos);
        });
    }

    @Test
    void dadoUmaRotaInvalidaNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            Rota.of(null, null, null);
        });
    }

    @Test
    void novasInformaçõesCompletasDeveAtulizarEManterNaoNulo() throws Exception {
        novoVeiculo = DomainObjectId.randomId(VeiculoId.class);
        novoNumeroRota = Numero.of("17fh4");
        Rota rota = Rota.of(numeroRota, veiculo, enderecos);
        rota.atualizar()
                .numeroRota(novoNumeroRota)
                .endereco(this.novoEndereco)
                .veiculo(this.novoVeiculo)
                .aplicar();

        assertNotNull(rota);
        assertEquals(novoNumeroRota, rota.numeroRota());
        assertEquals(novosEnderecos, rota.enderecos());
        assertEquals(novoVeiculo, rota.veiculo());
    }

    @Test
    void dadoNumeroNuloNaoDeveAtualizar() {
        assertThrows(Exception.class, () -> {
            novoVeiculo = DomainObjectId.randomId(VeiculoId.class);
            Rota rota = Rota.of(numeroRota, veiculo, enderecos);
            rota.atualizar()
                    .endereco(this.novoEndereco)
                    .veiculo(this.novoVeiculo)
                    .aplicar();

        });
    }

    @Test
    void dadoEnderecoNuloDeveCriarVazio() {
        assertThrows(Exception.class, () -> {
            novoVeiculo = DomainObjectId.randomId(VeiculoId.class);
            Rota rota = Rota.of(numeroRota, veiculo, enderecos);
            rota.atualizar()
                    .numeroRota(this.novoNumeroRota)
                    .veiculo(this.novoVeiculo)
                    .aplicar();
        });
    }

    @Test
    void dadoVeiculoNuloDeveCriarVazio() {
        assertThrows(Exception.class, () -> {
            Rota rota = Rota.of(numeroRota, veiculo, enderecos);
            rota.atualizar()
                    .numeroRota(this.novoNumeroRota)
                    .endereco(this.novoEndereco)
                    .aplicar();
        });
    }

}