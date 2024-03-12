package com.moveseg.app.viagem.rota.domain;

import static com.moveseg.parent.infra.domain.DomainObjectId.randomId;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.moveseg.app.cadastro.Instituto.domain.Endereco;
import com.moveseg.app.cadastro.responsavel.domain.Responsavel;
import com.moveseg.app.cadastro.veiculo.domain.Veiculo;
import com.moveseg.app.cadastro.veiculo.domain.VeiculoId;
import com.moveseg.app.viagem.Rota.domain.Numero;
import com.moveseg.app.viagem.Rota.domain.Rota;
import com.moveseg.app.viagem.Rota.domain.RotaId;
import com.moveseg.parent.infra.domain.DomainObject;
import com.moveseg.parent.infra.domain.DomainObjectId;

public class RotaTest {
    private Numero numero = "317R";
    private RotaId id;
    private List<Endereco> enderecos;

    private Numero novoNumero;
    private List<Endereco> novosEnderecos;

    @Test
    void dadoUmaRotaCompletaDeveCriar() throws Exception {
        VeiculoId veiculo = DomainObjectId.randomId(VeiculoId.class);
        Rota rota = Rota.of(id, numero, enderecos, veiculo);

        assertNotNull(rota);
        assertNotNull(rota.id());
        assertNotNull(rota.veiculo());
        assertEquals(numero, rota.numero());
        assertEquals(enderecos, rota.enderecos());
    }

    
    @Test
    void dadoUmaRotaSemVeiculoNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            VeiculoId veiculo = DomainObjectId.randomId(VeiculoId.class);
            Rota.of(null,"317R", "Rua 44 jardins", veiculo);
        });
    }

    @Test
    void dadoUmaRotaSemNumeroNaoDeveCriar() {
        assertThrows(Exception.class, () -> {
            VeiculoId veiculo = DomainObjectId.randomId(VeiculoId.class);
            Rota.of(id, null, "Rua 44 jardins", veiculo);
        });
    }

    @Test 
    void dadoUmaRotaSemEnderecoNaoDeveCriar(){
        assertThrows(Exception.class, () -> {
            VeiculoId veiculo = DomainObjectId.randomId(VeiculoId.class);
            Rota.of(id, "317R", null, veiculo );
    });
}

@Test 
    void dadoUmaRotaInvalidaNaoDeveCriar(){
        assertThrows(Exception.class, () -> {
            Rota.of(null, null, null, null);
    });
}
}