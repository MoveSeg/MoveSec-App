package com.moveseg.app.cadastro.dominio.veiculo.dominio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.veiculo.domain.Chassi;
import com.moveseg.app.cadastro.veiculo.domain.Placa;
import com.moveseg.app.cadastro.veiculo.domain.Renavam;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo.VeiculoBuilder;

public class VeiculoTest {

    private Placa placa = Placa.of("ASDASD");
    private Chassi chassi = Chassi.of("ASDASD");
    private Renavam renavam = Renavam.of("asdasd");
    private Integer frota = 128;
    private Integer anoModelo = 2012;
    private String marca = "Marca";
    private String modelo = "Modelo";
    private String corPredominante = "Azul";
    private Integer capacidadeDePassageiros = 8;
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
                .corPredominante(corPredominante)
                .capacidadeDePassageiros(capacidadeDePassageiros);
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
        assertEquals(8, veiculo.capacidadeDePassageiros());
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
    void dadoUmVeiculoSemChassiNaoDeveCriar() {
        builder.chassi(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemRenavamNaoDeveCriar() {
        builder.renavam(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemAnoModeloNaoDeveCriar() {
        builder.anoModelo(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemMarcaNaoDeveCriar() {
        builder.marca(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemModeloNaoDeveCriar() {
        builder.modelo(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemCorPredominanteNaoDeveCriar() {
        builder.corPredominante(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemCapacidadeDePassageirosNaoDeveCriar() {
        builder.capacidadeDePassageiros(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoNovosDadosDaPlacaDeveAtualizarOVeiculoEManterNaoNulo() throws Exception{
        Placa novaPlaca =  Placa.of("FGFGFG");  
        Integer novoNumeroDaFrota =  666;  
        Veiculo veiculo = this.builder.build();
        Chassi novoChassi =  Chassi.of("HJHJHJ");  
        Renavam novoRenavam =  Renavam.of("YTYTYT"); 
        Integer novoAnoModelo =  2012;   
        String novaMarca = "Nova marca";
        String novoModelo = "Novo modelo";
        String novaCorPredominante = "Nova cor predominante";
        Integer novaCapacidadeDePassageiros = 66;

        veiculo.atualizar().placa(novaPlaca).aplicar();
        veiculo.atualizar().numeroDaFrota(novoNumeroDaFrota).aplicar();
        veiculo.atualizar().chassi(novoChassi).aplicar();
        veiculo.atualizar().renavam(novoRenavam).aplicar();
        veiculo.atualizar().anoModelo(novoAnoModelo).aplicar();
        veiculo.atualizar().marca(novaMarca).aplicar();
        veiculo.atualizar().modelo(novoModelo).aplicar();
        veiculo.atualizar().corPredominante(novaCorPredominante).aplicar();
        veiculo.atualizar().capacidadeDePassageiros(novaCapacidadeDePassageiros).aplicar();

        assertNotNull(veiculo.id());
        assertEquals(novaPlaca, veiculo.placa());
        assertEquals(128, veiculo.numeroDaFrota());
        assertEquals(chassi, veiculo.chassi());
        assertEquals(renavam, veiculo.renavam());
        assertEquals(2012, veiculo.anoModelo());
        assertEquals("Marca", veiculo.marca());
        assertEquals("Modelo", veiculo.modelo());
        assertEquals("Azul", veiculo.corPredominante());
        assertEquals(8, veiculo.capacidadeDePassageiros());
    }

}
