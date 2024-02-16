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
    void dadoNovosDadosDaPlacaDeveAtulizarOVeiculoEManterNaoNulo() throws Exception{
      
        Placa novaPlaca = Placa.of("GHGHGH");

        Veiculo veiculo = this.builder.build();
        veiculo.atualizar().placa(novaPlaca).aplicar();

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

    @Test
    void dadoNovosDadosDoNumeroDafrotaDeveAtulizarOVeiculoEManterNaoNulo() throws Exception{
      Veiculo veiculo= this.builder.build();
        Integer novoNumeroDaFrota = 445;
        this.builder.numeroDaFrota(novoNumeroDaFrota);
        Veiculo veiculoAtualizado = this.builder.build();
        assertEquals(novoNumeroDaFrota, veiculoAtualizado.numeroDaFrota());
    }

    @Test
    void dadoNovosDadosDoChassiDeveAtulizarOVeiculoEManterNaoNulo() throws Exception{
      Veiculo veiculo = this.builder.build();
        Chassi novoChassi = Chassi.of("ADAFAE");
        this.builder.chassi(novoChassi);
        Veiculo veiculoAtualizado = this.builder.build();
        assertEquals(novoChassi, veiculoAtualizado.chassi());
    }

    @Test
    void dadoNovosDadosDoRenavamDeveAtulizarOVeiculoEManterNaoNulo() throws Exception{
      Veiculo veiculo = this.builder.build();
        Renavam novoRenavam = Renavam.of("ighjty");
        this.builder.renavam(novoRenavam);
        Veiculo veiculoAtualizado = this.builder.build();
        assertEquals(novoRenavam, veiculoAtualizado.renavam());
    }

    @Test
    void dadoNovosDadosDoAnoModeloDeveAtulizarOVeiculoEManterNaoNulo() throws Exception{
      Veiculo veiculo = this.builder.build();
        Integer novoAnoModelo = 2024;
        this.builder.anoModelo(novoAnoModelo);
        Veiculo veiculoAtualizado = this.builder.build();
        assertEquals(novoAnoModelo, veiculoAtualizado.anoModelo());
    }

    @Test
    void dadoNovosDadosDaMarcaDeveAtulizaroVeiculoEManterNaoNulo() throws Exception{
      Veiculo veiculo = this.builder.build();
        String novaMarca= "Volkswagen";
        this.builder.marca(novaMarca);
        Veiculo veiculoAtualizado = this.builder.build();
        assertEquals(novaMarca, veiculoAtualizado.marca());
    }

    @Test
    void dadoNovosDadosDoModeloDeveAtulizaroVeiculoEManterNaoNulo() throws Exception{
      Veiculo veiculo = this.builder.build();
        String novoModelo = "Caterpillar";
        this.builder.modelo(novoModelo);
        Veiculo veiculoAtualizado = this.builder.build();
        assertEquals(novoModelo, veiculoAtualizado.modelo());
    }

    @Test
    void dadoNovosDadosDaCorPredominanteDeveAtulizaroVeiculoEManterNaoNulo() throws Exception{
      Veiculo veiculo = this.builder.build();
        String novacorPredominante = "Amarelo";
        this.builder.corPredominante(novacorPredominante);
        Veiculo veiculoAtualizado = this.builder.build();
        assertEquals(novacorPredominante, veiculoAtualizado.corPredominante());
    }

    @Test
    void dadoNovosDadosDaCapacidaDeDepassageirosAtulizaroVeiculoEManterNaoNulo() throws Exception{
      Veiculo veiculo = this.builder.build();
        Integer novaCapacidadeDePassageiros = 30;
        this.builder.capacidadeDePassageiros(novaCapacidadeDePassageiros);
        Veiculo veiculoAtualizado = this.builder.build();
        assertEquals(novaCapacidadeDePassageiros, veiculoAtualizado.capacidadeDePassageiros());
    }
    
    @Test
    void dadoUmVeiculoSemPlacaNaoDeveAlterar() {
        builder.placa(null);
        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemNumeroDaFrotaNaoDeveAlterar() {
        builder.numeroDaFrota(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemChassiNaoDeveAlterar() {
        builder.chassi(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemRenavamNaoDeveAlterar() {
        builder.renavam(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemAnoModeloNaoDeveAlterar() {
        builder.anoModelo(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemmMarcaNaoDeveAlterar() {
        builder.marca(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemModeloNaoDeveAlterar() {
        builder.modelo(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void dadoUmVeiculoSemCorPredominateNaoDeveAlterar() {
        builder.corPredominante(null);

        assertThrows(Exception.class, () -> builder.build());
    }

    @Test
    void  dadoUmVeiculoSemCapacidadeDePassageirosNaoDeveAlterar() {
        builder.capacidadeDePassageiros(null);

        assertThrows(Exception.class, () -> builder.build());
    }




}




















