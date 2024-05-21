package com.moveseg.app.cadastro.Veiculo.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.veiculo.domain.Veiculo.VeiculoBuilder;

class VeiculoTest {

    public Placa novaPlaca;
    public Integer novoNumeroDaFrota;
    public Chassi novoChassi;
    public Renavam novoRenavam;
    public Integer novoAnoModelo;
    public String novaMarca;
    public String novoModelo;
    public String novaCorPredominante;
    public Integer novaCapacidadeDePassageiros;

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
    void dadoNovosDadosDaPlacaDeveAtualizarOVeiculoEManterNaoNulo() throws Exception {
        Placa novaPlaca = Placa.of("FGFGFG");
        Integer novoNumeroDaFrota = 666;
        Chassi novoChassi = Chassi.of("HJHJHJ");
        Renavam novoRenavam = Renavam.of("YTYTYT");
        Integer novoAnoModelo = 2012;
        String novaMarca = "Nova marca";
        String novoModelo = "Novo modelo";
        String novaCorPredominante = "Nova cor predominante";
        Integer novaCapacidadeDePassageiros = 66;

        Veiculo veiculo = this.builder.build();
        veiculo.update()
                .placa(novaPlaca)
                .numeroDaFrota(novoNumeroDaFrota)
                .chassi(novoChassi)
                .renavam(novoRenavam)
                .anoModelo(novoAnoModelo)
                .marca(novaMarca)
                .modelo(novoModelo)
                .corPredominante(novaCorPredominante)
                .capacidadeDePassageiros(novaCapacidadeDePassageiros).apply();

        assertNotNull(veiculo.id());
        assertEquals(novaPlaca, veiculo.placa());
        assertEquals(novoNumeroDaFrota, veiculo.numeroDaFrota());
        assertEquals(novoChassi, veiculo.chassi());
        assertEquals(novoRenavam, veiculo.renavam());
        assertEquals(novoAnoModelo, veiculo.anoModelo());
        assertEquals(novaMarca, veiculo.marca());
        assertEquals(novoModelo, veiculo.modelo());
        assertEquals(novaCorPredominante, veiculo.corPredominante());
        assertEquals(novaCapacidadeDePassageiros, veiculo.capacidadeDePassageiros());
    }

    @Test
    void dadoUmaPlacaNulaNaoDeveAtualizar() {
        Veiculo veiculo = this.builder.build();
        assertThrows(Exception.class, () -> {
            veiculo.update()

                    .numeroDaFrota(novoNumeroDaFrota)
                    .chassi(novoChassi)
                    .renavam(novoRenavam)
                    .anoModelo(novoAnoModelo)
                    .marca(novaMarca)
                    .modelo(novoModelo)
                    .corPredominante(novaCorPredominante)
                    .capacidadeDePassageiros(novaCapacidadeDePassageiros).apply();
        });
    }

    @Test
    void dadoUmNumeroDaFrotaNulaNaoDeveAtualizar() {
        Veiculo veiculo = this.builder.build();
        assertThrows(Exception.class, () -> {
            veiculo.update()

                    .placa(novaPlaca)
                    .chassi(novoChassi)
                    .renavam(novoRenavam)
                    .anoModelo(novoAnoModelo)
                    .marca(novaMarca)
                    .modelo(novoModelo)
                    .corPredominante(novaCorPredominante)
                    .capacidadeDePassageiros(novaCapacidadeDePassageiros).apply();
        });
    }

    @Test
    void dadoUmChassiNulaNaoDeveAtualizar() {
        Veiculo veiculo = this.builder.build();
        assertThrows(Exception.class, () -> {
            veiculo.update()

                    .placa(novaPlaca)
                    .numeroDaFrota(novoNumeroDaFrota)
                    .renavam(novoRenavam)
                    .anoModelo(novoAnoModelo)
                    .marca(novaMarca)
                    .modelo(novoModelo)
                    .corPredominante(novaCorPredominante)
                    .capacidadeDePassageiros(novaCapacidadeDePassageiros).apply();
        });
    }

    @Test
    void dadoUmRenavamNulaNaoDeveAtualizar() {
        Veiculo veiculo = this.builder.build();
        assertThrows(Exception.class, () -> {
            veiculo.update()

                    .placa(novaPlaca)
                    .chassi(novoChassi)
                    .numeroDaFrota(novoNumeroDaFrota)
                    .anoModelo(novoAnoModelo)
                    .marca(novaMarca)
                    .modelo(novoModelo)
                    .corPredominante(novaCorPredominante)
                    .capacidadeDePassageiros(novaCapacidadeDePassageiros).apply();
        });
    }

    @Test
    void dadoUmAnoModeloNuloNaoDeveAtualizar() {
        Veiculo veiculo = this.builder.build();
        assertThrows(Exception.class, () -> {
            veiculo.update()

                    .placa(novaPlaca)
                    .chassi(novoChassi)
                    .renavam(novoRenavam)
                    .numeroDaFrota(novoNumeroDaFrota)
                    .marca(novaMarca)
                    .modelo(novoModelo)
                    .corPredominante(novaCorPredominante)
                    .capacidadeDePassageiros(novaCapacidadeDePassageiros).apply();
        });
    }

    @Test
    void dadoUmaMarcaNulaNaoDeveAtualizar() {
        Veiculo veiculo = this.builder.build();
        assertThrows(Exception.class, () -> {
            veiculo.update()

                    .placa(novaPlaca)
                    .chassi(novoChassi)
                    .renavam(novoRenavam)
                    .numeroDaFrota(novoNumeroDaFrota)
                    .anoModelo(novoAnoModelo)
                    .modelo(novoModelo)
                    .corPredominante(novaCorPredominante)
                    .capacidadeDePassageiros(novaCapacidadeDePassageiros).apply();
        });
    }

    @Test
    void dadoUmModeloNuloNaoDeveAtualizar() {
        Veiculo veiculo = this.builder.build();
        assertThrows(Exception.class, () -> {
            veiculo.update()

                    .placa(novaPlaca)
                    .chassi(novoChassi)
                    .renavam(novoRenavam)
                    .numeroDaFrota(novoNumeroDaFrota)
                    .marca(novaMarca)
                    .anoModelo(novoAnoModelo)
                    .corPredominante(novaCorPredominante)
                    .capacidadeDePassageiros(novaCapacidadeDePassageiros).apply();
        });
    }

    @Test
    void dadoUmaCorPredominanteNulaNaoDeveAtualizar() {
        Veiculo veiculo = this.builder.build();
        assertThrows(Exception.class, () -> {
            veiculo.update()

                    .placa(novaPlaca)
                    .chassi(novoChassi)
                    .renavam(novoRenavam)
                    .numeroDaFrota(novoNumeroDaFrota)
                    .marca(novaMarca)
                    .anoModelo(novoAnoModelo)
                    .modelo(novoModelo)
                    .capacidadeDePassageiros(novaCapacidadeDePassageiros).apply();
        });
    }

    @Test
    void dadoUmaCapacidadeDePassageirosNuloNaoDeveAtualizar() {
        Veiculo veiculo = this.builder.build();
        assertThrows(Exception.class, () -> {
            veiculo.update()

                    .placa(novaPlaca)
                    .chassi(novoChassi)
                    .renavam(novoRenavam)
                    .numeroDaFrota(novoNumeroDaFrota)
                    .marca(novaMarca)
                    .anoModelo(novoAnoModelo)
                    .corPredominante(novaCorPredominante)
                    .modelo(novoModelo).apply();
        });
    }

}
