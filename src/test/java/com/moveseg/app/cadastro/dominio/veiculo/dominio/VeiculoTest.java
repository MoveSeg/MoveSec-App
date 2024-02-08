package com.moveseg.app.cadastro.dominio.veiculo.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.veiculo.dominio.Chassi;
import com.moveseg.app.cadastro.veiculo.dominio.Placa;
import com.moveseg.app.cadastro.veiculo.dominio.Renavam;
import com.moveseg.app.cadastro.veiculo.dominio.Veiculo;
import com.moveseg.app.cadastro.veiculo.dominio.Veiculo.VeiculoBuilder;

public class VeiculoTest {
    /*
     * TODO:
     * - Teste de sucesso na criação
     * - Teste de falha na criação
     * - Teste de alteração
     * - sucesso
     * - falha
     * - etc
     * 
     * // Given when then
     * // Arrange act assert
     */

    private Placa placa = Placa.of("ASDASD");
    private Chassi chassi = Chassi.of("ASDASD");
    private Renavam renavam = Renavam.of("asdasd");
    private Integer frota = 128;
    private Integer anoModelo = 2012;
    private String marca = "Marca";
    private String modelo = "Modelo";
    private String corPredominante = "Azul";
    private Integer capacidadePassageiros = 0;
    private VeiculoBuilder builder;

    @BeforeEach
    void initializeBuilder() {
        builder = Veiculo.builder()
                .placa(placa)
                .numeroDaFrota(frota)
                .chassi(chassi)
                .renavam(renavam)
                .anoModelo(anoModelo)
                .marca(marca)
                .modelo(modelo)
                .corPredominate(corPredominante)
                .capacidadeDePassgeiros(capacidadePassageiros);
    }

    @Test
    void dadoUmVeiculoCompletoDeveCriar() throws Exception {

        Veiculo veiculo = builder
                .build();

        assertNotNull(veiculo);
        assertNotNull(veiculo.id());
        assertEquals(placa, veiculo.placa());
        assertEquals(128, veiculo.numeroDaFrota());
        assertEquals(chassi, veiculo.chassi());
        assertEquals(renavam, veiculo.renavam());
        assertEquals(2012, veiculo.anoModelo());
        assertEquals("Marca", veiculo.marca());
        assertEquals("Modelo", veiculo.modelo());
        assertEquals("Azul", veiculo.corPredominante());
        assertEquals(0, veiculo.capacidadeDePassageiros());
    }

    @Test
    void dadoUmVeiculoSemPlacaNaoDeveCriar() {

        builder.placa(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemNumeroFrotaNaoDeveCriar() {
        builder.numeroDaFrota(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoChassiNaoDeveCriar() {
        builder.chassi(null);

        assertThrows(Exception.class, () -> builder.build());
    }
}